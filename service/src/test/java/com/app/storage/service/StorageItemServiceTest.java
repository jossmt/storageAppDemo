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

import java.util.Arrays;
import java.util.List;

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
        storageItemService.saveStorageItem(storageItem);

        //Verify
        Mockito.verify(storageItemPersistenceService).saveStorageItem(storageItem);
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
}
