package com.app.storage.persistence.model.trade;

import com.app.storage.persistence.model.ItemListingPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.apache.commons.lang.builder.EqualsBuilder;

import javax.persistence.*;
import java.util.List;

/**
 * Trading Account persistence model
 */
@Entity
@Table(name = "TradingAccount")
public class TradingAccountPersistenceModel {

    /** Unique db id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTradingAccount")
    private Long id;

    /** Trading account type. */
    @Column(name = "AccountType")
    private String accountType;

    /** Account name. */
    @Column(name = "AccountName")
    private String accountName;

    /** Account password. */
    @Column(name = "AccountPassword")
    private String accountPassword;

    @Column(name = "AuthorisationToken")
    private String authToken;

    /** User role privileges. */
    @JoinTable(name = "TradingAccount_ItemListing", joinColumns = @JoinColumn(name = "trading_id"),
            inverseJoinColumns = @JoinColumn(name = "storage_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private List<ItemListingPersistenceModel> itemListingPersistenceModels;

    /** Owner foreign key reference. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private UserPersistenceModel userPersistenceModel;

    /**
     * Gets Account name..
     *
     * @return Value of Account name..
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets new Trading account type..
     *
     * @param accountType
     *         New value of Trading account type..
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
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
     * Sets new Account password..
     *
     * @param accountPassword
     *         New value of Account password..
     */
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    /**
     * Gets Trading account type..
     *
     * @return Value of Trading account type..
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Gets Unique db id..
     *
     * @return Value of Unique db id..
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets Account password..
     *
     * @return Value of Account password..
     */
    public String getAccountPassword() {
        return accountPassword;
    }

    /**
     * Sets new Unique db id..
     *
     * @param id
     *         New value of Unique db id..
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets User role privileges..
     *
     * @return Value of User role privileges..
     */
    public List<ItemListingPersistenceModel> getItemListingPersistenceModels() {
        return itemListingPersistenceModels;
    }

    /**
     * Sets new User role privileges..
     *
     * @param itemListingPersistenceModels
     *         New value of User role privileges..
     */
    public void setItemListingPersistenceModels(List<ItemListingPersistenceModel> itemListingPersistenceModels) {
        this.itemListingPersistenceModels = itemListingPersistenceModels;
    }

    /**
     * Gets Owner foreign key reference..
     *
     * @return Value of Owner foreign key reference..
     */
    public UserPersistenceModel getUserPersistenceModel() {
        return userPersistenceModel;
    }

    /**
     * Sets new Owner foreign key reference..
     *
     * @param userPersistenceModel
     *         New value of Owner foreign key reference..
     */
    public void setUserPersistenceModel(UserPersistenceModel userPersistenceModel) {
        this.userPersistenceModel = userPersistenceModel;
    }

    /**
     * Sets new authToken.
     *
     * @param authToken
     *         New value of authToken.
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * Gets authToken.
     *
     * @return Value of authToken.
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof TradingAccountPersistenceModel))
            return false;
        if (obj == this)
            return true;

        TradingAccountPersistenceModel tradingAccountPersistenceModel = (TradingAccountPersistenceModel) obj;
        return new EqualsBuilder()
                .append(getAccountName(), tradingAccountPersistenceModel.getAccountName())
                .append(getAccountType(), tradingAccountPersistenceModel.getAccountType())
                .append(getAccountPassword(), tradingAccountPersistenceModel.getAccountPassword())
                .append(getAuthToken(), tradingAccountPersistenceModel.getAuthToken())
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(accountName).append(accountPassword).append(accountType).append(authToken);

        return stringBuilder.toString();
    }
}
