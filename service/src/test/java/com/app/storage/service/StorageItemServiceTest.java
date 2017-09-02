package com.app.storage.service;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.persistence.service.StorageItemPersistenceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.*;

/**
 * Test for {@link StorageItemService}
 */
@RunWith(MockitoJUnitRunner.class)
public class StorageItemServiceTest {

    @Mock
    /**  {@link StorageItemPersistenceService }. */
    private StorageItemPersistenceService storageItemPersistenceService;

    /** {@link StorageItemService }. */
    private StorageItemService storageItemService;

    @Before
    public void setUp() {

        storageItemService = new StorageItemServiceHandler(storageItemPersistenceService);
    }


    /**
     * Test for saving storage items.
     */
    @Test
    public void saveStorageItemsTest() {

        //Setup
        final StorageItem storageItem = new StorageItem();
        storageItem.setImage(new byte[]{1, 0, 1});
        storageItem.setDescription("StorageTest");
        storageItem.setSize("L");

        //Test
        storageItemService.saveStorageItem("userEmail", storageItem);

        //Verify
        Mockito.verify(storageItemPersistenceService).saveStorageItem("userEmail", storageItem);
    }

    /**
     * Test for retrieving storage items
     */
    @Test
    public void retrieveStorageItemsTest() {

        //Setup
        final StorageItem storageItem = new StorageItem();
        storageItem.setImage(new byte[]{1, 0, 1});
        storageItem.setDescription("StorageTest");
        storageItem.setSize("L");

        //Mock
        Mockito.when(storageItemPersistenceService.retrieveAllStorageItems()).thenReturn(Arrays.asList(storageItem));

        //Test
        final List<StorageItem> actualResponse = storageItemService.retrieveAllStorageItems();

        //Verify
        Mockito.verify(storageItemPersistenceService).retrieveAllStorageItems();

        //Assert
        Assert.assertEquals(actualResponse, Arrays.asList(storageItem));
    }

    /**
     * Find storage item by ref test.
     */
    @Test
    public void findStorageItemByReferenceTest() {

        //Setup
        final StorageItem storageItem = new StorageItem();
        storageItem.setReference("reference");
        storageItem.setImage(new byte[]{1, 0, 1});
        storageItem.setDescription("StorageTest");
        storageItem.setSize("L");

        //Mock
        Mockito.when(storageItemPersistenceService.retrieveStorageItemByRef("reference")).thenReturn(storageItem);

        //Test
        final StorageItem storageItemActual = storageItemPersistenceService.retrieveStorageItemByRef("reference");

        //Verify
        Mockito.verify(storageItemPersistenceService).retrieveStorageItemByRef("reference");

        //Assert
        Assert.assertEquals(storageItemActual, storageItem);
    }


    /**
     * Price calculation test.
     */
    @Test
    public void priceCalculationTest() {

        //Setup
        final Double price = 3.60;

        final StorageItem storageItem = new StorageItem();
        storageItem.setReference("item1");
        storageItem.setPrice(1.2);
        final StorageItem storageItem2 = new StorageItem();
        storageItem2.setReference("item2");
        storageItem2.setPrice(1.2);
        final StorageItem storageItem3 = new StorageItem();
        storageItem3.setReference("item3");
        storageItem3.setPrice(1.2);

        final Set<StorageItem> storageItems = new LinkedHashSet<>();
        storageItems.add(storageItem);
        storageItems.add(storageItem2);
        storageItems.add(storageItem3);

        //Test
        final Double priceActual = storageItemService.calculateTotalPrice(storageItems);

        //Assert
        Assert.assertEquals(priceActual, price);

    }
}
