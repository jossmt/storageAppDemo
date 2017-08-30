package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.payment.BillingAddressPersistenceModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface BillingAddressRepository extends CrudRepository<BillingAddressPersistenceModel, Long> {

    /**
     * Returns most recently added Billing Address.
     *
     * @return {@link BillingAddressPersistenceModel}
     */
    @Query(value = "SELECT * FROM BillingAddress ORDER BY idBillingAddress DESC LIMIT 1", nativeQuery = true)
    BillingAddressPersistenceModel findMostRecent();

}
