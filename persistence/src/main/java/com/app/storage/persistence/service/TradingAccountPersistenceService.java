package com.app.storage.persistence.service;

import com.app.storage.domain.model.trade.TradingAccount;

import java.util.List;

/**
 * Trading account persistence service.
 */
public interface TradingAccountPersistenceService {

    /**
     * Load user trading accounts.
     *
     * @param email
     *         Unique user reference.
     * @return List of {@link TradingAccount}
     */
    List<TradingAccount> loadUserTradingAccounts(String email);
}
