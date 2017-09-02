package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.payment.AddressPersistenceModel;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
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

    /** {@link UserRepository} */
    @Autowired
    private UserRepository userRepository;


    /**
     * Finds all storage items in db.
     */
    public void checkFindAllItems() throws InterruptedException {

        //Setup
        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setDescription("Name");
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
        final UserPersistenceModel userPersistenceModel = userRepository.findMostRecent();

        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setDescription("Name");
        storageItemPersistenceModel.setUserPersistenceModel(userPersistenceModel);
        storageItemPersistenceModel.setBrand("Brand");
        storageItemPersistenceModel.setGrade("A");
        storageItemRepository.save(storageItemPersistenceModel);

        //Test
        final StorageItemPersistenceModel savedStorageItemPersistenceModel = storageItemRepository.findMostRecent();

        //Assert
        Assert.assertEquals(storageItemPersistenceModel, savedStorageItemPersistenceModel);

        //Clear
        storageItemRepository.delete(savedStorageItemPersistenceModel.getId());
    }

    /**
     * Check find storage item by unique reference.
     *
     * @throws IOException
     */
    @Test
    public void findByReferenceTest() {
        //setup
        final UserPersistenceModel userPersistenceModel = userRepository.findMostRecent();

        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setReference("uniqueReferenceTest123");
        storageItemPersistenceModel.setDescription("Name");
        storageItemPersistenceModel.setUserPersistenceModel(userPersistenceModel);
        storageItemPersistenceModel.setBrand("Brand");
        storageItemPersistenceModel.setGrade("A");
        storageItemRepository.save(storageItemPersistenceModel);

        //Test
        final StorageItemPersistenceModel actualStorageItemPersistenceModel = storageItemRepository.findByReference
                ("uniqueReferenceTest123");

        //Assert
        Assert.assertEquals(actualStorageItemPersistenceModel, storageItemPersistenceModel);

        //Clear
        storageItemRepository.delete(actualStorageItemPersistenceModel.getId());
    }
}
