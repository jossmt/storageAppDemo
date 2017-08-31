package com.app.storage.persistence.mapper.trade;

import com.app.storage.domain.model.trade.AccountType;
import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.persistence.model.trade.TradingAccountPersistenceModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link TradingAccountPersistenceMapper}
 */
public class TradingAccountPersistenceMapperTest {

    /** {@link TradingAccountPersistenceMapper}. */
    private TradingAccountPersistenceMapper tradingAccountPersistenceMapper;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        tradingAccountPersistenceMapper = new TradingAccountPersistenceMapperHandler();
    }


    /**
     * Full map to test
     */
    @Test
    public void fullMapToTest() {

        //setup
        final TradingAccountPersistenceModel tradingAccountPersistenceModel = new TradingAccountPersistenceModel();
        tradingAccountPersistenceModel.setAccountType("EBAY");
        tradingAccountPersistenceModel.setAccountPassword("password");
        tradingAccountPersistenceModel.setAccountName("name");

        final TradingAccount tradingAccount = new TradingAccount();
        tradingAccount.setAccountType(AccountType.EBAY);
        tradingAccount.setAccountPassword("password");
        tradingAccount.setAccountName("name");

        //Test
        final TradingAccountPersistenceModel tradingAccountPersistenceModelActual = tradingAccountPersistenceMapper
                .mapTo(tradingAccount);

        //Assert
        Assert.assertEquals(tradingAccountPersistenceModel, tradingAccountPersistenceModelActual);

    }

    /**
     * Full Map From test
     */
    @Test
    public void fullMapFromTest() {

        //setup
        final TradingAccountPersistenceModel tradingAccountPersistenceModel = new TradingAccountPersistenceModel();
        tradingAccountPersistenceModel.setAccountType("EBAY");
        tradingAccountPersistenceModel.setAccountPassword("password");
        tradingAccountPersistenceModel.setAccountName("name");

        final TradingAccount tradingAccount = new TradingAccount();
        tradingAccount.setAccountType(AccountType.EBAY);
        tradingAccount.setAccountPassword("password");
        tradingAccount.setAccountName("name");

        //Test
        final TradingAccount tradingAccountActual = tradingAccountPersistenceMapper.mapFrom
                (tradingAccountPersistenceModel);

        //Assert
        Assert.assertEquals(tradingAccount, tradingAccountActual);

    }
}
