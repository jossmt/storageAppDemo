package com.app.storage.domain.model.payment;

import com.app.storage.domain.model.User;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Card information holder.
 */
public class CardInformation {

    /** Full credit/debit card number. */
    private Long cardNumber;

    /** 3-digit value on back of card **/
    private Integer cvvValue;

    /** Expiration month of card. */
    private Integer expirationMonth;

    /** Expiration year of card. */
    private Integer expirationYear;

    /** Card holder name. */
    private String cardHolderName;

    /**
     * Gets cardNumber.
     *
     * @return Value of cardNumber.
     */
    public Long getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets new cvvValue.
     *
     * @param cvvValue
     *         New value of cvvValue.
     */
    public void setCvvValue(Integer cvvValue) {
        this.cvvValue = cvvValue;
    }

    /**
     * Sets new cardNumber.
     *
     * @param cardNumber
     *         New value of cardNumber.
     */
    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets cardHolderName.
     *
     * @return Value of cardHolderName.
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Sets new cardHolderName.
     *
     * @param cardHolderName
     *         New value of cardHolderName.
     */
    public void setCardHolderName(final String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    /**
     * Gets expirationYear.
     *
     * @return Value of expirationYear.
     */
    public Integer getExpirationYear() {
        return expirationYear;
    }

    /**
     * Gets cvvValue.
     *
     * @return Value of cvvValue.
     */
    public Integer getCvvValue() {
        return cvvValue;
    }

    /**
     * Sets new expirationYear.
     *
     * @param expirationYear
     *         New value of expirationYear.
     */
    public void setExpirationYear(final Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    /**
     * Gets Expiration month of card..
     *
     * @return Value of Expiration month of card..
     */
    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    /**
     * Sets new Expiration month of card..
     *
     * @param expirationMonth
     *         New value of Expiration month of card..
     */
    public void setExpirationMonth(final Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
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
        if (!(obj instanceof CardInformation))
            return false;
        if (obj == this)
            return true;

        CardInformation cardInformation = (CardInformation) obj;
        return new EqualsBuilder()
                .append(getCardHolderName(), cardInformation.getCardHolderName())
                .append(getCvvValue(), cardInformation.getCvvValue())
                .append(getExpirationYear(), cardInformation.getExpirationYear())
                .append(getExpirationMonth(), cardInformation.getExpirationMonth())
                .append(getCardNumber(), cardInformation.getCardNumber())
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

        stringBuilder.append(cardHolderName).append(cardNumber).append(cvvValue).append(expirationYear)
                .append(expirationMonth);

        return stringBuilder.toString();
    }
}
