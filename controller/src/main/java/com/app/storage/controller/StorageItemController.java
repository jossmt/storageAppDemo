package com.app.storage.controller;

import com.app.storage.controller.mapper.StorageItemControllerMapper;
import com.app.storage.controller.model.StorageItemControllerModel;
import com.app.storage.domain.model.StorageItem;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.service.StorageItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    /** {@link StorageItemControllerMapper} */
    private final StorageItemControllerMapper storageItemControllerMapper;

    /** {@link ListMapper} */
    private final ListMapper listMapper;

    /**
     * Constructor.
     *
     * @param storageItemService
     *         Storage item service.
     * @param storageItemControllerMapper
     *         Storage Item Controller Mapper.
     */
    @Autowired
    public StorageItemController(final StorageItemService storageItemService,
                                 final StorageItemControllerMapper storageItemControllerMapper) {
        listMapper = new ListMapper();
        this.storageItemService = storageItemService;
        this.storageItemControllerMapper = storageItemControllerMapper;
    }

    /**
     * Returns all users stored items.
     *
     * @return JSON response including all stored items.
     */
    @RequestMapping(value = "/storedItems", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody
    List<StorageItemControllerModel> getStoredItems() {

        LOG.debug("Getting all stored items.");

        final List<StorageItem> storageItems = storageItemService.retrieveAllStorageItems();

        final List<StorageItemControllerModel> storageItemControllerModels = listMapper.mapList
                ((AbstractMapper) storageItemControllerMapper, false, storageItems);

        LOG.debug("Successfully returned all stored items: {}.", storageItemControllerModels);

        return storageItemControllerModels;

    }

    /**
     * Saves storage item objects from JSON data.
     */
    @RequestMapping(value = "/saveItems", method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveStorageItems(@RequestBody final List<StorageItemControllerModel> storageItemControllerModels) {

        LOG.debug("Saving storage items... {}", storageItemControllerModels);

        final List<StorageItem> storageItems = listMapper.mapList
                ((AbstractMapper) storageItemControllerMapper, true, storageItemControllerModels);

        storageItemService.saveStorageItems(storageItems);

        LOG.debug("Successfully saved storage items.");

        return Response.ok().build();
    }


    /**
     * Quick server uptime check test
     *
     * @return
     */
    @RequestMapping(value = "/temp", method = RequestMethod.GET)
    public @ResponseBody
    String getTemp() {

        LOG.debug("Test temp");

        return "test";
    }

    /**
     * Generic view response - only seems to work with jsp atm needs review
     *
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView returnPage() {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Temp");

        return modelAndView;

    }

    /**
     * Info saved - incase want to return full response including error responses etc.
     * Currently looks like too much info is returned including model class package etc. so needs reviewing
     *
     * @return
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody
    Response returnJson() {

        LOG.debug("Testing logs");

        final String objectToReturn = "{ key1: 'value1', key2: 'value2' }";

        return Response.ok().entity(objectToReturn).build();

    }
}
