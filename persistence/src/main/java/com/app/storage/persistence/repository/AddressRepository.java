package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.payment.AddressPersistenceModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AddressRepository extends CrudRepository<AddressPersistenceModel, Long> {

    /**
     * Returns most recently added Billing Address.
     *
     * @return {@link AddressPersistenceModel}
     */
    @Query(value = "SELECT * FROM Address ORDER BY idAddress DESC LIMIT 1", nativeQuery = true)
    AddressPersistenceModel findMostRecent();

}
