package com.app.storage.controller;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.service.StorageItemService;
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
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemController.class);

    /** {@link StorageItemService} */
    private final StorageItemService storageItemService;

    /** List of {@link StorageItem} added to basket. */
    private final Set<StorageItem> basketSet = new LinkedHashSet<>();

    /**
     * Constructor.
     *
     * @param storageItemService
     *         Storage item service.
     */
    @Autowired
    public BasketController(final StorageItemService storageItemService) {
        this.storageItemService = storageItemService;
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

        final StorageItem storageItem = storageItemService.findStorageItemByReference(uniqueRef);

        basketSet.add(storageItem);

        LOG.debug("Appended item: {}", storageItem);

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

        final Double totalPrice = storageItemService.calculateTotalPrice(basketSet);

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

        for (final StorageItem storageItem : basketSet) {

            if (storageItem.getReference().equals(uniqueRef)) {
                basketSet.remove(storageItem);
                break;
            }
        }

        Validate.isTrue(basketSet.size() == basketSize - 1);
    }

    /**
     * Gets List of {@link StorageItem} added to basket..
     *
     * @return Value of List of {@link StorageItem} added to basket..
     */
    public Set<StorageItem> getBasketSet() {
        return basketSet;
    }
}
