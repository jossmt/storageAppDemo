//package com.app.storage.persistence.service;
//
//import com.app.storage.domain.model.StorageItem;
//import com.app.storage.persistence.mapper.StorageItemPersistenceMapper;
//import com.app.storage.persistence.mapper.constants.ListMapper;
//import com.app.storage.persistence.model.StorageItemPersistenceModel;
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
// * Test for {@link StorageItemPersistenceService}
// */
//@RunWith(MockitoJUnitRunner.class)
//public class StorageItemPersistenceServiceTest {
//
//    /** {@link StorageItemRepository} */
//    @Mock
//    private StorageItemRepository storageItemRepository;
//
//    /** {@link StorageItemPersistenceMapper}. */
//    @Mock
//    private StorageItemPersistenceMapper storageItemPersistenceMapper;
//
//    /** {@link ListMapper}. */
//    private ListMapper listMapper;
//
//    /** {@link StorageItemPersistenceService}. */
//    private StorageItemPersistenceService storageItemPersistenceService;
//
//    /**
//     * Setup.
//     */
//    @Before
//    public void setup() {
//        listMapper = new ListMapper();
//        storageItemPersistenceService = new StorageItemPersistenceServiceHandler(storageItemPersistenceMapper,
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
//        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
//        storageItemPersistenceModel.setName("Name");
//        storageItemPersistenceModel.setSize("Size");
//        storageItemPersistenceModel.setId(1l);
//        storageItemPersistenceModel.setDateStored(new DateTime("2017-03-03"));
//        storageItemPersistenceModel.setImage(new byte[]{1, 0, 1});
//
//        final StorageItem storageItem = new StorageItem();
//        storageItem.setId(storageItemPersistenceModel.getId());
//        storageItem.setName(storageItemPersistenceModel.getName());
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
//    public void retrieveAllStorageItemsTest() {
//
//        //Setup
//        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
//        storageItemPersistenceModel.setName("Name");
//        storageItemPersistenceModel.setSize("Size");
//        storageItemPersistenceModel.setId(1l);
//        storageItemPersistenceModel.setDateStored(new DateTime("2017-03-03"));
//        storageItemPersistenceModel.setImage(new byte[]{1, 0, 1});
//
//        final StorageItem storageItem = new StorageItem();
//        storageItem.setId(storageItemPersistenceModel.getId());
//        storageItem.setName(storageItemPersistenceModel.getName());
//        storageItem.setSize(storageItemPersistenceModel.getSize());
//        storageItem.setImage(storageItemPersistenceModel.getImage());
//        storageItem.setDateStored(storageItemPersistenceModel.getDateStored());
//
//        //Mock
//        Mockito.when(storageItemPersistenceMapper.mapFrom(storageItemPersistenceModel)).thenReturn(storageItem);
//        Mockito.when(storageItemRepository.findAll()).thenReturn(Arrays.asList(storageItemPersistenceModel));
//
//        //Test
//        final List<StorageItem> storageItems = storageItemPersistenceService.retrieveAllStorageItems();
//
//        //Verify
//        Mockito.verify(storageItemPersistenceMapper).mapFrom(storageItemPersistenceModel);
//        Mockito.verify(storageItemRepository).findAll();
//
//        //Assert
//        Assert.assertEquals(Arrays.asList(storageItem), storageItems);
//    }
//}
