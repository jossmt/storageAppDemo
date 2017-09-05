/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.app.storage.domain.model;

import com.app.storage.domain.model.listing.ItemListing;
import com.app.storage.domain.model.payment.PaymentInformation;
import com.app.storage.domain.model.trade.TradingAccount;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a user in our system.
 */
public class User implements Serializable {

    /** First name. */
    @NotEmpty(message = "First name is required.")
    private String firstName;

    /** Last name. */
    @NotEmpty(message = "Last name is required.")
    private String lastName;

    /** Email. */
    @Email(message = "Please provide a valid email addressList.")
    @NotEmpty(message = "Email is required.")
    private String email;

    /** Password. */
    @NotEmpty(message = "Password is required.")
    private String password;

    /** Confirmation password. */
    @NotEmpty(message = "Password is required.")
    private String passwordConfirm;

    /** List of {@Role}. */
    private List<Role> roles;

    /** list of {@link ItemListing}. */
    private List<ItemListing> itemListings;

    /** list of {@link TradingAccount}. */
    private List<TradingAccount> tradingAccounts;

    /** {@link PaymentInformation}. */
    private PaymentInformation paymentInformation;

    /** List of {@link Address}. */
    private List<Address> addressList;


    /**
     * Gets email.
     *
     * @return Value of email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets password.
     *
     * @return Value of password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets firstName.
     *
     * @return Value of firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets lastName.
     *
     * @return Value of lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets roles.
     *
     * @return roles.
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Gets passwordConfirm.
     *
     * @return Value of passwordConfirm.
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public User() {
    }

    /**
     * Constructor for custom spring-security method
     *
     * @param user
     *         {@link User}
     */
    public User(final User user) {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.password = user.password;
    }

    /**
     * Sets new First name..
     *
     * @param firstName
     *         New value of First name..
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets new Password..
     *
     * @param password
     *         New value of Password..
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets new passwordConfirm.
     *
     * @param passwordConfirm
     *         New value of passwordConfirm.
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    /**
     * Sets new roles.
     *
     * @param roles
     *         New value of roles.
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * Sets new Last name..
     *
     * @param lastName
     *         New value of Last name..
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets new Email..
     *
     * @param email
     *         New value of Email..
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets all user storage items.
     *
     * @return {@link ItemListing}
     */
    public List<ItemListing> getItemListings() {
        return itemListings;
    }

    /**
     * Sets storage items.
     *
     * @param itemListings
     *         list of {@link ItemListing}
     */
    public void setItemListings(List<ItemListing> itemListings) {
        this.itemListings = itemListings;
    }

    /**
     * Gets {@link PaymentInformation}..
     *
     * @return Value of {@link PaymentInformation}..
     */
    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    /**
     * Sets new List of {@link PaymentInformation}..
     *
     * @param paymentInformation
     *         New value of List of {@link PaymentInformation}..
     */
    public void setPaymentInformation(final PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    /**
     * Gets List of {@link Address}..
     *
     * @return Value of List of {@link Address}..
     */
    public List<Address> getAddressList() {
        return addressList;
    }

    /**
     * Sets new List of {@link Address}..
     *
     * @param addressList
     *         New value of List of {@link Address}..
     */
    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    /**
     * Sets new list of {@link TradingAccount}..
     *
     * @param tradingAccounts
     *         New value of list of {@link TradingAccount}..
     */
    public void setTradingAccounts(List<TradingAccount> tradingAccounts) {
        this.tradingAccounts = tradingAccounts;
    }

    /**
     * Gets list of {@link TradingAccount}..
     *
     * @return Value of list of {@link TradingAccount}..
     */
    public List<TradingAccount> getTradingAccounts() {
        return tradingAccounts;
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
        if (!(obj instanceof User))
            return false;
        if (obj == this)
            return true;

        User user = (User) obj;
        return new EqualsBuilder()
                .append(getEmail(), user.getEmail())
                .append(getFirstName(), user.getFirstName())
                .append(getLastName(), user.getLastName())
                .append(getPassword(), user.getPassword())
                .append(getPasswordConfirm(), user.getPasswordConfirm())
                .append(getRoles(), user.getRoles())
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

        stringBuilder.append(firstName).append(lastName).append(email).append(password).append
                (passwordConfirm).append(roles);

        return stringBuilder.toString();
    }
}