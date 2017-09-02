package com.app.storage.service;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.service.StorageItemPersistenceService;
import com.app.storage.persistence.service.UserPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

/**
 * Implementation of {@link StorageItemService}
 */
@Service
public class StorageItemServiceHandler implements StorageItemService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(StorageItemService.class);

    /** {@link StorageItemPersistenceService} */
    private final StorageItemPersistenceService storageItemPersistenceService;

    /**
     * Constructor.
     *
     * @param storageItemPersistenceService
     *         {@link StorageItemPersistenceService}
     */
    @Autowired
    public StorageItemServiceHandler(final StorageItemPersistenceService storageItemPersistenceService) {
        this.storageItemPersistenceService = storageItemPersistenceService;
    }

    /**
     * {@inheritDoc}
     */
    public List<StorageItem> retrieveAllStorageItems() {

        LOG.debug("Retrieving storage items.");

        final List<StorageItem> storageItems = storageItemPersistenceService.retrieveAllStorageItems();

        LOG.debug("Successfully retrieved storage items: {}", storageItems);

        return storageItems;
    }

    /**
     * {@inheritDoc}
     */
    public StorageItem saveStorageItem(final String userEmail, final StorageItem storageItem) {

        LOG.debug("Saving storage item: {} for user: {}", storageItem, userEmail);

        final StorageItem storageItemUpdated = storageItemPersistenceService.saveStorageItem(userEmail, storageItem);

        LOG.debug("Success saving storage item.");

        return storageItemUpdated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StorageItem findStorageItemByReference(final String reference) {

        LOG.debug("Finding storage item by ref: {}", reference);

        final StorageItem storageItem = storageItemPersistenceService.retrieveStorageItemByRef(reference);

        LOG.debug("Successfully found storage item. ");

        return storageItem;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double calculateTotalPrice(final Set<StorageItem> basketItems) {

        LOG.debug("Calculating total basket price");

        final DecimalFormat df = new DecimalFormat("#.00");

        Double price = 0.00;
        for (StorageItem storageItem : basketItems) {
            if (storageItem.getPrice() != null) {
                price += storageItem.getPrice();
            }
        }

        final String priceFormatted = df.format(price);
        final Double priceFormattedDouble = Double.valueOf(priceFormatted);

        LOG.debug("Returning total price of: {}", priceFormattedDouble);
        return priceFormattedDouble;
    }
}
