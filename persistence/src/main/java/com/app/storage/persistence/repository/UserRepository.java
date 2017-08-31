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

import com.app.storage.persistence.model.UserPersistenceModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User repository.
 */
@Repository
@Component
@Transactional
public interface UserRepository extends CrudRepository<UserPersistenceModel, Long> {

    /**
     * Finds user by email.
     *
     * @param email
     *         Unique email identification.
     * @return {@link UserPersistenceModel}
     */
    @Query(value = "SELECT * FROM User WHERE User.email = :email", nativeQuery = true)
    @Transactional
    UserPersistenceModel findByEmail(@Param("email") String email);

    /**
     * Returns most recently added User.
     *
     * @return {@link UserPersistenceModel}
     */
    @Query(value = "SELECT * FROM User ORDER BY User.user_id DESC LIMIT 1", nativeQuery = true)
    UserPersistenceModel findMostRecent();

    /**
     * Returns all Users as list.
     *
     * @return list of {@link UserPersistenceModel}
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT * FROM User", nativeQuery = true)
    List<UserPersistenceModel> findAllAsList();
}
