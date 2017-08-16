package com.app.storage.persistence.repository;

import com.app.storage.persistence.mapper.StorageItemPersistenceMapper;
import com.app.storage.persistence.model.RolePersistenceModel;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.hibernate.Hibernate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * Test for {@link UserRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:JDBCConfig.xml"})
public class UserRepositoryTest {

    /** {@link UserRepository}. */
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {

        //Setup
        final RolePersistenceModel role = new RolePersistenceModel();
        role.setId(1L);
        role.setName("ADMIN");

        final UserPersistenceModel user = new UserPersistenceModel();
        user.setFirstName("fname");
        user.setLastName("lname");
        user.setEmail("example3@email.com");
        user.setPassword("pass");
        user.setRoles(Arrays.asList(role));

        //Test
        final UserPersistenceModel savedUser = userRepository.save(user);

        final UserPersistenceModel updatedUser = userRepository.findMostRecent();

        //Assert
        Assert.assertEquals(savedUser.toString(), updatedUser.toString());

        //Cleanup
        userRepository.delete(updatedUser.getId());
    }

    /**
     * Test lazy load.
     */
    @Test
    @Transactional
    public void getUser() {

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail("jossmtt123@hotmail.com");

        Hibernate.initialize(userPersistenceModel.getStorageItemPersistenceModelList());

        System.out.println(userPersistenceModel.getStorageItemPersistenceModelList());
    }
}
