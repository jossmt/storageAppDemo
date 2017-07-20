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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a user in our system.
 */
public class User implements Serializable {

    /** Identifier. */
    private Long id;

    /** First name. */
    @NotEmpty(message = "First name is required.")
    private String firstName;

    /** Last name. */
    @NotEmpty(message = "Last name is required.")
    private String lastName;

    /** Email. */
    @Email(message = "Please provide a valid email address.")
    @NotEmpty(message = "Email is required.")
    private String email;

    /** Password. */
    @NotEmpty(message = "Password is required.")
    private String password;

    @NotEmpty(message = "Password is required.")
    private String passwordConfirm;

    private List<Role> roles;


    /**
     * Gets email.
     *
     * @return Value of email.
     */
    public String getEmail() {
        return email;
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
        this.id = user.id;
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
     * Sets new Identifier..
     *
     * @param id
     *         New value of Identifier..
     */
    public void setId(Long id) {
        this.id = id;
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
                .append(id, user.getId())
                .append(email, user.getEmail())
                .append(firstName, user.getFirstName())
                .append(lastName, user.getLastName())
                .append(password, user.getPassword())
                .append(passwordConfirm, user.getPasswordConfirm())
                .append(roles, user.getRoles())
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

        stringBuilder.append(id).append(firstName).append(lastName).append(email).append(password).append
                (passwordConfirm).append(roles);

        return stringBuilder.toString();
    }
}