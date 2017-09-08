package com.app.storage.persistence.service;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.User;
import com.app.storage.domain.model.payment.PaymentInformation;
import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.persistence.mapper.AddressPersistenceMapper;
import com.app.storage.persistence.mapper.UserPersistenceMapper;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.mapper.payment.PaymentInformationPersistenceMapper;
import com.app.storage.persistence.mapper.trade.TradingAccountPersistenceMapper;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.AddressPersistenceModel;
import com.app.storage.persistence.model.payment.PaymentInformationPersistenceModel;
import com.app.storage.persistence.model.trade.TradingAccountPersistenceModel;
import com.app.storage.persistence.repository.AddressRepository;
import com.app.storage.persistence.repository.PaymentInformationRepository;
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

import java.util.Iterator;
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

    /** {@link UserPersistenceMapper} */
    private final UserPersistenceMapper userPersistenceMapper;

    /** {@link BCryptPasswordEncoder} */
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /** {@link ListMapper}. */
    private final ListMapper listMapper;

    /**
     * Constructor
     */
    @Autowired
    public UserPersistenceServiceHandler(final UserRepository userRepository, final RoleRepository roleRepository,
                                         final UserPersistenceMapper userPersistenceMapper,
                                         final BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userPersistenceMapper = userPersistenceMapper;
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

        final UserPersistenceModel existingUserPersistenceModel = userRepository.findByEmail(user.getEmail());
        if (existingUserPersistenceModel == null) {

            userPersistenceModel.setPassword(bCryptPasswordEncoder.encode(userPersistenceModel.getPassword()));
            userPersistenceModel.setRoles(IterableUtils.toList(roleRepository.findAll()));
        }
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
    @Transactional
    @Override
    public void updateUsername(final String email, final String firstName, final String lastName) {

        LOG.debug("Updating user : {} with first name: {} and last name : {}", email, firstName, lastName);

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(email);

        if (userPersistenceModel != null) {
            userPersistenceModel.setFirstName(firstName);
            userPersistenceModel.setLastName(lastName);
        } else {
            throw new UsernameNotFoundException("Invalid user email");
        }

        LOG.debug("Successfully saved user name information update");
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void updateUserEmail(final String userEmail, final String newEmail) {

        LOG.debug("Updating user email");

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(userEmail);

        userPersistenceModel.setEmail(newEmail);

        LOG.debug("Successfully updated user email");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUserPassword(final String userEmail, final String password) {

        LOG.debug("Updating user password");

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(userEmail);

        userPersistenceModel.setPassword(bCryptPasswordEncoder.encode(password));

        LOG.debug("Successfully updated password");

    }

}
