package com.app.storage.service;

import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.persistence.service.ItemListingPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

/**
 * Implementation of {@link ItemListingService}
 */
@Service
public class ItemListingServiceHandler implements ItemListingService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(ItemListingService.class);

    /** {@link ItemListingPersistenceService} */
    private final ItemListingPersistenceService itemListingPersistenceService;

    /**
     * Constructor.
     *
     * @param itemListingPersistenceService
     *         {@link ItemListingPersistenceService}
     */
    @Autowired
    public ItemListingServiceHandler(final ItemListingPersistenceService itemListingPersistenceService) {
        this.itemListingPersistenceService = itemListingPersistenceService;
    }

    /**
     * {@inheritDoc}
     */
    public List<ItemListing> retrieveAllStorageItems() {

        LOG.debug("Retrieving storage items.");

        final List<ItemListing> itemListings = itemListingPersistenceService.retrieveAllStorageItems();

        LOG.debug("Successfully retrieved storage items: {}", itemListings);

        return itemListings;
    }

    /**
     * {@inheritDoc}
     */
    public ItemListing saveStorageItem(final String userEmail, final ItemListing itemListing) {

        LOG.debug("Saving storage item: {} for user: {}", itemListing, userEmail);

        final ItemListing itemListingUpdated = itemListingPersistenceService.saveStorageItem(userEmail, itemListing);

        LOG.debug("Success saving storage item.");

        return itemListingUpdated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemListing findStorageItemByReference(final String reference) {

        LOG.debug("Finding storage item by ref: {}", reference);

        final ItemListing itemListing = itemListingPersistenceService.retrieveStorageItemByRef(reference);

        LOG.debug("Successfully found storage item. ");

        return itemListing;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double calculateTotalPrice(final Set<ItemListing> basketItems) {

        LOG.debug("Calculating total basket price");

        final DecimalFormat df = new DecimalFormat("#.00");

        Double price = 0.00;
        for (ItemListing itemListing : basketItems) {
            if (itemListing.getPrice() != null) {
                price += itemListing.getPrice();
                if(itemListing.getDeliveryCharge() != null) {
                    price += itemListing.getDeliveryCharge();
                }
            }
        }

        final String priceFormatted = df.format(price);
        final Double priceFormattedDouble = Double.valueOf(priceFormatted);

        LOG.debug("Returning total price of: {}", priceFormattedDouble);
        return priceFormattedDouble;
    }
}
