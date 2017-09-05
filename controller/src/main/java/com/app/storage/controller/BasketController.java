package com.app.storage.controller;

import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.service.ItemListingService;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Controller for storage item requests.
 */
@Controller
@RequestMapping(value = "/")
public class BasketController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(ItemListingController.class);

    /** {@link ItemListingService} */
    private final ItemListingService itemListingService;

    /** List of {@link ItemListing} added to basket. */
    private final Set<ItemListing> basketSet = new LinkedHashSet<>();

    /**
     * Constructor.
     *
     * @param itemListingService
     *         Storage item service.
     */
    @Autowired
    public BasketController(final ItemListingService itemListingService) {
        this.itemListingService = itemListingService;
    }

    /**
     * Add item to basket.
     *
     * @return Basket.jsp
     */
    @RequestMapping(value = "/addToBasket", method = RequestMethod.POST)
    public ModelAndView addToBasket(@ModelAttribute("uniqueRef") final String uniqueRef) {
        LOG.debug("Adding storage item to basket : {}", uniqueRef);

        final ModelAndView modelAndView = new ModelAndView();

        final ItemListing itemListing = itemListingService.findStorageItemByReference(uniqueRef);

        basketSet.add(itemListing);

        LOG.debug("Appended item: {}", itemListing);

        modelAndView.setViewName("redirect:/basket");

        return modelAndView;
    }

    /**
     * Add item to basket.
     *
     * @return Basket.jsp
     */
    @RequestMapping(value = "/removeFromBasket", method = RequestMethod.POST)
    public ModelAndView removeFromBasket(@ModelAttribute("uniqueRef") final String uniqueRef) {
        LOG.debug("Removing storage item from basket : {}", uniqueRef);

        final ModelAndView modelAndView = new ModelAndView();

        removeBasketItem(uniqueRef);

        LOG.debug("Removed item with ref: {}", uniqueRef);

        modelAndView.setViewName("redirect:/basket");

        return modelAndView;
    }

    /**
     * Renders default view to container as home.
     *
     * @return Home.jsp
     */
    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public ModelAndView renderBasket() {

        final Double totalPrice = itemListingService.calculateTotalPrice(basketSet);

        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("core/Basket");
        modelAndView.addObject("totalPrice", totalPrice);
        modelAndView.addObject("basketItems", basketSet);

        LOG.debug("Set contains: {}", basketSet);

        return modelAndView;
    }

    /**
     * Removes item from basket.
     *
     * @param uniqueRef
     *         Unique reference code of item to be removed.
     */
    private void removeBasketItem(final String uniqueRef) {

        final Integer basketSize = basketSet.size();

        for (final ItemListing itemListing : basketSet) {

            if (itemListing.getReference().equals(uniqueRef)) {
                basketSet.remove(itemListing);
                break;
            }
        }

        Validate.isTrue(basketSet.size() == basketSize - 1);
    }

    /**
     * Gets List of {@link ItemListing} added to basket..
     *
     * @return Value of List of {@link ItemListing} added to basket..
     */
    public Set<ItemListing> getBasketSet() {
        return basketSet;
    }
}
