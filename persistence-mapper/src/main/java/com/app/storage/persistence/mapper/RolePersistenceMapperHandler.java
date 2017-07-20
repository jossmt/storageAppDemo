package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Role;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.RolePersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolePersistenceMapperHandler implements RolePersistenceMapper, AbstractMapper<RolePersistenceModel, Role> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(RolePersistenceMapper.class);

    /** {@link UserPersistenceMapper} */
    @Autowired
    private UserPersistenceMapper userPersistenceMapper;

    /** {@link ListMapper}. */
    private ListMapper listMapper;

    /**
     * Constructor
     */
    @Autowired
    public RolePersistenceMapperHandler(final ListMapper listMapper) {
        this.listMapper = listMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RolePersistenceModel mapTo(final Role role) {

        LOG.debug("Mapping role {} to persistence model.", role);

        RolePersistenceModel rolePersistenceModel = null;
        if (role != null) {
            rolePersistenceModel = new RolePersistenceModel();
            rolePersistenceModel.setId(role.getId());
            rolePersistenceModel.setName(role.getName());
            rolePersistenceModel.setUsers(listMapper.mapList((AbstractMapper) userPersistenceMapper,
                                                             true, role.getUsers()));
        }

        LOG.debug("Successfully mapped role model to persistence model {}", rolePersistenceModel);
        return rolePersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role mapFrom(final RolePersistenceModel rolePersistenceModel) {

        LOG.debug("Mapping role persistence model {} to domain model.", rolePersistenceModel);

        Role role = null;
        if (rolePersistenceModel != null) {
            role = new Role();
            role.setId(rolePersistenceModel.getId());
            role.setName(rolePersistenceModel.getName());
            role.setUsers(listMapper.mapList((AbstractMapper) userPersistenceMapper,
                                             false, role.getUsers()));
        }

        LOG.debug("Successfully mapped role persistence model to domain model {}", role);

        return role;
    }
}
