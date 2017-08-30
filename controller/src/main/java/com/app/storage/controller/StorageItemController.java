package com.app.storage.controller;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.service.StorageItemService;
import com.app.storage.service.UserService;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller for storage item requests.
 */
@Controller
@RequestMapping(value = "/")
public class StorageItemController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemController.class);

    /** {@link StorageItemService} */
    private final StorageItemService storageItemService;

    /** {@link UserService} */
    private final UserService userService;

    /**
     * Constructor.
     *
     * @param storageItemService
     *         Storage item service.
     * @param userService
     *         User service.
     */
    @Autowired
    public StorageItemController(final StorageItemService storageItemService,
                                 final UserService userService) {
        this.storageItemService = storageItemService;
        this.userService = userService;
    }

    /**
     * Renders storage view to container.
     *
     * @return Storage.jsp
     */
    @RequestMapping(value = "/item/{reference}", method = RequestMethod.GET)
    public ModelAndView renderStorage(@PathVariable final String reference) {
        LOG.debug("Getting stored items with ref: {}", reference);

        final ModelAndView modelAndView = new ModelAndView();

        final StorageItem storageItem = storageItemService.findStorageItemByReference(reference);

        LOG.debug("Successfully returned storage item {} with reference {}.", storageItem, reference);

        modelAndView.setViewName("core/StorageSingle");
        modelAndView.addObject("storageItem", storageItem);

        return modelAndView;
    }

    /**
     * Renders storage view to container.
     *
     * @return Storage.jsp
     */
    @RequestMapping(value = "/discover", method = RequestMethod.GET)
    public ModelAndView renderStorage() {
        LOG.debug("Getting all stored items.");

        final ModelAndView modelAndView = new ModelAndView();

        final List<StorageItem> storageItems = storageItemService.retrieveAllStorageItems();

        LOG.debug("Successfully returned all stored items: {}.", storageItems);

        modelAndView.setViewName("core/Storage");
        modelAndView.addObject("storageItems", storageItems);

        return modelAndView;
    }

    /**
     * Renders storage view to container.
     *
     * @return Storage.jsp
     */
    @RequestMapping(value = "/myItems", method = RequestMethod.GET)
    public ModelAndView renderStorage(final Authentication authentication) {

        Validate.isTrue(authentication.getPrincipal() != null);
        Validate.isTrue(authentication.isAuthenticated());

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        LOG.debug("Getting all stored items for user: {}", userDetails.getUsername());

        final ModelAndView modelAndView = new ModelAndView();

        final User user = userService.loadUserStorage(userDetails.getUsername());

        LOG.debug("Successfully returned all stored items: {} for user: {}.", user.getStorageItems(), user
                .getFirstName());

        modelAndView.setViewName("core/Storage");
        modelAndView.addObject("storageItems", user.getStorageItems());

        return modelAndView;
    }
}
