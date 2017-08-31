package com.app.storage.persistence.mapper.trade;

import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.persistence.model.trade.TradingAccountPersistenceModel;

/**
 * Trade account persistence mapper
 */
public interface TradingAccountPersistenceMapper {

    /**
     * Maps from {@link TradingAccount} to {@link TradingAccountPersistenceModel}
     *
     * @param tradingAccount
     *         {@link TradingAccount}
     * @return {@link TradingAccountPersistenceModel}
     */
    TradingAccountPersistenceModel mapTo(TradingAccount tradingAccount);

    /**
     * Maps from {@link TradingAccountPersistenceModel} to {@link TradingAccount}
     *
     * @param tradingAccountPersistenceModel
     *         {@link TradingAccountPersistenceModel}
     * @return {@link TradingAccount}
     */
    TradingAccount mapFrom(TradingAccountPersistenceModel tradingAccountPersistenceModel);
}
