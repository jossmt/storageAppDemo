package com.app.storage.persistence.model.payment;

import com.app.storage.persistence.model.UserPersistenceModel;
import org.apache.commons.lang.builder.EqualsBuilder;

import javax.persistence.*;

/**
 * Card payment information persistence model.
 */
@Entity
@Table(name = "CardInformation")
public class CardInformationPersistenceModel {

    /** Unique db id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private Long id;

    /** Card Holder Full Name. */
    private String cardHolderName;

    /** Card Number. */
    private Long cardNumber;

    /** Cvv. */
    private Integer cvv;

    /** Expiration Month. */
    private Integer expirationMonth;

    /** Expiration year. */
    private Integer expirationYear;

    /**
     * Many-1 reference to owner model.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserPersistenceModel userPersistenceModel;

    /**
     * Gets Card Holder Full Name..
     *
     * @return Value of Card Holder Full Name..
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Sets new Card Holder Full Name..
     *
     * @param cardHolderName
     *         New value of Card Holder Full Name..
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    /**
     * Gets Card Number..
     *
     * @return Value of Card Number..
     */
    public Long getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets new Card Number..
     *
     * @param cardNumber
     *         New value of Card Number..
     */
    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets Cvv..
     *
     * @return Value of Cvv..
     */
    public Integer getCvv() {
        return cvv;
    }

    /**
     * Sets new Cvv..
     *
     * @param cvv
     *         New value of Cvv..
     */
    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    /**
     * Sets new Expiration Month..
     *
     * @param expirationMonth
     *         New value of Expiration Month..
     */
    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    /**
     * Gets Expiration Month..
     *
     * @return Value of Expiration Month..
     */
    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    /**
     * Gets Expiration year..
     *
     * @return Value of Expiration year..
     */
    public Integer getExpirationYear() {
        return expirationYear;
    }

    /**
     * Sets new Expiration year..
     *
     * @param expirationYear
     *         New value of Expiration year..
     */
    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    /**
     * Gets Many-1 reference to owner model..
     *
     * @return Value of Many-1 reference to owner model..
     */
    public UserPersistenceModel getUserPersistenceModel() {
        return userPersistenceModel;
    }

    /**
     * Sets new Many-1 reference to owner model..
     *
     * @param userPersistenceModel
     *         New value of Many-1 reference to owner model..
     */
    public void setUserPersistenceModel(UserPersistenceModel userPersistenceModel) {
        this.userPersistenceModel = userPersistenceModel;
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
     * Sets new Unique db id..
     *
     * @param id
     *         New value of Unique db id..
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof CardInformationPersistenceModel))
            return false;
        if (obj == this)
            return true;

        CardInformationPersistenceModel cardInformationPersistenceModel = (CardInformationPersistenceModel) obj;
        return new EqualsBuilder()
                .append(getCardHolderName(), cardInformationPersistenceModel.getCardHolderName())
                .append(getCardNumber(), cardInformationPersistenceModel.getCardNumber())
                .append(getCvv(), cardInformationPersistenceModel.getCvv())
                .append(getExpirationMonth(), cardInformationPersistenceModel.getExpirationMonth())
                .append(getExpirationYear(), cardInformationPersistenceModel.getExpirationYear())
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(cardHolderName).append(cardNumber).append(cvv).append(expirationMonth)
                .append(expirationYear);

        return stringBuilder.toString();
    }
}
