package com.app.storage.persistence.service;

import com.app.storage.domain.model.Role;
import com.app.storage.domain.model.User;
import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.payment.PaymentInformation;
import com.app.storage.persistence.mapper.AddressPersistenceMapper;
import com.app.storage.persistence.mapper.UserPersistenceMapper;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.payment.PaymentInformationPersistenceMapper;
import com.app.storage.persistence.mapper.trade.TradingAccountPersistenceMapper;
import com.app.storage.persistence.model.RolePersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.AddressPersistenceModel;
import com.app.storage.persistence.model.payment.PaymentInformationPersistenceModel;
import com.app.storage.persistence.repository.AddressRepository;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Test for {@link UserPersistenceService}
 */
@RunWith(MockitoJUnitRunner.class)
public class UserPersistenceServiceTest {

    private List<AddressPersistenceModel> addressPersistenceModels;

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

    /** {@link AddressRepository} */
    @Mock
    private AddressRepository addressRepository;

    /** {@link PaymentInformationPersistenceMapper} */
    @Mock
    private PaymentInformationPersistenceMapper paymentInformationPersistenceMapper;

    /** {@link RoleRepository} */
    @Mock
    private AddressPersistenceMapper addressPersistenceMapper;

    /** {@link TradingAccountPersistenceMapper} */
    @Mock
    private TradingAccountPersistenceMapper tradingAccountPersistenceMapper;

    /** {@link UserPersistenceService}. */
    private UserPersistenceService userPersistenceService;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        userPersistenceService = new UserPersistenceServiceHandler(userRepository, roleRepository,
                                                                   addressRepository,
                                                                   userPersistenceMapper,
                                                                   paymentInformationPersistenceMapper,
                                                                   addressPersistenceMapper,
                                                                   tradingAccountPersistenceMapper,
                                                                   bCryptPasswordEncoder);

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
        userPersistenceModel.setFirstName("firstName");
        userPersistenceModel.setLastName("lastName");
        userPersistenceModel.setPassword("password");
        userPersistenceModel.setEmail("useremail");
        userPersistenceModel.setRoles(Arrays.asList(rolePersistenceModel));

        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPassword("password");
        user.setEmail("useremail");
        user.setRoles(Arrays.asList(role));

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
        final Address address = new Address();
        address.setStreetAddress("streetAddress");
        final AddressPersistenceModel addressPersistenceModel = new AddressPersistenceModel();
        addressPersistenceModel.setStreetAddress("streetAddress");

        final PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardHolderName("cardHolderName");
        final PaymentInformationPersistenceModel paymentInformationPersistenceModel = new
                PaymentInformationPersistenceModel();
        paymentInformationPersistenceModel.setCardHolderName("cardHolderName");


        final RolePersistenceModel rolePersistenceModel = new RolePersistenceModel();
        rolePersistenceModel.setName("USER");

        final Role role = new Role();
        role.setName("USER");

        final UserPersistenceModel userPersistenceModel = new UserPersistenceModel();
        userPersistenceModel.setFirstName("firstName");
        userPersistenceModel.setLastName("lastName");
        userPersistenceModel.setPassword("password");
        userPersistenceModel.setEmail("useremail");
        userPersistenceModel.setRoles(Arrays.asList(rolePersistenceModel));
        userPersistenceModel.setAddressPersistenceModels(Arrays.asList(addressPersistenceModel));
        userPersistenceModel.setPaymentInformationPersistenceModel(paymentInformationPersistenceModel);

        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPassword("password");
        user.setEmail("useremail");
        user.setRoles(Arrays.asList(role));
        user.setAddressList(Arrays.asList(address));
        user.setPaymentInformation(paymentInformation);

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
