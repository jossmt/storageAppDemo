package com.app.storage.controller.model;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.trade.TradingAccount;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Wrapper for user upload data.
 */
public class UploadDataWrapper {

    /** {@link StorageItem}. */
    private StorageItem storageItem;

    /** Defaults to true for paypal - false=cash on collection */
    private boolean paymentType = true;

    /** {@link TradingAccount}. */
    private String[] tradingAccounts;

    /**
     * Gets {@link StorageItem}..
     *
     * @return Value of {@link StorageItem}..
     */
    public StorageItem getStorageItem() {
        return storageItem;
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
     * Sets new {@link TradingAccount}..
     *
     * @param tradingAccounts
     *         New value of {@link TradingAccount}..
     */
    public void setTradingAccounts(String[] tradingAccounts) {
        this.tradingAccounts = tradingAccounts;
    }

    /**
     * Gets {@link TradingAccount}..
     *
     * @return Value of {@link TradingAccount}..
     */
    public String[] getTradingAccounts() {
        return tradingAccounts;
    }

    /**
     * Sets new Defaults to true for paypal - false=cash on collection.
     *
     * @param paymentType
     *         New value of Defaults to true for paypal - false=cash on collection.
     */
    public void setPaymentType(boolean paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * Gets Defaults to true for paypal - false=cash on collection.
     *
     * @return Value of Defaults to true for paypal - false=cash on collection.
     */
    public boolean getPaymentType() {
        return paymentType;
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
                .append(getStorageItem(), uploadDataWrapper.getStorageItem())
                .append(getTradingAccounts(), uploadDataWrapper.getTradingAccounts())
                .append(getPaymentType(), uploadDataWrapper.getPaymentType())
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

        stringBuilder.append(storageItem).append(tradingAccounts).append(getPaymentType());

        return stringBuilder.toString();
    }
}
