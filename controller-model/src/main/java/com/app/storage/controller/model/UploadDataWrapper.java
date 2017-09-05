package com.app.storage.controller.model;

import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.domain.model.trade.TradingAccount;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Wrapper for user upload data.
 */
public class UploadDataWrapper {

    /** {@link ItemListing}. */
    private ItemListing itemListing;

    /** Defaults to true for paypal - false=cash on collection */
    private boolean paymentType = true;

    /** {@link TradingAccount}. */
    private String[] tradingAccounts;

    /**
     * Gets {@link ItemListing}..
     *
     * @return Value of {@link ItemListing}..
     */
    public ItemListing getItemListing() {
        return itemListing;
    }

    /**
     * Sets new {@link ItemListing}..
     *
     * @param itemListing
     *         New value of {@link ItemListing}..
     */
    public void setItemListing(ItemListing itemListing) {
        this.itemListing = itemListing;
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
                .append(getItemListing(), uploadDataWrapper.getItemListing())
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

        stringBuilder.append(itemListing).append(tradingAccounts).append(getPaymentType());

        return stringBuilder.toString();
    }
}
