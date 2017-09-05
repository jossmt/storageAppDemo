package com.app.storage.domain.model.payment;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Card information holder.
 */
public class PaymentInformation {

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

    /** Paypal user name. */
    private String paypalUsername;

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
     * Sets new Paypal user name..
     *
     * @param paypalUsername
     *         New value of Paypal user name..
     */
    public void setPaypalUsername(String paypalUsername) {
        this.paypalUsername = paypalUsername;
    }

    /**
     * Gets Paypal user name..
     *
     * @return Value of Paypal user name..
     */
    public String getPaypalUsername() {
        return paypalUsername;
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
        if (!(obj instanceof PaymentInformation))
            return false;
        if (obj == this)
            return true;

        PaymentInformation paymentInformation = (PaymentInformation) obj;
        return new EqualsBuilder()
                .append(getCardHolderName(), paymentInformation.getCardHolderName())
                .append(getCvvValue(), paymentInformation.getCvvValue())
                .append(getExpirationYear(), paymentInformation.getExpirationYear())
                .append(getExpirationMonth(), paymentInformation.getExpirationMonth())
                .append(getCardNumber(), paymentInformation.getCardNumber())
                .append(getPaypalUsername(), paymentInformation.getPaypalUsername())
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
                .append(expirationMonth).append(paypalUsername);

        return stringBuilder.toString();
    }
}
