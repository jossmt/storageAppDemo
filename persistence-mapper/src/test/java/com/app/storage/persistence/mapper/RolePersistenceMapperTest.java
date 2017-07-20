package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Role;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.RolePersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;

/**
 * Tests for {@link RolePersistenceMapper}
 */
public class RolePersistenceMapperTest {

    /** {@link ListMapper}. */
    private ListMapper listMapper;

    /** {@link RolePersistenceMapper}. */
    private RolePersistenceMapper rolePersistenceMapper;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        listMapper = new ListMapper();
        rolePersistenceMapper = new RolePersistenceMapperHandler(listMapper);
    }

    /**
     * Full map to test
     */
    @Test
    public void fullMapperToTest() {
        //Setup
        final RolePersistenceModel rolePersistenceModel = new RolePersistenceModel();
        rolePersistenceModel.setId(1L);
        rolePersistenceModel.setName("Name");

        final Role role = new Role();
        role.setId(1L);
        role.setName("Name");

        final UserPersistenceModel userPersistenceModel = new UserPersistenceModel();
        userPersistenceModel.setId(1l);
        userPersistenceModel.setFirstName("firstName");
        userPersistenceModel.setLastName("lastName");
        userPersistenceModel.setPassword("password");
        userPersistenceModel.setEmail("Email");

        final User user = new User();
        user.setId(1l);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPassword("password");
        user.setEmail("Email");

        //Test
        final RolePersistenceModel actualResponse = rolePersistenceMapper.mapTo(role);

        //Assert
        Assert.assertEquals(actualResponse, rolePersistenceModel);
    }

    /**
     * Full map from test
     */
    @Test
    public void fullMapFromTest() {
        //Setup
        final RolePersistenceModel rolePersistenceModel = new RolePersistenceModel();
        rolePersistenceModel.setId(1L);
        rolePersistenceModel.setName("Name");

        final Role role = new Role();
        role.setId(1L);
        role.setName("Name");

        final UserPersistenceModel userPersistenceModel = new UserPersistenceModel();
        userPersistenceModel.setId(1l);
        userPersistenceModel.setFirstName("firstName");
        userPersistenceModel.setLastName("lastName");
        userPersistenceModel.setPassword("password");
        userPersistenceModel.setEmail("Email");

        //Test
        final Role actualResponse = rolePersistenceMapper.mapFrom(rolePersistenceModel);

        //Assert
        Assert.assertEquals(actualResponse, role);
    }
}