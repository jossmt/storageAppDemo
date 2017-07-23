package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.StorageItemPersistenceModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.List;

/**
 * Test for {@link StorageItemRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:JDBCConfig.xml"})
public class StorageItemRepositoryTest {

    /** {@link StorageItemRepository} */
    @Autowired
    private StorageItemRepository storageItemRepository;

    /**
     * Finds all storage items in db.
     */
    public void checkFindAllItems() throws InterruptedException {

        //Setup
        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setName("Name");
        storageItemRepository.save(storageItemPersistenceModel);

        //Test
        final List<StorageItemPersistenceModel> storageItemPersistenceModels = storageItemRepository
                .findAllAsList();

        final StorageItemPersistenceModel savedStorageItemPersistenceModel = storageItemRepository.save
                (storageItemPersistenceModel);

        final List<StorageItemPersistenceModel> updatedStorageItemPersistenceModels = storageItemRepository
                .findAllAsList();

        System.out.println(storageItemPersistenceModels.size() + ", " + updatedStorageItemPersistenceModels.size());
        //Assert
        Assert.assertTrue(storageItemPersistenceModels.size() == updatedStorageItemPersistenceModels.size() + 1);
        Assert.assertEquals(storageItemPersistenceModel, storageItemRepository.findMostRecent());

        //Clear
        storageItemRepository.delete(savedStorageItemPersistenceModel.getId());
    }

    /**
     * Test save storage item.
     */
    @Test
    public void checkSave() throws ParseException {

        //setup
        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setName("Name");
        storageItemRepository.save(storageItemPersistenceModel);

        //Test
        final StorageItemPersistenceModel savedStorageItemPersistenceModel = storageItemRepository.findMostRecent();

        //Assert
        Assert.assertEquals(storageItemPersistenceModel, savedStorageItemPersistenceModel);

        //Clear
        storageItemRepository.delete(savedStorageItemPersistenceModel.getId());
    }
}
