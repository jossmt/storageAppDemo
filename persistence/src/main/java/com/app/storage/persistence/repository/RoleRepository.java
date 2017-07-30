/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.RolePersistenceModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Role repository.
 */
@Repository
@Component
public interface RoleRepository extends CrudRepository<RolePersistenceModel, Long> {

    /**
     * Looks up most recently added Role
     *
     * @return {@link RolePersistenceModel}
     */
    @Query(value = "SELECT * FROM Role ORDER BY role_id DESC LIMIT 1", nativeQuery = true)
    RolePersistenceModel findMostRecent();

    /**
     * Finds all Roles as list.
     *
     * @return {@link RolePersistenceModel}
     */
    @Query(value = "SELECT * FROM Role", nativeQuery = true)
    List<RolePersistenceModel> findAllAsList();

}
