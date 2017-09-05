package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.payment.PaymentInformationPersistenceModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface PaymentInformationRepository extends CrudRepository<PaymentInformationPersistenceModel, Long> {

    /**
     * Returns most recently added Card Information.
     *
     * @return {@link PaymentInformationPersistenceModel}
     */
    @Query(value = "SELECT * FROM PaymentInformation ORDER BY card_id DESC LIMIT 1", nativeQuery = true)
    PaymentInformationPersistenceModel findMostRecent();

}
