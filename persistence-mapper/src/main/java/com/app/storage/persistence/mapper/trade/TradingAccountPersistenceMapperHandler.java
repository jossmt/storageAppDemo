package com.app.storage.persistence.mapper.trade;

import com.app.storage.domain.model.trade.AccountType;
import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.persistence.mapper.ItemListingPersistenceMapper;
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
public class TradingAccountPersistenceMapperHandler implements TradingAccountPersistenceMapper,
        AbstractMapper<TradingAccountPersistenceModel, TradingAccount> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(TradingAccountPersistenceMapper.class);

    /** {@link ItemListingPersistenceMapper}. */
    private ItemListingPersistenceMapper itemListingPersistenceMapper;

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

            if (tradingAccount.getItemListings() != null) {
                tradingAccountPersistenceModel.setItemListingPersistenceModels(listMapper.mapList
                        ((AbstractMapper) itemListingPersistenceMapper, false, tradingAccount.getItemListings()));
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

            if (tradingAccountPersistenceModel.getItemListingPersistenceModels() != null) {
                tradingAccount.setItemListings(listMapper.mapList(
                        (AbstractMapper) itemListingPersistenceMapper, true, tradingAccountPersistenceModel
                                .getItemListingPersistenceModels()));
            }
        }

        LOG.debug("Successfully mapped persistence model to domain model: {}", tradingAccount);

        return tradingAccount;
    }

    /**
     * Sets new {@link ItemListingPersistenceMapper}..
     *
     * @param itemListingPersistenceMapper
     *         New value of {@link ItemListingPersistenceMapper}..
     */
    @Autowired
    public void setItemListingPersistenceMapper(ItemListingPersistenceMapper itemListingPersistenceMapper) {
        this.itemListingPersistenceMapper = itemListingPersistenceMapper;
    }
}
