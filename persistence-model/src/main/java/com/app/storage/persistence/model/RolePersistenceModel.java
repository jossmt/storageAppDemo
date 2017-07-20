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
    private Long id;

    /** Name. */
    @Column(name = "Name")
    private String name;

    /** Users. */
    private List<UserPersistenceModel> users;

    /**
     * Return identifier.
     *
     * @return id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Set identifier.
     *
     * @param id
     *         Identifier.
     */
    public void setId(Long id) {
        this.id = id;
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
     * Get users with role.
     *
     * @return all users with given role.
     */
    @ManyToMany(mappedBy = "roles")
    public List<UserPersistenceModel> getUsers() {
        return users;
    }

    /**
     * Set users to role.
     *
     * @param users
     *         list of users to give current role instance.
     */
    public void setUsers(List<UserPersistenceModel> users) {
        this.users = users;
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
                .append(getId(), rolePersistenceModel.getId())
                .append(getName(), rolePersistenceModel.getName())
                .append(getUsers(), rolePersistenceModel.getUsers())
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(id).append(name).append(users);

        return stringBuilder.toString();
    }
}
