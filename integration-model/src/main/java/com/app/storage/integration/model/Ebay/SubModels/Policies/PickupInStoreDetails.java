package com.app.storage.integration.model.Ebay.SubModels.Policies;

/**
 * Pick up in store details.
 * <p>
 * NB: requires the following:
 * <p>
 * Have inventory for the product at one or more physical stores tied to the merchant's account.
 * Set an immediate payment requirement on the item. The immediate payment feature requires the seller to:
 * Include the Item.AutoPay flag in the call request and set its value to true;
 * Include only one Item.PaymentMethods field in the call request and set its value to PayPal;
 * Include a valid PayPal payment address in the Item.PayPalEmailAddress field.
 */
public class PickupInStoreDetails {

    /** Eligible for pickup dropoff boolean. */
    private boolean eligibleForPickupDropOff;

    /** Eligible for pick up in store boolean. */
    private boolean eligibleForPickupInStore;


    /**
     * Gets Eligible for pickup dropoff boolean..
     *
     * @return Value of Eligible for pickup dropoff boolean..
     */
    public boolean isEligibleForPickupDropOff() {
        return eligibleForPickupDropOff;
    }

    /**
     * Sets new Eligible for pick up in store boolean..
     *
     * @param eligibleForPickupInStore
     *         New value of Eligible for pick up in store boolean..
     */
    public void setEligibleForPickupInStore(boolean eligibleForPickupInStore) {
        this.eligibleForPickupInStore = eligibleForPickupInStore;
    }

    /**
     * Sets new Eligible for pickup dropoff boolean..
     *
     * @param eligibleForPickupDropOff
     *         New value of Eligible for pickup dropoff boolean..
     */
    public void setEligibleForPickupDropOff(boolean eligibleForPickupDropOff) {
        this.eligibleForPickupDropOff = eligibleForPickupDropOff;
    }

    /**
     * Gets Eligible for pick up in store boolean..
     *
     * @return Value of Eligible for pick up in store boolean..
     */
    public boolean isEligibleForPickupInStore() {
        return eligibleForPickupInStore;
    }
}
