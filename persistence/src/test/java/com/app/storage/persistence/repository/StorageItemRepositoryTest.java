package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.StorageItemPersistenceModel;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Test for {@link StorageItemRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:JDBCConfig.xml"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.app.storage.persistence.repository"})
public class StorageItemRepositoryTest {

    /** {@link StorageItemRepository} */
    @Autowired
    private StorageItemRepository storageItemRepository;

    /**
     * Finds all storage items in db.
     */
    @Test
    public void checkFindAllItems(){

        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setId(1L);
        storageItemPersistenceModel.setDateStored(new DateTime());
        storageItemPersistenceModel.setName("Name");
        storageItemRepository.save(storageItemPersistenceModel);
    }
}
