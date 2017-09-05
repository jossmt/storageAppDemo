package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Grade;
import com.app.storage.domain.model.listing.DeliveryType;
import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.Base64ImageEncoder;
import com.app.storage.persistence.model.ItemListingPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Implementation of {@link ItemListingPersistenceMapper}
 */
@Component
public class ItemListingPersistenceMapperHandler implements ItemListingPersistenceMapper,
        AbstractMapper<ItemListingPersistenceModel, ItemListing> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(ItemListingPersistenceMapper.class);

    /**
     * {@inheritDoc}
     */
    public ItemListing mapFrom(final ItemListingPersistenceModel itemListingPersistenceModel) {

        LOG.debug("Mapping storage item persistence model to domain model.");

        ItemListing itemListing = null;
        if (itemListingPersistenceModel != null) {

            itemListing = new ItemListing();
            itemListing.setReference(itemListingPersistenceModel.getReference());
            itemListing.setDescription(itemListingPersistenceModel.getDescription());
            itemListing.setDateStored(itemListingPersistenceModel.getDateStored());
            itemListing.setImage(itemListingPersistenceModel.getImage());
            itemListing.setImageUrl(Base64ImageEncoder.encodeImageUrl(itemListingPersistenceModel.getImage()));
            itemListing.setSize(itemListingPersistenceModel.getSize());
            itemListing.setBrand(itemListingPersistenceModel.getBrand());
            itemListing.setGrade(Grade.valueOf(itemListingPersistenceModel.getGrade()));
            itemListing.setDeliveryType(DeliveryType.valueOf(itemListingPersistenceModel.getDeliveryType()));
            itemListing.setDeliveryCharge(itemListingPersistenceModel.getDeliveryCharge());
            itemListing.setPrice(itemListingPersistenceModel.getPrice());
        }

        LOG.debug("Mapping storage item domain model to persistence model.");


        return itemListing;
    }

    /**
     * {@inheritDoc}
     */
    public ItemListingPersistenceModel mapTo(final ItemListing itemListing) {

        LOG.debug("Mapping storage item domain model to persistence model.");

        ItemListingPersistenceModel itemListingPersistenceModel = null;
        if (itemListing != null) {
            itemListingPersistenceModel = new ItemListingPersistenceModel();
            if (itemListing.getReference() != null) {
                itemListingPersistenceModel.setReference(itemListing.getReference());
            } else {
                itemListingPersistenceModel.setReference(UUID.randomUUID().toString());
            }
            itemListingPersistenceModel.setDescription(itemListing.getDescription());
            itemListingPersistenceModel.setSize(itemListing.getSize());
            itemListingPersistenceModel.setDateStored(itemListing.getDateStored());
            itemListingPersistenceModel.setImage(itemListing.getImage());
            itemListingPersistenceModel.setBrand(itemListing.getBrand());
            itemListingPersistenceModel.setPrice(itemListing.getPrice());
            itemListingPersistenceModel.setDeliveryCharge(itemListing.getDeliveryCharge());
            if (itemListing.getGrade() != null) {
                itemListingPersistenceModel.setGrade(itemListing.getGrade().name());
            }
            if (itemListing.getDeliveryType() != null) {
                itemListingPersistenceModel.setDeliveryType(itemListing.getDeliveryType().name());
            }

        }

        LOG.debug("Mapping storage item persistence model to domain model.");

        return itemListingPersistenceModel;
    }
}
