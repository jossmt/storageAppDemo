package com.app.storage.controller;

import com.app.storage.service.StorageItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    /** {@link StorageItemService}. */
    private final StorageItemService storageItemService;

    /**
     * Controller
     *
     * @param basketController
     *         {@link BasketController}
     * @param storageItemService
     *         {@link BasketController}
     */
    public CheckoutController(final BasketController basketController,
                              final StorageItemService storageItemService) {
        this.basketController = basketController;
        this.storageItemService = storageItemService;
    }

    /**
     * Renders Checkout view to container.
     *
     * @return Checkout.jsp
     */
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView renderAbout() {

        final Double totalPrice = storageItemService.calculateTotalPrice(basketController.getBasketSet());

        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("payment/Checkout");
        modelAndView.addObject("totalPrice", totalPrice);
        modelAndView.addObject("basketItems", basketController.getBasketSet());

        LOG.debug("Rendering checkout jsp");

        return modelAndView;
    }

    @RequestMapping(value = "/cardData", method = RequestMethod.GET)
    public String getCardData(){

        return "payment/CardPayment.html";
    }
}
