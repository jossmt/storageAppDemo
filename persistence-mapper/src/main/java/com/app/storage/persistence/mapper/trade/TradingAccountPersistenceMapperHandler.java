package com.app.storage.persistence.mapper.trade;

import com.app.storage.domain.model.trade.AccountType;
import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.persistence.mapper.StorageItemPersistenceMapper;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.trade.TradingAccountPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link TradingAccountPersistenceMapper}
 */
@Component
public class TradingAccountPersistenceMapperHandler implements TradingAccountPersistenceMapper {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(TradingAccountPersistenceMapper.class);

    /** {@link StorageItemPersistenceMapper}. */
    private StorageItemPersistenceMapper storageItemPersistenceMapper;

    /** {@link ListMapper}. */
    private ListMapper listMapper = new ListMapper();

    /**
     * {@inheritDoc}
     */
    @Override
    public TradingAccountPersistenceModel mapTo(final TradingAccount tradingAccount) {

        LOG.debug("Mapping trading account domain model: {} to persistence model", tradingAccount);

        TradingAccountPersistenceModel tradingAccountPersistenceModel = null;
        if (tradingAccount != null) {

            tradingAccountPersistenceModel = new TradingAccountPersistenceModel();
            tradingAccountPersistenceModel.setAccountName(tradingAccount.getAccountName());
            tradingAccountPersistenceModel.setAccountPassword(tradingAccount.getAccountPassword());
            tradingAccountPersistenceModel.setAccountType(tradingAccount.getAccountType().toString());

            if (tradingAccount.getStorageItems() != null) {
                tradingAccountPersistenceModel.setStorageItemPersistenceModels(listMapper.mapList
                        ((AbstractMapper) storageItemPersistenceMapper, false, tradingAccount.getStorageItems()));
            }
        }

        LOG.debug("Successfully mapped to trading account persistence model: {}", tradingAccountPersistenceModel);

        return tradingAccountPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TradingAccount mapFrom(final TradingAccountPersistenceModel tradingAccountPersistenceModel) {

        LOG.debug("Mapping persistence model: {} to domain model", tradingAccountPersistenceModel);

        TradingAccount tradingAccount = null;
        if (tradingAccountPersistenceModel != null) {

            tradingAccount = new TradingAccount();
            tradingAccount.setAccountName(tradingAccountPersistenceModel.getAccountName());
            tradingAccount.setAccountPassword(tradingAccountPersistenceModel.getAccountPassword());
            tradingAccount.setAccountType(AccountType.valueOf(tradingAccountPersistenceModel.getAccountType()));

            if (tradingAccountPersistenceModel.getStorageItemPersistenceModels() != null) {
                tradingAccount.setStorageItems(listMapper.mapList(
                        (AbstractMapper) storageItemPersistenceMapper, true, tradingAccountPersistenceModel
                                .getStorageItemPersistenceModels()));
            }
        }

        LOG.debug("Successfully mapped persistence model to domain model: {}", tradingAccount);

        return tradingAccount;
    }

    /**
     * Sets new {@link StorageItemPersistenceMapper}..
     *
     * @param storageItemPersistenceMapper
     *         New value of {@link StorageItemPersistenceMapper}..
     */
    @Autowired
    public void setStorageItemPersistenceMapper(StorageItemPersistenceMapper storageItemPersistenceMapper) {
        this.storageItemPersistenceMapper = storageItemPersistenceMapper;
    }
}
