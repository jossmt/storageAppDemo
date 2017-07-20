package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.StorageItemPersistenceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Storage item repository.
 */
@Repository
@Component
public interface StorageItemRepository extends CrudRepository<StorageItemPersistenceModel, Long> {
}
