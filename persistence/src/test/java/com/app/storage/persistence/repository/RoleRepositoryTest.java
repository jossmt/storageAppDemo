package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.RolePersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Test for {@link UserRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:JDBCConfig.xml"})
public class RoleRepositoryTest {

    /** {@link RoleRepository}. */
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Test save role.
     */
    @Test
    public void testSaveRole() {

        //Setup
        final RolePersistenceModel role = new RolePersistenceModel();
        role.setName("TEST");

        //Test
        final RolePersistenceModel rolePersistenceModel = roleRepository.save(role);

        final RolePersistenceModel updatedRole = roleRepository.findMostRecent();

        //Assert
        Assert.assertEquals(rolePersistenceModel, updatedRole);

        //Cleanup
        roleRepository.delete(updatedRole.getId());
    }
}
