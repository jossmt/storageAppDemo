package com.app.storage.controller.admin;

import com.app.storage.controller.ItemListingController;
import com.app.storage.controller.mapper.StorageItemControllerMapper;
import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.service.ItemListingService;
import com.app.storage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Returns views for core UI switching.
 */
@Controller
@RequestMapping("/admin")
public class AdminViewsController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(ItemListingController.class);

    /** {@link ItemListingService} */
    private final ItemListingService itemListingService;

    /** {@link UserService} */
    private final UserService userService;

    /** {@link StorageItemControllerMapper} */
    private final StorageItemControllerMapper storageItemControllerMapper;

    /** {@link ListMapper} */
    private final ListMapper listMapper;

    /**
     * Constructor.
     *
     * @param itemListingService
     *         {@link ItemListingService}
     * @param storageItemControllerMapper
     *         {@link StorageItemControllerMapper}
     */
    @Autowired
    public AdminViewsController(final ItemListingService itemListingService,
                                final StorageItemControllerMapper storageItemControllerMapper,
                                final UserService userService) {

        listMapper = new ListMapper();
        this.itemListingService = itemListingService;
        this.userService = userService;
        this.storageItemControllerMapper = storageItemControllerMapper;
    }

    /**
     * Renders sign up view to container.
     *
     * @return Signup.jsp
     */
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    public String renderSignup(final Model model) {
        model.addAttribute("storageItem", new ItemListing());

        return "admin/Console";
    }

//    /**
//     * Registering new user
//     *
//     * @param storageItem
//     *         Filled in ItemListing form.
//     * @return redirect URL.
//     */
//    @RequestMapping(value = "/console", method = RequestMethod.POST)
//    public String registerStorageItem(@ModelAttribute("storageItem") final ItemListing storageItem,
//                                      @RequestParam("file") final MultipartFile multipartFile,
//                                      @RequestParam("userEmail") final String userEmail) {
//
//        LOG.debug("Uploaded item: {}", storageItem);
//        LOG.debug("User info: {}", userEmail);
//
//        final User user = userService.loadUserByUsername(userEmail);
//
//        if (user == null) {
//            throw new IllegalArgumentException("User with email: " + userEmail + "does not exist");
//        }else{
//            storageItem.setOwner(user);
//        }
//
//        try {
//            storageItem.setImage(multipartFile.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new IllegalStateException("Unable to load image file");
//        }
//
//        itemListingService.saveStorageItem(storageItem);
//
//
//        return "admin/Console";
//    }
}
