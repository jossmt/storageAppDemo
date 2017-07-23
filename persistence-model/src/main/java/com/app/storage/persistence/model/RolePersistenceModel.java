package com.app.storage.persistence.model;

import org.apache.commons.lang.builder.EqualsBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Role")
public class RolePersistenceModel {

    /** Identifier. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    /** Name. */
    @Column(name = "role")
    private String name;

    /**
     * Return identifier.
     *
     * @return id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Get name.
     *
     * @return user name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name
     *         user name.
     */
    public void setName(String name) {
        this.name = name;
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
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof RolePersistenceModel))
            return false;
        if (obj == this)
            return true;

        RolePersistenceModel rolePersistenceModel = (RolePersistenceModel) obj;
        return new EqualsBuilder()
                .append(getName(), rolePersistenceModel.getName())
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(id).append(name);

        return stringBuilder.toString();
    }
}
