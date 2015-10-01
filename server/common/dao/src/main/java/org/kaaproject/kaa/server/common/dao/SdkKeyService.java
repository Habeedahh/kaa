/*
 * Copyright 2014-2015 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.server.common.dao;

import java.util.List;

import org.kaaproject.kaa.common.dto.admin.SdkPropertiesDto;

/**
 * The interface for SdkKey service.
 */
public interface SdkKeyService {

    /**
     * Save sdk properties. If sdk properties object has id, then sdk key
     * will be updated, otherwise if there is no other sdk key object
     * with the same token, it will be inserted as a new sdk key object,
     * if there is, nothing will be saved, existent object will be returned
     *
     * @param sdkPropertiesDto the sdk properties dto
     * @return the saved application dto object
     */
    SdkPropertiesDto saveSdkKey(SdkPropertiesDto sdkPropertiesDto);

    /**
     * Returns an SDK profile with the given identifier.
     *
     * @param id An SDK profile identifier
     *
     * @return An SDK profile with the given identifier
     */
    SdkPropertiesDto findSdkKeyById(String id);

    /**
     * Returns an SDK profile with the given token.
     *
     * @param token An SDK profile token
     *
     * @return An SDK profile with the given token
     */
    SdkPropertiesDto findSdkKeyByToken(String token);

    /**
     * Returns a list of SDK profiles for an application with the given identifier
     *
     * @param applicationId An application identifier
     * @return A list of SDK profiles for an application with the given identifier
     */
    List<SdkPropertiesDto> findSdkKeysByApplicationId(String applicationId);

    /**
     * Removes an SDK profile from the database by its identifier
     *
     * @param id The identifier of the SDK profile to remove
     */
    void removeSdkProfileById(String id);
}
