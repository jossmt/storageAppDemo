package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.payment.CardInformationPersistenceModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface CardInformationRepository extends CrudRepository<CardInformationPersistenceModel, Long> {

    /**
     * Returns most recently added Card Information.
     *
     * @return {@link CardInformationPersistenceModel}
     */
    @Query(value = "SELECT * FROM CardInformation ORDER BY card_id DESC LIMIT 1", nativeQuery = true)
    CardInformationPersistenceModel findMostRecent();

}
