package com.app.storage.persistence.repository;

import com.app.storage.domain.model.User;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        final UserPersistenceModel userPersistenceModel = userRepository.findMostRecent();

        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setName("Name");
        storageItemPersistenceModel.setUserPersistenceModel(userPersistenceModel);
        storageItemRepository.save(storageItemPersistenceModel);

        //Test
        final StorageItemPersistenceModel savedStorageItemPersistenceModel = storageItemRepository.findMostRecent();

        //Assert
        Assert.assertEquals(storageItemPersistenceModel, savedStorageItemPersistenceModel);

        //Clear
        storageItemRepository.delete(savedStorageItemPersistenceModel.getId());
    }

//    @Test
    public void saveExampleData() throws IOException {

        //setup
        final UserPersistenceModel userPersistenceModel = userRepository.findMostRecent();

        final File image = new File("src/test/resources/example.jpg");
        final byte[] imageBytes = FileUtils.readFileToByteArray(image);


        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setName("Name");
        storageItemPersistenceModel.setSize("L");
        storageItemPersistenceModel.setImage(imageBytes);

        storageItemRepository.save(storageItemPersistenceModel);

    }
}
