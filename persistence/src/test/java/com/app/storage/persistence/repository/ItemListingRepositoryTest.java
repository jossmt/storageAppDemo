package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.ItemListingPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Test for {@link ItemListingRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:JDBCConfig.xml"})
public class ItemListingRepositoryTest {

    /** {@link ItemListingRepository} */
    @Autowired
    private ItemListingRepository itemListingRepository;

    /** {@link UserRepository} */
    @Autowired
    private UserRepository userRepository;


    /**
     * Finds all storage items in db.
     */
    public void checkFindAllItems() throws InterruptedException {

        //Setup
        final ItemListingPersistenceModel itemListingPersistenceModel = new ItemListingPersistenceModel();
        itemListingPersistenceModel.setDescription("Name");
        itemListingRepository.save(itemListingPersistenceModel);

        //Test
        final List<ItemListingPersistenceModel> itemListingPersistenceModels = itemListingRepository
                .findAllAsList();

        final ItemListingPersistenceModel savedItemListingPersistenceModel = itemListingRepository.save
                (itemListingPersistenceModel);

        final List<ItemListingPersistenceModel> updatedItemListingPersistenceModels = itemListingRepository
                .findAllAsList();

        System.out.println(itemListingPersistenceModels.size() + ", " + updatedItemListingPersistenceModels.size());
        //Assert
        Assert.assertTrue(itemListingPersistenceModels.size() == updatedItemListingPersistenceModels.size() + 1);
        Assert.assertEquals(itemListingPersistenceModel, itemListingRepository.findMostRecent());

        //Clear
        itemListingRepository.delete(savedItemListingPersistenceModel.getId());
    }

    /**
     * Test save storage item.
     */
    @Test
    public void checkSave() throws ParseException {

        //setup
        final UserPersistenceModel userPersistenceModel = userRepository.findMostRecent();

        final ItemListingPersistenceModel itemListingPersistenceModel = new ItemListingPersistenceModel();
        itemListingPersistenceModel.setDescription("Name");
        itemListingPersistenceModel.setUserPersistenceModel(userPersistenceModel);
        itemListingPersistenceModel.setBrand("Brand");
        itemListingPersistenceModel.setGrade("A");
        itemListingPersistenceModel.setDeliveryType("FAST");
        itemListingRepository.save(itemListingPersistenceModel);

        //Test
        final ItemListingPersistenceModel savedItemListingPersistenceModel = itemListingRepository.findMostRecent();

        //Assert
        Assert.assertEquals(itemListingPersistenceModel, savedItemListingPersistenceModel);

        //Clear
        itemListingRepository.delete(savedItemListingPersistenceModel.getId());
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

        final ItemListingPersistenceModel itemListingPersistenceModel = new ItemListingPersistenceModel();
        itemListingPersistenceModel.setReference("uniqueReferenceTest123");
        itemListingPersistenceModel.setDescription("Name");
        itemListingPersistenceModel.setUserPersistenceModel(userPersistenceModel);
        itemListingPersistenceModel.setBrand("Brand");
        itemListingPersistenceModel.setGrade("A");
        itemListingRepository.save(itemListingPersistenceModel);

        //Test
        final ItemListingPersistenceModel actualItemListingPersistenceModel = itemListingRepository.findByReference
                ("uniqueReferenceTest123");

        //Assert
        Assert.assertEquals(actualItemListingPersistenceModel, itemListingPersistenceModel);

        //Clear
        itemListingRepository.delete(actualItemListingPersistenceModel.getId());
    }
}
