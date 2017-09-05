package com.app.storage.service;

import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.persistence.service.ItemListingPersistenceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

/**
 * Test for {@link ItemListingService}
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemListingServiceTest {

    @Mock
    /**  {@link ItemListingPersistenceService }. */
    private ItemListingPersistenceService itemListingPersistenceService;

    /** {@link ItemListingService }. */
    private ItemListingService itemListingService;

    @Before
    public void setUp() {

        itemListingService = new ItemListingServiceHandler(itemListingPersistenceService);
    }


    /**
     * Test for saving storage items.
     */
    @Test
    public void saveStorageItemsTest() {

        //Setup
        final ItemListing itemListing = new ItemListing();
        itemListing.setImage(new byte[]{1, 0, 1});
        itemListing.setDescription("StorageTest");
        itemListing.setSize("L");

        //Test
        itemListingService.saveStorageItem("userEmail", itemListing);

        //Verify
        Mockito.verify(itemListingPersistenceService).saveStorageItem("userEmail", itemListing);
    }

    /**
     * Test for retrieving storage items
     */
    @Test
    public void retrieveStorageItemsTest() {

        //Setup
        final ItemListing itemListing = new ItemListing();
        itemListing.setImage(new byte[]{1, 0, 1});
        itemListing.setDescription("StorageTest");
        itemListing.setSize("L");

        //Mock
        Mockito.when(itemListingPersistenceService.retrieveAllStorageItems()).thenReturn(Arrays.asList(itemListing));

        //Test
        final List<ItemListing> actualResponse = itemListingService.retrieveAllStorageItems();

        //Verify
        Mockito.verify(itemListingPersistenceService).retrieveAllStorageItems();

        //Assert
        Assert.assertEquals(actualResponse, Arrays.asList(itemListing));
    }

    /**
     * Find storage item by ref test.
     */
    @Test
    public void findStorageItemByReferenceTest() {

        //Setup
        final ItemListing itemListing = new ItemListing();
        itemListing.setReference("reference");
        itemListing.setImage(new byte[]{1, 0, 1});
        itemListing.setDescription("StorageTest");
        itemListing.setSize("L");

        //Mock
        Mockito.when(itemListingPersistenceService.retrieveStorageItemByRef("reference")).thenReturn(itemListing);

        //Test
        final ItemListing itemListingActual = itemListingPersistenceService.retrieveStorageItemByRef("reference");

        //Verify
        Mockito.verify(itemListingPersistenceService).retrieveStorageItemByRef("reference");

        //Assert
        Assert.assertEquals(itemListingActual, itemListing);
    }


    /**
     * Price calculation test.
     */
    @Test
    public void priceCalculationTest() {

        //Setup
        final Double price = 3.60;

        final ItemListing itemListing = new ItemListing();
        itemListing.setReference("item1");
        itemListing.setPrice(1.2);
        final ItemListing itemListing2 = new ItemListing();
        itemListing2.setReference("item2");
        itemListing2.setPrice(1.2);
        final ItemListing itemListing3 = new ItemListing();
        itemListing3.setReference("item3");
        itemListing3.setPrice(1.2);

        final Set<ItemListing> itemListings = new LinkedHashSet<>();
        itemListings.add(itemListing);
        itemListings.add(itemListing2);
        itemListings.add(itemListing3);

        //Test
        final Double priceActual = itemListingService.calculateTotalPrice(itemListings);

        //Assert
        Assert.assertEquals(priceActual, price);

    }
}
