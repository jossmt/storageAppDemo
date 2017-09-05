//package com.app.storage.controller;
//
//import com.app.storage.controller.mapper.StorageItemControllerMapper;
//import com.app.storage.controller.model.StorageItemControllerModel;
//import com.app.storage.domain.model.ItemListing;
//import com.app.storage.persistence.mapper.constants.ListMapper;
//import com.app.storage.service.ItemListingService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import javax.ws.rs.core.Response;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Test for {@link StorageItemController}
// */
//@RunWith(MockitoJUnitRunner.class)
//public class StorageItemControllerTest {
//
//    /** {@link ItemListingService} */
//    @Mock
//    private ItemListingService storageItemService;
//
//    /** {@link StorageItemControllerMapper} */
//    @Mock
//    private StorageItemControllerMapper storageItemControllerMapper;
//
//    /** {@link ListMapper} */
//    private ListMapper listMapper;
//
//    /** {@link StorageItemController} */
//    private StorageItemController storageItemController;
//
//    /**
//     * Set up.
//     */
//    @Before
//    public void setUp() {
//        listMapper = new ListMapper();
//        storageItemController = new StorageItemController(storageItemService, storageItemControllerMapper,
//                                                          listMapper);
//    }
//
//    /**
//     * Storage item lookup test.
//     */
//    @Test
//    public void testStorageItemlookup() {
//
//        //Setup
//        final ItemListing storageItem = new ItemListing();
//        storageItem.setId(1L);
//        storageItem.setDescription("T-Shirt");
//        storageItem.setSize("L");
//
//        final StorageItemControllerModel storageItemControllerModel = new StorageItemControllerModel();
//        storageItemControllerModel.setId(1L);
//        storageItemControllerModel.setSize("L");
//        storageItemControllerModel.setSize("T-Shirt");
//
//        //Mock
//        Mockito.when(storageItemService.retrieveAllStorageItems()).thenReturn(Arrays.asList(storageItem));
//
//        //Test
//        final List<StorageItemControllerModel> actualResponse = storageItemController.getStoredItems();
//
//        // Assert
//        Assert.assertEquals(actualResponse, storageItemControllerModel);
//    }
//
//    /**
//     * Test for saving storage item.
//     */
//    public void saveStorageItemsTest() {
//
//        //Setup
//        final ItemListing storageItem = new ItemListing();
//        storageItem.setId(1L);
//        storageItem.setDescription("T-Shirt");
//        storageItem.setSize("L");
//
//        final StorageItemControllerModel storageItemControllerModel = new StorageItemControllerModel();
//        storageItemControllerModel.setId(1L);
//        storageItemControllerModel.setSize("L");
//        storageItemControllerModel.setSize("T-Shirt");
//
//        //Mock
//        Mockito.doNothing().when(storageItemService).saveStorageItems(Arrays.asList(storageItem));
//
//        //Test
//        final Response response = storageItemController.saveStorageItems(Arrays.asList(storageItemControllerModel));
//
//    }
//
//}
