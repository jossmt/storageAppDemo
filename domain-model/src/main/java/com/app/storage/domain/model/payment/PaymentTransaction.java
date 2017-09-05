package com.app.storage.domain.model.payment;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.listing.ItemListing;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.List;

/**
 * Payment transaction details.
 */
public class PaymentTransaction {

    /** User reference of buyer. */
    private String buyerUserRef;

    /** List of {@link ItemListing} by reference. */
    private List<String> itemListings;

    /** Payment type. */
    private String paymentNonce;

    /** Transaction amount. */
    private Double transactionAmount;

    /** Card information. */
    private PaymentInformation paymentInformation;

    /** Boolean to use paypal or card */
    private boolean usePaypal = true;

    /** Billing Address. */
    private Address address;


    /**
     * Gets Card information..
     *
     * @return Value of Card information..
     */
    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
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
     * @param paymentInformation
     *         New value of Card information..
     */
    public void setPaymentInformation(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }


    /**
     * Sets new Billing Address..
     *
     * @param address
     *         New value of Billing Address..
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets Billing Address..
     *
     * @return Value of Billing Address..
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets new itemListings.
     *
     * @param itemListings
     *         New value of itemListings.
     */
    public void setItemListings(List<String> itemListings) {
        this.itemListings = itemListings;
    }

    /**
     * Gets itemListings.
     *
     * @return Value of itemListings.
     */
    public List<String> getItemListings() {
        return itemListings;
    }

    /**
     * Gets User reference of buyer..
     *
     * @return Value of User reference of buyer..
     */
    public String getBuyerUserRef() {
        return buyerUserRef;
    }

    /**
     * Sets new User reference of buyer..
     *
     * @param buyerUserRef
     *         New value of User reference of buyer..
     */
    public void setBuyerUserRef(String buyerUserRef) {
        this.buyerUserRef = buyerUserRef;
    }


    /**
     * Gets Boolean to use paypal or card.
     *
     * @return Value of Boolean to use paypal or card.
     */
    public boolean isUsePaypal() {
        return usePaypal;
    }

    /**
     * Sets new Boolean to use paypal or card.
     *
     * @param usePaypal
     *         New value of Boolean to use paypal or card.
     */
    public void setUsePaypal(boolean usePaypal) {
        this.usePaypal = usePaypal;
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
                .append(getBuyerUserRef(), paymentTransaction.getBuyerUserRef())
                .append(getItemListings(), paymentTransaction.getItemListings())
                .append(getPaymentInformation(), paymentTransaction.getPaymentInformation())
                .append(getPaymentNonce(), paymentTransaction.getPaymentNonce())
                .append(getTransactionAmount(), paymentTransaction.getTransactionAmount())
                .append(getAddress(), paymentTransaction.getAddress())
                .append(isUsePaypal(), paymentTransaction.isUsePaypal())
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

        stringBuilder.append(buyerUserRef).append(itemListings).append(paymentInformation).append(address).append
                (paymentNonce).append(transactionAmount).append(isUsePaypal());

        return stringBuilder.toString();
    }
}
