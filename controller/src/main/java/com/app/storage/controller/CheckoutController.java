package com.app.storage.controller;

import com.app.storage.domain.model.payment.PaymentTransaction;
import com.app.storage.service.ItemListingService;
import com.app.storage.service.payment.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Checkout and buy items controller.
 */
@Controller
@RequestMapping(value = "/")
public class CheckoutController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(CheckoutController.class);

    /** {@link BasketController}. */
    private final BasketController basketController;

    /** {@link ItemListingService}. */
    private final ItemListingService itemListingService;

    /** {@link PaymentService}. */
    private final PaymentService paymentService;

    /**
     * Controller
     *
     * @param basketController
     *         {@link BasketController}
     * @param itemListingService
     *         {@link BasketController}
     */
    public CheckoutController(final BasketController basketController,
                              final ItemListingService itemListingService,
                              final PaymentService paymentService) {
        this.basketController = basketController;
        this.itemListingService = itemListingService;
        this.paymentService = paymentService;
    }

    /**
     * Renders Checkout view to container.
     *
     * @return Checkout.jsp
     */
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView renderCheckout() {

        paymentService.initialiseGateway();

        final Double totalPrice = itemListingService.calculateTotalPrice(basketController.getBasketSet());

        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("payment/Checkout");
        modelAndView.addObject("totalPrice", totalPrice);
        modelAndView.addObject("basketItems", basketController.getBasketSet());
        modelAndView.addObject("userToken", paymentService.generateClientToken());
        modelAndView.addObject("paymentTransaction", new PaymentTransaction());

        LOG.debug("Rendering checkout jsp");

        return modelAndView;
    }

    /**
     * Handles checkout payment and success/failure view redirect.
     *
     * @return {@link ModelAndView}
     */
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ModelAndView handleCheckout(@ModelAttribute("paymentInformation") final PaymentTransaction
                                                   paymentTransaction,
                                       final Principal principal) {

        LOG.debug("Returning payment details: {}", paymentTransaction.toString());

        paymentTransaction.setCustomerRef(principal.getName());
        paymentTransaction.setPaymentNonce("fake-valid-debit-nonce");

        final boolean transactionResponse = paymentService.executeTransaction(paymentTransaction);

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("paymentTransaction", paymentTransaction);

        if (transactionResponse) {
            modelAndView.setViewName("payment/CheckoutSuccess");
        } else {
            modelAndView.setViewName("payment/CheckoutFailure");
        }

        LOG.debug("Returning model and view objects for {} transaction response", transactionResponse);

        return modelAndView;
    }
}
