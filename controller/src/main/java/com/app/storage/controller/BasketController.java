package com.app.storage.controller;

import com.app.storage.controller.mapper.StorageItemControllerMapper;
import com.app.storage.controller.model.StorageItemControllerModel;
import com.app.storage.domain.model.StorageItem;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.service.StorageItemService;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    private final Set<StorageItem> basketList = new LinkedHashSet<>();

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

        basketList.add(storageItem);

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

        final StorageItem storageItem = storageItemService.findStorageItemByReference(uniqueRef);

        basketList.remove(storageItem);

        LOG.debug("Removed item: {}", storageItem);

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

        final Double totalPrice = storageItemService.calculateTotalPrice(basketList);

        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("core/Basket");
        modelAndView.addObject("totalPrice", totalPrice);
        modelAndView.addObject("basketItems", basketList);

        LOG.debug("Set contains: {}", basketList);

        return modelAndView;
    }
}
