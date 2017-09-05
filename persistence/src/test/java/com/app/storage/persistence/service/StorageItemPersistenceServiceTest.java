//package com.app.storage.persistence.service;
//
//import com.app.storage.domain.model.ItemListing;
//import com.app.storage.persistence.mapper.ItemListingPersistenceMapper;
//import com.app.storage.persistence.mapper.constants.ListMapper;
//import com.app.storage.persistence.model.ItemListingPersistenceModel;
//import com.app.storage.persistence.repository.StorageItemRepository;
//import org.joda.time.DateTime;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Test for {@link ItemListingPersistenceService}
// */
//@RunWith(MockitoJUnitRunner.class)
//public class StorageItemPersistenceServiceTest {
//
//    /** {@link StorageItemRepository} */
//    @Mock
//    private StorageItemRepository storageItemRepository;
//
//    /** {@link ItemListingPersistenceMapper}. */
//    @Mock
//    private ItemListingPersistenceMapper storageItemPersistenceMapper;
//
//    /** {@link ListMapper}. */
//    private ListMapper listMapper;
//
//    /** {@link ItemListingPersistenceService}. */
//    private ItemListingPersistenceService storageItemPersistenceService;
//
//    /**
//     * Setup.
//     */
//    @Before
//    public void setup() {
//        listMapper = new ListMapper();
//        storageItemPersistenceService = new ItemListingPersistenceServiceHandler(storageItemPersistenceMapper,
//                                                                                 storageItemRepository, listMapper);
//    }
//
//    /**
//     * Save storage items test.
//     */
//    @Test
//    public void saveStorageItemsTest() {
//
//        //Setup
//        final ItemListingPersistenceModel storageItemPersistenceModel = new ItemListingPersistenceModel();
//        storageItemPersistenceModel.setDescription("Name");
//        storageItemPersistenceModel.setSize("Size");
//        storageItemPersistenceModel.setId(1l);
//        storageItemPersistenceModel.setImage(new byte[]{1, 0, 1});
//
//        final ItemListing storageItem = new ItemListing();
//        storageItem.setDescription(storageItemPersistenceModel.getDescription());
//        storageItem.setSize(storageItemPersistenceModel.getSize());
//        storageItem.setImage(storageItemPersistenceModel.getImage());
//        storageItem.setDateStored(storageItemPersistenceModel.getDateStored());
//
//        //Mock
//        Mockito.when(storageItemPersistenceMapper.mapTo(storageItem)).thenReturn(storageItemPersistenceModel);
//        Mockito.when(storageItemRepository.save(Arrays.asList(storageItemPersistenceModel)))
//                .thenReturn(Arrays.asList(storageItemPersistenceModel));
//
//        //Test
//        storageItemPersistenceService.saveStorageItems(Arrays.asList(storageItem));
//
//        //Verify
//        Mockito.verify(storageItemPersistenceMapper).mapTo(storageItem);
//        Mockito.verify(storageItemRepository).save(Arrays.asList(storageItemPersistenceModel));
//    }
//
//    /**
//     * Retrieve all storage items test
//     */
//    @Test
//    public void retrieveAllStorageItemsTest() {
//
//        //Setup
//        final ItemListingPersistenceModel storageItemPersistenceModel = new ItemListingPersistenceModel();
//        storageItemPersistenceModel.setDescription("Name");
//        storageItemPersistenceModel.setSize("Size");
//        storageItemPersistenceModel.setId(1l);
//        storageItemPersistenceModel.setImage(new byte[]{1, 0, 1});
//
//        final ItemListing storageItem = new ItemListing();
//        storageItem.setDescription(storageItemPersistenceModel.getDescription());
//        storageItem.setSize(storageItemPersistenceModel.getSize());
//        storageItem.setImage(storageItemPersistenceModel.getImage());
//        storageItem.setDateStored(storageItemPersistenceModel.getDateStored());
//
//        //Mock
//        Mockito.when(storageItemPersistenceMapper.mapFrom(storageItemPersistenceModel)).thenReturn(storageItem);
//        Mockito.when(storageItemRepository.findAll()).thenReturn(Arrays.asList(storageItemPersistenceModel));
//
//        //Test
//        final List<ItemListing> storageItems = storageItemPersistenceService.retrieveAllStorageItems();
//
//        //Verify
//        Mockito.verify(storageItemPersistenceMapper).mapFrom(storageItemPersistenceModel);
//        Mockito.verify(storageItemRepository).findAll();
//
//        //Assert
//        Assert.assertEquals(Arrays.asList(storageItem), storageItems);
//    }
//}
