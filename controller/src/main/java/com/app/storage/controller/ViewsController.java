package com.app.storage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * Returns views for core UI switching.
 */
@Controller
@RequestMapping("/")
public class ViewsController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemController.class);

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
    public String renderHome(final HttpSession httpSession, final Principal principal) {
        LOG.debug("Session details: {}", httpSession.getCreationTime() + " " + httpSession.getMaxInactiveInterval());
        LOG.debug("Principal details: {}", principal.getName());

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
    public String renderStorage() {
        return "core/Storage";
    }
}
