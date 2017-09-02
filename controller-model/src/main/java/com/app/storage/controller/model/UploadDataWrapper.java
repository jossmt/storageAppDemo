package com.app.storage.controller.model;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.trade.TradingAccount;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.List;

/**
 * Wrapper for user upload data.
 */
public class UploadDataWrapper {

    /** {@link StorageItem}. */
    private StorageItem storageItem;

    /** {@link Address}. */
    private Address address;

    /** {@link TradingAccount}. */
    private List<TradingAccount> tradingAccounts;


    /**
     * Sets new {@link Address}..
     *
     * @param address
     *         New value of {@link Address}..
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets {@link StorageItem}..
     *
     * @return Value of {@link StorageItem}..
     */
    public StorageItem getStorageItem() {
        return storageItem;
    }

    /**
     * Gets {@link TradingAccount}..
     *
     * @return Value of {@link TradingAccount}..
     */
    public List<TradingAccount> getTradingAccounts() {
        return tradingAccounts;
    }

    /**
     * Sets new {@link TradingAccount}..
     *
     * @param tradingAccounts
     *         New value of {@link TradingAccount}..
     */
    public void setTradingAccounts(List<TradingAccount> tradingAccounts) {
        this.tradingAccounts = tradingAccounts;
    }

    /**
     * Sets new {@link StorageItem}..
     *
     * @param storageItem
     *         New value of {@link StorageItem}..
     */
    public void setStorageItem(StorageItem storageItem) {
        this.storageItem = storageItem;
    }

    /**
     * Gets {@link Address}..
     *
     * @return Value of {@link Address}..
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Equals override.
     *
     * @param obj
     *         obj to compare.
     * @return equals boolean.
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof UploadDataWrapper))
            return false;
        if (obj == this)
            return true;

        UploadDataWrapper uploadDataWrapper = (UploadDataWrapper) obj;
        return new EqualsBuilder()
                .append(getAddress(), uploadDataWrapper.getAddress())
                .append(getStorageItem(), uploadDataWrapper.getStorageItem())
                .append(getTradingAccounts(), uploadDataWrapper.getTradingAccounts())
                .isEquals();
    }

    /**
     * To string builder.
     *
     * @return Object as string.
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(address).append(storageItem).append(tradingAccounts);

        return stringBuilder.toString();
    }
}
