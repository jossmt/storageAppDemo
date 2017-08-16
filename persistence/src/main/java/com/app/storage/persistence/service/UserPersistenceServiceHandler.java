package com.app.storage.persistence.service;

import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.UserPersistenceMapper;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.model.UserPersistenceModel;
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
    public User saveUser(final User user) {

        LOG.debug("Saving user, {}", user);

        final UserPersistenceModel userPersistenceModel = userPersistenceMapper.mapTo(user);
        userPersistenceModel.setPassword(bCryptPasswordEncoder.encode(userPersistenceModel.getPassword()));
        userPersistenceModel.setRoles(IterableUtils.toList(roleRepository.findAll()));

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

}
