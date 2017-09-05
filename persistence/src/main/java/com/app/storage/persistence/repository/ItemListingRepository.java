package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.ItemListingPersistenceModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Storage item repository.
 */
@Repository
@Component
public interface ItemListingRepository extends CrudRepository<ItemListingPersistenceModel, Long> {

    @Query(value = "SELECT * FROM ItemListing ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ItemListingPersistenceModel findMostRecent();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT * FROM ItemListing", nativeQuery = true)
    List<ItemListingPersistenceModel> findAllAsList();

    @Query(value = "SELECT * FROM ItemListing WHERE ItemListing.reference = :reference LIMIT 1", nativeQuery = true)
    ItemListingPersistenceModel findByReference(@Param("reference") final String reference);
}
