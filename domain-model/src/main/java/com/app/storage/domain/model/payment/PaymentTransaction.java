package com.app.storage.domain.model.payment;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Payment transaction details.
 */
public class PaymentTransaction {

    /** Customer reference. */
    private String customerRef;

    /** Payment type. */
    private String paymentNonce;

    /** Transaction amount. */
    private Double transactionAmount;

    /** Card information. */
    private CardInformation cardInformation;

    /** Billing Address. */
    private BillingAddress billingAddress;

    /**
     * Gets Card information..
     *
     * @return Value of Card information..
     */
    public CardInformation getCardInformation() {
        return cardInformation;
    }

    /**
     * Gets Transaction amount..
     *
     * @return Value of Transaction amount..
     */
    public Double getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Gets Payment type..
     *
     * @return Value of Payment type..
     */
    public String getPaymentNonce() {
        return paymentNonce;
    }

    /**
     * Sets new Payment type..
     *
     * @param paymentNonce
     *         New value of Payment type..
     */
    public void setPaymentNonce(String paymentNonce) {
        this.paymentNonce = paymentNonce;
    }

    /**
     * Sets new Transaction amount..
     *
     * @param transactionAmount
     *         New value of Transaction amount..
     */
    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * Sets new Card information..
     *
     * @param cardInformation
     *         New value of Card information..
     */
    public void setCardInformation(CardInformation cardInformation) {
        this.cardInformation = cardInformation;
    }


    /**
     * Sets new Billing Address..
     *
     * @param billingAddress
     *         New value of Billing Address..
     */
    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Gets Billing Address..
     *
     * @return Value of Billing Address..
     */
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    /**
     * Gets Customer reference..
     *
     * @return Value of Customer reference..
     */
    public String getCustomerRef() {
        return customerRef;
    }

    /**
     * Sets new Customer reference..
     *
     * @param customerRef
     *         New value of Customer reference..
     */
    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
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
        if (!(obj instanceof PaymentTransaction))
            return false;
        if (obj == this)
            return true;

        PaymentTransaction paymentTransaction = (PaymentTransaction) obj;
        return new EqualsBuilder()
                .append(getCustomerRef(), paymentTransaction.getCustomerRef())
                .append(getCardInformation(), paymentTransaction.getCardInformation())
                .append(getPaymentNonce(), paymentTransaction.getPaymentNonce())
                .append(getTransactionAmount(), paymentTransaction.getTransactionAmount())
                .append(getBillingAddress(), paymentTransaction.getBillingAddress())
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

        stringBuilder.append(customerRef).append(cardInformation).append(billingAddress).append(paymentNonce)
                .append(transactionAmount);

        return stringBuilder.toString();
    }
}
