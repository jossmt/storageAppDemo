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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a user in our system.
 */
@Entity
@Table(name = "User")
public class UserPersistenceModel {

    /** Identifier. */
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
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name
            = "role_id"))
    private List<RolePersistenceModel> roles;

    /** List of users items. */
    @OneToMany(mappedBy = "userPersistenceModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StorageItemPersistenceModel> storageItemPersistenceModelList;

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
     * Sets new id.
     *
     * @param id
     *         New value of id.
     */
    public void setId(Long id) {
        this.id = id;
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
     * Gets id.
     *
     * @return Value of id.
     */
    public Long getId() {
        return id;
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
    public List<StorageItemPersistenceModel> getStorageItemPersistenceModelList() {
        return storageItemPersistenceModelList;
    }

    /**
     * Sets new List of users items..
     *
     * @param storageItemPersistenceModelList
     *         New value of List of users items..
     */
    public void setStorageItemPersistenceModelList(List<StorageItemPersistenceModel> storageItemPersistenceModelList) {
        this.storageItemPersistenceModelList = storageItemPersistenceModelList;
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
                .append(getPassword(), userPersistenceModel.getPassword())
                .append(getRoles(), userPersistenceModel.getRoles())
                .append(getStorageItemPersistenceModelList(), userPersistenceModel.getStorageItemPersistenceModelList())
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(id).append(firstName).append(lastName).append(email).append(password).append(roles);

        return stringBuilder.toString();
    }
}