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
package com.app.storage.persistence.model;

import com.app.storage.persistence.model.payment.PaymentInformationPersistenceModel;
import com.app.storage.persistence.model.trade.TradingAccountPersistenceModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a user in our system.
 */
@Entity
@Table(name = "User")
public class UserPersistenceModel {

    private static final Logger LOG = LoggerFactory.getLogger(UserPersistenceModel.class);

    /** Table id reference. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    /** First name. */
    @Column(name = "first_name")
    private String firstName;

    /** Last name. */
    @Column(name = "last_name")
    private String lastName;

    /** Email. */
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    /** Password. */
    @Column(name = "password")
    private String password;

    /** User role privileges. */
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name
            = "role_id"))
    @ManyToMany(fetch = FetchType.EAGER)
    private List<RolePersistenceModel> roles;

    /** List of users items. */
    @OneToMany(mappedBy = "userPersistenceModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemListingPersistenceModel> itemListingPersistenceModelList;

    /** List of trading accounts. */
    @OneToMany(mappedBy = "userPersistenceModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TradingAccountPersistenceModel> tradingAccountPersistenceModelList;

    /** List of users payment options. */
    @OneToOne(mappedBy = "userPersistenceModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PaymentInformationPersistenceModel paymentInformationPersistenceModel;

    /** Billing Address. */
    @OneToMany(mappedBy = "userPersistenceModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
    private List<AddressPersistenceModel> addressPersistenceModels;

    /**
     * Sets new email.
     *
     * @param email
     *         New value of email.
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Sets new password.
     *
     * @param password
     *         New value of password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return Value of email.
     */
    public String getEmail() {
        return email;
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
     * Sets new firstName.
     *
     * @param firstName
     *         New value of firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets new lastName.
     *
     * @param lastName
     *         New value of lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * Return roles.
     *
     * @return list of {@link RolePersistenceModel}
     */
    public List<RolePersistenceModel> getRoles() {
        return roles;
    }

    /**
     * Set users privileges.
     *
     * @param roles
     *         User roles.
     */
    public void setRoles(List<RolePersistenceModel> roles) {
        this.roles = roles;
    }

    /**
     * Gets List of users items..
     *
     * @return Value of List of users items..
     */
    public List<ItemListingPersistenceModel> getItemListingPersistenceModelList() {
        return itemListingPersistenceModelList;
    }

    /**
     * Sets new List of users items..
     *
     * @param itemListingPersistenceModelList
     *         New value of List of users items..
     */
    public void setItemListingPersistenceModelList(List<ItemListingPersistenceModel> itemListingPersistenceModelList) {
        this.itemListingPersistenceModelList = itemListingPersistenceModelList;
    }

    /**
     * Gets List of users payment options..
     *
     * @return Value of List of users payment options..
     */
    public PaymentInformationPersistenceModel getPaymentInformationPersistenceModel() {
        return paymentInformationPersistenceModel;
    }

    /**
     * Sets new List of users payment options..
     *
     * @param paymentInformationPersistenceModel
     *         New value of List of users payment options..
     */
    public void setPaymentInformationPersistenceModel(final PaymentInformationPersistenceModel
                                                              paymentInformationPersistenceModel) {
        this.paymentInformationPersistenceModel = paymentInformationPersistenceModel;
    }

    /**
     * Sets new addressPersistenceModel.
     *
     * @param addressPersistenceModels
     *         New value of addressPersistenceModel.
     */
    public void setAddressPersistenceModels(final List<AddressPersistenceModel> addressPersistenceModels) {
        this.addressPersistenceModels = addressPersistenceModels;
    }

    /**
     * Add new addressPersistenceModel.
     *
     * @param addressPersistenceModel
     *         New value of addressPersistenceModel.
     */
    @Transactional
    public void addAddress(final AddressPersistenceModel addressPersistenceModel) {

        addressPersistenceModels.add(addressPersistenceModel);
    }

    /**
     * Add new addressPersistenceModel.
     *
     * @param addressPersistenceModel
     *         New value of addressPersistenceModel.
     */
    @Transactional
    public void removeAddress(final AddressPersistenceModel addressPersistenceModel) {

        addressPersistenceModels.remove(addressPersistenceModel);
    }

    /**
     * Removes any duplicate addresses (can only be 1 billing/1 delivery)
     */
    @Transactional
    public void removeAllDuplicateAddress() {

        final Iterator<AddressPersistenceModel> addressPersistenceModelIterator = addressPersistenceModels.iterator();

        Integer billingCount = 0;
        Integer deliveryCount = 0;

        Long oldBilling = 0L;
        Long oldDelivery = 0L;

        while (addressPersistenceModelIterator.hasNext()) {

            final AddressPersistenceModel addressPersistenceModel = addressPersistenceModelIterator.next();
            if (addressPersistenceModel.getAddressType().equals("BILLING")) {

                billingCount++;
                if ((billingCount > 1 && addressPersistenceModel.getId() < oldBilling) || billingCount < 2) {

                    oldBilling = addressPersistenceModel.getId();
                }
            } else {
                deliveryCount++;
                if ((deliveryCount > 1 && addressPersistenceModel.getId() < oldDelivery) || deliveryCount < 2) {

                    oldDelivery = addressPersistenceModel.getId();
                }
            }
        }

        if (billingCount > 1) {
            final Long oldId = oldBilling;
            addressPersistenceModels.removeIf(addressPersistenceModel -> addressPersistenceModel.getId().equals
                    (oldId));
        }
        if (deliveryCount > 1) {
            final Long oldId = oldDelivery;
            addressPersistenceModels.removeIf(addressPersistenceModel -> addressPersistenceModel.getId().equals
                    (oldId));
        }
    }

    /**
     * Gets addressPersistenceModel.
     *
     * @return Value of addressPersistenceModel.
     */
    public List<AddressPersistenceModel> getAddressPersistenceModels() {
        return addressPersistenceModels;
    }

    /**
     * Gets List of trading accounts..
     *
     * @return Value of List of trading accounts..
     */
    public List<TradingAccountPersistenceModel> getTradingAccountPersistenceModelList() {
        return tradingAccountPersistenceModelList;
    }

    /**
     * Sets new List of trading accounts..
     *
     * @param tradingAccountPersistenceModelList
     *         New value of List of trading accounts..
     */
    public void setTradingAccountPersistenceModelList(List<TradingAccountPersistenceModel>
                                                              tradingAccountPersistenceModelList) {
        this.tradingAccountPersistenceModelList = tradingAccountPersistenceModelList;
    }

    /**
     * Sets new Table id reference..
     *
     * @param id
     *         New value of Table id reference..
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets Table id reference..
     *
     * @return Value of Table id reference..
     */
    public Long getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof UserPersistenceModel))
            return false;
        if (obj == this)
            return true;

        UserPersistenceModel userPersistenceModel = (UserPersistenceModel) obj;
        return new EqualsBuilder()
                .append(getFirstName(), userPersistenceModel.getFirstName())
                .append(getLastName(), userPersistenceModel.getLastName())
                .append(getEmail(), userPersistenceModel.getEmail())
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(firstName).append(lastName).append(email).append(password).append(roles);

        return stringBuilder.toString();
    }
}