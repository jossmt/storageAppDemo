package com.app.storage.domain.model.trade;

import org.apache.commons.lang.builder.EqualsBuilder;

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

        stringBuilder.append(accountName).append(accountPassword).append(accountType);

        return stringBuilder.toString();
    }
}
