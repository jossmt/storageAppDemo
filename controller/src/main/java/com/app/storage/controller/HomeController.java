package com.app.storage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Returns views for core UI switching.
 */
@Controller
@RequestMapping("/")
public class HomeController {

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
     * Renders About view to container.
     *
     * @return About.jsp
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String renderAbout() {
        return "about/Home";
    }
//
//    /**
//     * Renders About view to container.
//     *
//     * @return About.jsp
//     */
//    @RequestMapping(value = "/info", method = RequestMethod.GET)
//    public String renderInfo() {
//        return "about/Home";
//    }
}
