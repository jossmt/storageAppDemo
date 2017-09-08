package com.app.storage.persistence.service;

import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.mapper.trade.TradingAccountPersistenceMapper;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.trade.TradingAccountPersistenceModel;
import com.app.storage.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link TradingAccountPersistenceService}
 */
@Service
public class TradingAccountPersistenceServiceHandler implements TradingAccountPersistenceService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(TradingAccountPersistenceService.class);

    /** {@link UserRepository}. */
    private final UserRepository userRepository;

    /** {@link TradingAccountPersistenceMapper}. */
    private final TradingAccountPersistenceMapper tradingAccountPersistenceMapper;

    /** {@link ListMapper}. */
    private final ListMapper listMapper;

    /**
     * Constructor
     */
    @Autowired
    public TradingAccountPersistenceServiceHandler(final UserRepository userRepository,
                                                   final TradingAccountPersistenceMapper
                                                           tradingAccountPersistenceMapper) {

        this.userRepository = userRepository;
        this.tradingAccountPersistenceMapper = tradingAccountPersistenceMapper;

        listMapper = new ListMapper();
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
}
