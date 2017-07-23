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


    /**
     * Gets Name..
     *
     * @return Value of Name..
     */
    public String getName() {
        return name;
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
     * Sets new Identifier..
     *
     * @param id
     *         New value of Identifier..
     */
    public void setId(Long id) {
        this.id = id;
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

        stringBuilder.append(id).append(name);

        return stringBuilder.toString();
    }

}
