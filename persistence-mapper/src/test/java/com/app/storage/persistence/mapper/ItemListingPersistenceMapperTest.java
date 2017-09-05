package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Grade;
import com.app.storage.domain.model.listing.DeliveryType;
import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.Base64ImageEncoder;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.ItemListingPersistenceModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Test for {@link ItemListingPersistenceMapper}
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemListingPersistenceMapperTest {

    /** Encoded file url. */
    private String encodedFileUrl = "data:image/png;base64,AQAB";

    /** {@link ListMapper}. */
    private ListMapper listMapper;

    /** {@link ItemListingPersistenceMapper} */
    private ItemListingPersistenceMapper itemListingPersistenceMapper;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        listMapper = new ListMapper();
        itemListingPersistenceMapper = new ItemListingPersistenceMapperHandler();
    }

    /**
     * Checks full model mapping
     */
    @Test
    public void checkFullModelMap() {

        //Setup

        final ItemListingPersistenceModel itemListingPersistenceModel = new ItemListingPersistenceModel();
        itemListingPersistenceModel.setReference("reference");
        itemListingPersistenceModel.setDescription("Name");
        itemListingPersistenceModel.setSize("Size");
        itemListingPersistenceModel.setDateStored(new Date());
        itemListingPersistenceModel.setImage(new byte[]{1, 0, 1});
        itemListingPersistenceModel.setGrade("A");
        itemListingPersistenceModel.setDeliveryType("FAST");
        itemListingPersistenceModel.setBrand("Brand");
        itemListingPersistenceModel.setPrice(1.2);
        itemListingPersistenceModel.setDeliveryCharge(1.2);

        final ItemListing itemListing = new ItemListing();
        itemListing.setDescription(itemListingPersistenceModel.getDescription());
        itemListing.setSize(itemListingPersistenceModel.getSize());
        itemListing.setImage(itemListingPersistenceModel.getImage());
        itemListing.setDateStored(itemListingPersistenceModel.getDateStored());
        itemListing.setPrice(1.2);
        itemListing.setDeliveryCharge(1.2);
        itemListing.setGrade(Grade.A);
        itemListing.setDeliveryType(DeliveryType.FAST);
        itemListing.setBrand("Brand");

        //Test
        final ItemListingPersistenceModel actualItemListingPersistenceModel = itemListingPersistenceMapper.mapTo
                (itemListing);

        actualItemListingPersistenceModel.setReference("reference");

        //Assert
        Assert.assertEquals(itemListingPersistenceModel, actualItemListingPersistenceModel);
    }

    @Test
    public void checkFullModelMapFrom() {

        //Setup
        final ItemListingPersistenceModel itemListingPersistenceModel = new ItemListingPersistenceModel();
        itemListingPersistenceModel.setId(1L);
        itemListingPersistenceModel.setReference("reference");
        itemListingPersistenceModel.setDescription("Name");
        itemListingPersistenceModel.setSize("Size");
        itemListingPersistenceModel.setId(1L);
        itemListingPersistenceModel.setDateStored(new Date());
        itemListingPersistenceModel.setImage(new byte[]{1, 0, 1});
        itemListingPersistenceModel.setGrade("A");
        itemListingPersistenceModel.setDeliveryType("FAST");
        itemListingPersistenceModel.setBrand("Brand");
        itemListingPersistenceModel.setPrice(1.2);
        itemListingPersistenceModel.setDeliveryCharge(1.2);

        final ItemListing itemListing = new ItemListing();
        itemListing.setReference("reference");
        itemListing.setDescription(itemListingPersistenceModel.getDescription());
        itemListing.setSize(itemListingPersistenceModel.getSize());
        itemListing.setImage(itemListingPersistenceModel.getImage());
        itemListing.setImageUrl(encodedFileUrl);
        itemListing.setDateStored(itemListingPersistenceModel.getDateStored());
        itemListing.setGrade(Grade.A);
        itemListing.setDeliveryType(DeliveryType.FAST);
        itemListing.setBrand("Brand");
        itemListing.setPrice(1.2);
        itemListing.setDeliveryCharge(1.2);

        //Test
        final ItemListing actualItemListing = itemListingPersistenceMapper.mapFrom(itemListingPersistenceModel);

        //Assertion
        Assert.assertEquals(itemListing, actualItemListing);

    }

    /**
     * Check null map from test.
     */
    @Test
    public void checkNullMapFrom() {

        //Setup
        final ItemListing itemListing = null;

        //Test
        final ItemListing actualItemListing = itemListingPersistenceMapper.mapFrom(null);

        //Assert
        Assert.assertEquals(itemListing, actualItemListing);
    }

    /**
     * Check null map to test.
     */
    @Test
    public void checkNullMapTo() {

        //Setup
        final ItemListingPersistenceModel itemListingPersistenceModel = null;

        //Test
        final ItemListingPersistenceModel actualItemListingPersistenceModel = itemListingPersistenceMapper.mapTo
                (null);

        //Assert
        Assert.assertEquals(itemListingPersistenceModel, actualItemListingPersistenceModel);
    }

    @Test
    public void listMapperTest() {

        //Setup
        final ItemListing itemListing = new ItemListing();
        itemListing.setReference("reference");
        itemListing.setDescription("name1");
        final ItemListing itemListing2 = new ItemListing();
        itemListing2.setReference("reference");
        itemListing2.setDescription("name2");

        final List<ItemListing> mappingList = Arrays.asList(itemListing, itemListing2);

        final ItemListingPersistenceModel itemListingPersistenceModel = new ItemListingPersistenceModel();
        itemListingPersistenceModel.setReference("reference");
        itemListingPersistenceModel.setDescription("name1");
        final ItemListingPersistenceModel itemListingPersistenceModel2 = new ItemListingPersistenceModel();
        itemListingPersistenceModel2.setReference("reference");
        itemListingPersistenceModel2.setDescription("name2");

        final List<ItemListingPersistenceModel> mappedList = Arrays.asList(itemListingPersistenceModel,
                                                                           itemListingPersistenceModel2);

        //Test
        final List<ItemListingPersistenceModel> itemListingPersistenceModels = listMapper.mapList
                ((AbstractMapper) itemListingPersistenceMapper, true, mappingList);

        //Assert
        Assert.assertEquals(mappedList, itemListingPersistenceModels);
    }

    /**
     * Base64 encoding image test
     */
    @Test
    public void base64encodeTest() {

        final String encodedFile = Base64ImageEncoder.encodeImageUrl(new byte[]{1, 0, 1});

        Assert.assertEquals(encodedFile, encodedFileUrl);
    }

    /**
     * Null check listmapper.
     */
    @Test
    public void mapNullList() {

        //Test
        final List<ItemListingPersistenceModel> itemListingPersistenceModels = listMapper.mapList
                ((AbstractMapper) itemListingPersistenceMapper, true, null);

        //Assert
        Assert.assertNull(itemListingPersistenceModels);
    }
}
