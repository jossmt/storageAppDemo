package com.app.storage.controller;

import com.app.storage.controller.mapper.StorageItemControllerMapper;
import com.app.storage.controller.model.StorageItemControllerModel;
import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.service.StorageItemService;
import com.app.storage.service.UserService;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

/**
 * Returns views for core UI switching.
 */
@Controller
@RequestMapping("/")
public class ViewsController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemController.class);

    /** {@link StorageItemService} */
    private final StorageItemService storageItemService;

    /** {@link UserService} */
    private final UserService userService;

    /** {@link StorageItemControllerMapper} */
    private final StorageItemControllerMapper storageItemControllerMapper;

    /** {@link ListMapper} */
    private final ListMapper listMapper;

    /**
     * Constructor.
     *
     * @param storageItemService
     *         {@link StorageItemService}
     * @param storageItemControllerMapper
     *         {@link StorageItemControllerMapper}
     */
    @Autowired
    public ViewsController(final StorageItemService storageItemService,
                           final StorageItemControllerMapper storageItemControllerMapper,
                           final UserService userService) {

        listMapper = new ListMapper();
        this.storageItemService = storageItemService;
        this.userService = userService;
        this.storageItemControllerMapper = storageItemControllerMapper;
    }

    /**
     * Renders default view to container as home.
     *
     * @return Home.jsp
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderTemplate() {

        return "about/Home";
    }

    /**
     * Renders home view to container.
     *
     * @return Home.jsp
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String renderHome() {

        return "about/Home";
    }

    /**
     * Renders About view to container.
     *
     * @return About.jsp
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String renderAbout() {
        return "about/About";
    }

    /**
     * Renders requests view to container.
     *
     * @return Requests.jsp
     */
    @RequestMapping(value = "/myrequests", method = RequestMethod.GET)
    public String renderRequests() {

        return "core/Requests";
    }

    /**
     * Renders storage view to container.
     *
     * @return Storage.jsp
     */
    @RequestMapping(value = "/mystorage", method = RequestMethod.GET)
    public ModelAndView renderStorage() {
        LOG.debug("Getting all stored items.");

        final ModelAndView modelAndView = new ModelAndView();

        final List<StorageItem> storageItems = storageItemService.retrieveAllStorageItems();

        final List<StorageItemControllerModel> storageItemControllerModels = listMapper.mapList
                ((AbstractMapper) storageItemControllerMapper, false, storageItems);

        LOG.debug("Successfully returned all stored items: {}.", storageItemControllerModels);

        modelAndView.setViewName("core/Storage");
        modelAndView.addObject("storageItems", storageItemControllerModels);

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

        final User user = userService.loadUserData(userDetails.getUsername());

        LOG.debug("Successfully returned all stored items: {} for user: {}.", user.getStorageItems(), user
                .getFirstName());

        modelAndView.setViewName("core/Storage");
        modelAndView.addObject("storageItems", user.getStorageItems());

        return modelAndView;
    }
}
