package com.app.storage.controller;

import com.app.storage.controller.model.UploadDataWrapper;
import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.domain.model.User;
import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.service.ItemListingService;
import com.app.storage.service.UserService;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * Controller for storage item requests.
 */
@Controller
@RequestMapping(value = "/")
public class ItemListingController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(ItemListingController.class);

    /** {@link ItemListingService} */
    private final ItemListingService itemListingService;

    /** {@link UserService} */
    private final UserService userService;

    /**
     * Constructor.
     *
     * @param itemListingService
     *         Storage item service.
     * @param userService
     *         User service.
     */
    @Autowired
    public ItemListingController(final ItemListingService itemListingService,
                                 final UserService userService) {
        this.itemListingService = itemListingService;
        this.userService = userService;
    }

    /**
     * Renders sell item view to container
     *
     * @return SellSingle.jsp
     */
    @RequestMapping(value = "/sell", method = RequestMethod.GET)
    public String renderSell(final Principal principal, final Model model) {

        final List<TradingAccount> tradingAccounts = userService.loadUserTradingAccounts(principal.getName());

        model.addAttribute("tradingAccounts", tradingAccounts);
        model.addAttribute("sellItem", new UploadDataWrapper());

        return "sell/SellThing";
    }

    /**
     * Renders sell item view to container
     *
     * @return SellSingle.jsp
     */
    @RequestMapping(value = "/sell", method = RequestMethod.POST)
    public String handleSellItem(final Principal principal, @ModelAttribute("sellItem") final UploadDataWrapper
            uploadDataWrapper, @RequestParam("file") final MultipartFile multipartFile) {

        LOG.debug("Adding item to Sell {}", uploadDataWrapper.toString());

        try {
            uploadDataWrapper.getItemListing().setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("Unable to load image provided");
        }

        final ItemListing saveditem = itemListingService.saveStorageItem(principal.getName(), uploadDataWrapper
                .getItemListing());

        return "redirect:/item/" + saveditem.getReference();
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

        final ItemListing itemListing = itemListingService.findStorageItemByReference(reference);

        LOG.debug("Successfully returned storage item {} with reference {}.", itemListing, reference);

        modelAndView.setViewName("core/StorageSingle");
        modelAndView.addObject("itemListing", itemListing);

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

        final List<ItemListing> itemListings = itemListingService.retrieveAllStorageItems();

        LOG.debug("Successfully returned all stored items: {}.", itemListings);

        modelAndView.setViewName("core/Discover");
        modelAndView.addObject("itemListings", itemListings);

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

        LOG.debug("Successfully returned all stored items: {} for user: {}.", user.getItemListings(), user
                .getFirstName());

        modelAndView.setViewName("core/Storage");
        modelAndView.addObject("itemListings", user.getItemListings());

        return modelAndView;
    }
}
