package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Role;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.RolePersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

/**
 * Test for {@link UserPersistenceMapper}
 */
public class UserPersistenceMapperTest {

    /** {@link ListMapper}. */
    private ListMapper listMapper;

    /** {@link UserPersistenceMapper}. */
    private UserPersistenceMapper userPersistenceMapper;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        listMapper = new ListMapper();
        userPersistenceMapper = new UserPersistenceMapperHandler(listMapper);
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
        final UserPersistenceModel actualResponse = userPersistenceMapper.mapTo(user);

        //Assert
        Assert.assertEquals(actualResponse, userPersistenceModel);
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

        final User user = new User();
        user.setId(1l);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPassword("password");
        user.setEmail("Email");

        //Test
        final User actualResponse = userPersistenceMapper.mapFrom(userPersistenceModel);

        //Assert
        Assert.assertEquals(actualResponse, user);
    }
}
