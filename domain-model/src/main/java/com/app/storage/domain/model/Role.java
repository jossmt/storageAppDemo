package com.app.storage.domain.model;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.List;

/**
 * Role domain model.
 */
public class Role {

    /** Identifier. */
    private Long id;

    /** Name. */
    private String name;

    /** Users listed with given role. */
    private List<User> users;


    /**
     * Gets Name..
     *
     * @return Value of Name..
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new Users listed with given role..
     *
     * @param users
     *         New value of Users listed with given role..
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Gets Users listed with given role..
     *
     * @return Value of Users listed with given role..
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Sets new Name..
     *
     * @param name
     *         New value of Name..
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets Identifier..
     *
     * @return Value of Identifier..
     */
    public Long getId() {
        return id;
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
        if (!(obj instanceof Role))
            return false;
        if (obj == this)
            return true;

        Role role = (Role) obj;
        return new EqualsBuilder()
                .append(getId(), role.getId())
                .append(getName(), role.getName())
                .append(getUsers(), role.getUsers())
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

        stringBuilder.append(id).append(name).append(users);

        return stringBuilder.toString();
    }
}
