package com.app.storage.persistence.service;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.User;
import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.persistence.mapper.AddressPersistenceMapper;
import com.app.storage.persistence.mapper.UserPersistenceMapper;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.mapper.trade.TradingAccountPersistenceMapper;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.AddressPersistenceModel;
import com.app.storage.persistence.model.payment.PaymentInformationPersistenceModel;
import com.app.storage.persistence.model.trade.TradingAccountPersistenceModel;
import com.app.storage.persistence.repository.AddressRepository;
import com.app.storage.persistence.repository.RoleRepository;
import com.app.storage.persistence.repository.UserRepository;
import org.apache.commons.collections4.IterableUtils;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link UserPersistenceService}
 */
@Service
@Transactional
public class UserPersistenceServiceHandler implements UserPersistenceService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(UserPersistenceService.class);

    /** {@link UserRepository} */
    private final UserRepository userRepository;

    /** {@link RoleRepository} */
    private final RoleRepository roleRepository;

    /** {@link AddressRepository} */
    private final AddressRepository addressRepository;

    /** {@link UserPersistenceMapper} */
    private final UserPersistenceMapper userPersistenceMapper;

    /** {@link AddressPersistenceMapper} */
    private final AddressPersistenceMapper addressPersistenceMapper;

    /** {@link TradingAccountPersistenceMapper} */
    private final TradingAccountPersistenceMapper tradingAccountPersistenceMapper;

    /** {@link BCryptPasswordEncoder} */
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /** {@link ListMapper}. */
    private final ListMapper listMapper;

    @Autowired
    public UserPersistenceServiceHandler(final UserRepository userRepository, final RoleRepository roleRepository,
                                         final AddressRepository addressRepository,
                                         final UserPersistenceMapper userPersistenceMapper,
                                         final AddressPersistenceMapper addressPersistenceMapper,
                                         final TradingAccountPersistenceMapper tradingAccountPersistenceMapper,
                                         final BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.addressRepository = addressRepository;
        this.userPersistenceMapper = userPersistenceMapper;
        this.addressPersistenceMapper = addressPersistenceMapper;
        this.tradingAccountPersistenceMapper = tradingAccountPersistenceMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

        listMapper = new ListMapper();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public User saveUser(final User user) {

        LOG.debug("Saving user, {}", user);

        UserPersistenceModel userPersistenceModel = userPersistenceMapper.mapTo(user);
        userPersistenceModel.setPassword(bCryptPasswordEncoder.encode(userPersistenceModel.getPassword()));
        userPersistenceModel.setRoles(IterableUtils.toList(roleRepository.findAll()));

        userPersistenceModel = updateChildObjectReferences(userPersistenceModel);

        final UserPersistenceModel userPersistenceModelSaved = userRepository.save(userPersistenceModel);

        final User userSaved = userPersistenceMapper.mapFrom(userPersistenceModelSaved);

        LOG.debug("Successfully save user, {}", userSaved);

        return userSaved;
    }

    /**
     * Load user by username from repo.
     *
     * @param userEmail
     *         Users email.
     * @return {@link UserDetails}
     * @throws UsernameNotFoundException
     */
    @Override
    public User findUserByEmail(final String userEmail) throws UsernameNotFoundException {

        LOG.debug("Finding user by email: {}", userEmail);

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(userEmail);

        LOG.debug("Found user persistence model: {}", userPersistenceModel);

        final User user = userPersistenceMapper.mapFrom(userPersistenceModel);

        LOG.debug("Successfully found user: {}", user);

        return user;
    }

    /**
     * Load user by username from repo.
     *
     * @param userEmail
     *         Users email.
     * @return {@link UserDetails}
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional
    public User findUserByEmailLoadStorage(final String userEmail) throws UsernameNotFoundException {

        LOG.debug("Finding user by email: {}", userEmail);

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(userEmail);

        Hibernate.initialize(userPersistenceModel.getItemListingPersistenceModelList());

        LOG.debug("User stored items: {}", userPersistenceModel.getItemListingPersistenceModelList());

        final User user = userPersistenceMapper.mapFrom(userPersistenceModel);

        LOG.debug("Successfully found user: {}", user);

        return user;
    }

    /**
     * Find user by email - load profile info.
     *
     * @param userEmail
     *         Users unique ref.
     * @return {@link User}
     * @throws UsernameNotFoundException
     */
    @Transactional
    @Override
    public User findUserByEmailLoadProfile(final String userEmail) throws UsernameNotFoundException {
        LOG.debug("Finding user by email: {}", userEmail);

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(userEmail);

        Hibernate.initialize(userPersistenceModel.getAddressPersistenceModels());
        Hibernate.initialize(userPersistenceModel.getPaymentInformationPersistenceModel());
        Hibernate.initialize(userPersistenceModel.getTradingAccountPersistenceModelList());

        LOG.debug("User stored items: {}", userPersistenceModel.getItemListingPersistenceModelList());

        final User user = userPersistenceMapper.mapFrom(userPersistenceModel);

        LOG.debug("Successfully found user: {}", user);

        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<TradingAccount> loadUserTradingAccounts(final String userEmail) {

        LOG.debug("Loading user trading accounts for {}", userEmail);

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(userEmail);

        final List<TradingAccountPersistenceModel> tradingAccountPersistenceModels = userPersistenceModel
                .getTradingAccountPersistenceModelList();

        final List<TradingAccount> tradingAccounts = listMapper.mapList((AbstractMapper)
                                                                                tradingAccountPersistenceMapper,
                                                                        false, tradingAccountPersistenceModels);

        LOG.debug("Successfully returning trading accounts: {}", tradingAccounts);

        return tradingAccounts;
    }

    /**
     * Sets reference relationships where hibernate/jpa won't automatically before persistence.
     *
     * @param userPersistenceModel
     *         {@link UserPersistenceModel}
     * @return {@link UserPersistenceModel}
     */
    private UserPersistenceModel updateChildObjectReferences(final UserPersistenceModel userPersistenceModel) {

        LOG.debug("Updating child object references to owner");
        if (userPersistenceModel.getAddressPersistenceModels() != null) {
            for (final AddressPersistenceModel addressPersistenceModel : userPersistenceModel
                    .getAddressPersistenceModels()) {
                addressPersistenceModel.setUserPersistenceModel(userPersistenceModel);
            }
        }

        if (userPersistenceModel.getPaymentInformationPersistenceModel() != null) {

            userPersistenceModel.getPaymentInformationPersistenceModel().setUserPersistenceModel(userPersistenceModel);
        }

        return userPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUserAddress(final String userEmail, final Address address) {

        LOG.debug("Updating user address {} for user {}", address, userEmail);

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(userEmail);

        final AddressPersistenceModel addressPersistenceModel = addressPersistenceMapper.mapTo(address);
        addressPersistenceModel.setUserPersistenceModel(userPersistenceModel);

        addressRepository.save(addressPersistenceModel);

        LOG.debug("Successfully updated address for user.");

    }

}
