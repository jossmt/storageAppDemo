package com.app.storage.persistence.service;

import com.app.storage.domain.model.Role;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.UserPersistenceMapper;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.model.RolePersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.repository.RoleRepository;
import com.app.storage.persistence.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

/**
 * Test for {@link UserPersistenceService}
 */
@RunWith(MockitoJUnitRunner.class)
public class UserPersistenceServiceTest {

    /** {@link AbstractMapper} */
    @Mock
    private UserPersistenceMapper userPersistenceMapper;

    /** {@link BCryptPasswordEncoder} */
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /** {@link UserRepository} */
    @Mock
    private UserRepository userRepository;

    /** {@link RoleRepository} */
    @Mock
    private RoleRepository roleRepository;

    /** {@link UserPersistenceService}. */
    private UserPersistenceService userPersistenceService;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        userPersistenceService = new UserPersistenceServiceHandler(userRepository, roleRepository,
                                                                   userPersistenceMapper, bCryptPasswordEncoder);
    }

    /**
     * Load by username test.
     */
    @Test
    public void loadByUsernameTest() {

        //Setup
        final RolePersistenceModel rolePersistenceModel = new RolePersistenceModel();
        rolePersistenceModel.setName("USER");

        final Role role = new Role();
        role.setName("USER");

        final UserPersistenceModel userPersistenceModel = new UserPersistenceModel();
        userPersistenceModel.setId(1l);
        userPersistenceModel.setFirstName("firstName");
        userPersistenceModel.setLastName("lastName");
        userPersistenceModel.setPassword("password");
        userPersistenceModel.setEmail("useremail");
        userPersistenceModel.setRoles(Arrays.asList(rolePersistenceModel));

        final User user = new User();
        user.setId(1l);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPassword("password");
        user.setEmail("useremail");
        user.setRoles(Arrays.asList(role));

        role.setUsers(Arrays.asList(user));
        rolePersistenceModel.setUsers(Arrays.asList(userPersistenceModel));

        //Mock
        Mockito.when(userRepository.findByEmail("useremail")).thenReturn(userPersistenceModel);
        Mockito.when(userPersistenceMapper.mapFrom(userPersistenceModel)).thenReturn(user);

        //Test
        User actualUser = userPersistenceService.findUserByEmail("useremail");

        //Verify
        Mockito.verify(userRepository).findByEmail("useremail");
        Mockito.verify(userPersistenceMapper).mapFrom(userPersistenceModel);

        //Assert
        Assert.assertEquals(actualUser, user);

    }

    /**
     * test for saving user.
     */
    @Test
    public void saveUserTest() {

        //Setup
        final RolePersistenceModel rolePersistenceModel = new RolePersistenceModel();
        rolePersistenceModel.setName("USER");

        final Role role = new Role();
        role.setName("USER");

        final UserPersistenceModel userPersistenceModel = new UserPersistenceModel();
        userPersistenceModel.setId(1l);
        userPersistenceModel.setFirstName("firstName");
        userPersistenceModel.setLastName("lastName");
        userPersistenceModel.setPassword("password");
        userPersistenceModel.setEmail("useremail");
        userPersistenceModel.setRoles(Arrays.asList(rolePersistenceModel));

        final User user = new User();
        user.setId(1l);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPassword("password");
        user.setEmail("useremail");
        user.setRoles(Arrays.asList(role));

        role.setUsers(Arrays.asList(user));
        rolePersistenceModel.setUsers(Arrays.asList(userPersistenceModel));

        //Mock
        Mockito.when(userPersistenceMapper.mapTo(user)).thenReturn(userPersistenceModel);
        Mockito.when(userRepository.save(userPersistenceModel)).thenReturn(userPersistenceModel);
        Mockito.when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn(user.getPassword());
        Mockito.when(roleRepository.findAll()).thenReturn(Arrays.asList(rolePersistenceModel));
        Mockito.when(userPersistenceMapper.mapFrom(userPersistenceModel)).thenReturn(user);

        //Test
        final User userActual = userPersistenceService.saveUser(user);

        //Assert
        Assert.assertEquals(user, userActual);
    }
}
