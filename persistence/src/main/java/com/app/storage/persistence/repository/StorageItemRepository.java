package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.StorageItemPersistenceModel;
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
public interface StorageItemRepository extends CrudRepository<StorageItemPersistenceModel, Long> {

    @Query(value = "SELECT * FROM StorageItem ORDER BY id DESC LIMIT 1", nativeQuery = true)
    StorageItemPersistenceModel findMostRecent();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT * FROM StorageItem", nativeQuery = true)
    List<StorageItemPersistenceModel> findAllAsList();

    @Query(value = "SELECT * FROM StorageItem WHERE StorageItem.reference = :reference LIMIT 1", nativeQuery = true)
    StorageItemPersistenceModel findByReference(@Param("reference") final String reference);
}
