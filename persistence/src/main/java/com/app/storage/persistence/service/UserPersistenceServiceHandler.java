package com.app.storage.persistence.service;

import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.UserPersistenceMapper;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.payment.CardInformationPersistenceModel;
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

    @Autowired
    public UserPersistenceServiceHandler(final UserRepository userRepository, final RoleRepository roleRepository,
                                         final UserPersistenceMapper userPersistenceMapper,
                                         final BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userPersistenceMapper = userPersistenceMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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

        Hibernate.initialize(userPersistenceModel.getStorageItemPersistenceModelList());

        LOG.debug("User stored items: {}", userPersistenceModel.getStorageItemPersistenceModelList());

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

        Hibernate.initialize(userPersistenceModel.getAddressPersistenceModel());
        Hibernate.initialize(userPersistenceModel.getCardInformationPersistenceModels());

        LOG.debug("User stored items: {}", userPersistenceModel.getStorageItemPersistenceModelList());

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

        userPersistenceModel.getAddressPersistenceModel().setUserPersistenceModel(userPersistenceModel);

        for (final CardInformationPersistenceModel cardInformationPersistenceModel : userPersistenceModel
                .getCardInformationPersistenceModels()) {
            cardInformationPersistenceModel.setUserPersistenceModel(userPersistenceModel);
        }

        return userPersistenceModel;
    }

}
