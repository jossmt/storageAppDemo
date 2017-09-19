package com.app.storage.domain.model.trade;

import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.domain.model.User;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.List;

/**
 * Trading account domain model.
 */
public class TradingAccount {

    /** Account name. */
    private String accountName;

    /** Account password. */
    private String accountPassword;

    /** {@link AccountType}. */
    private AccountType accountType;

    /** Storage item list. */
    private List<ItemListing> itemListings;

    /** User account authentication token. */
    private String authToken;

    /** {@link User}. */
    private User owner;

    /**
     * Gets Account password..
     *
     * @return Value of Account password..
     */
    public String getAccountPassword() {
        return accountPassword;
    }

    /**
     * Gets {@link AccountType}..
     *
     * @return Value of {@link AccountType}..
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets new Account name..
     *
     * @param accountName
     *         New value of Account name..
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Sets new {@link AccountType}..
     *
     * @param accountType
     *         New value of {@link AccountType}..
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * Sets new Account password..
     *
     * @param accountPassword
     *         New value of Account password..
     */
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    /**
     * Gets Account name..
     *
     * @return Value of Account name..
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Gets Storage item list..
     *
     * @return Value of Storage item list..
     */
    public List<ItemListing> getItemListings() {
        return itemListings;
    }

    /**
     * Sets new Storage item list..
     *
     * @param itemListings
     *         New value of Storage item list..
     */
    public void setItemListings(List<ItemListing> itemListings) {
        this.itemListings = itemListings;
    }

    /**
     * Sets new {@link User}..
     *
     * @param owner
     *         New value of {@link User}..
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Gets {@link User}..
     *
     * @return Value of {@link User}..
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Gets User account authentication token..
     *
     * @return Value of User account authentication token..
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * Sets new User account authentication token..
     *
     * @param authToken
     *         New value of User account authentication token..
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
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
        if (!(obj instanceof TradingAccount))
            return false;
        if (obj == this)
            return true;

        TradingAccount tradingAccount = (TradingAccount) obj;
        return new EqualsBuilder()
                .append(getAccountName(), tradingAccount.getAccountName())
                .append(getAccountPassword(), tradingAccount.getAccountPassword())
                .append(getAccountType(), tradingAccount.getAccountType())
                .append(getAuthToken(), tradingAccount.getAuthToken())
                .isEquals();
    }

    /**
     * To String builder.
     *
     * @return String.
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(accountName).append(accountPassword).append(accountType).append(authToken);

        return stringBuilder.toString();
    }
}
