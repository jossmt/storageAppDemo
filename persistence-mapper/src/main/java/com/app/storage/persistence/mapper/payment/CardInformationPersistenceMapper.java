package com.app.storage.persistence.mapper.payment;

import com.app.storage.domain.model.payment.CardInformation;
import com.app.storage.persistence.model.payment.CardInformationPersistenceModel;

/**
 * Card information persistence mapper.
 */
public interface CardInformationPersistenceMapper {

    /**
     * Maps from {@link CardInformation} to {@link CardInformationPersistenceModel}
     *
     * @param cardInformation
     *         {@link CardInformation}
     * @return {@link CardInformationPersistenceModel}
     */
    CardInformationPersistenceModel mapTo(CardInformation cardInformation);

    /**
     * Maps from {@link CardInformationPersistenceModel} to {@link CardInformation}
     *
     * @param cardInformationPersistenceModel
     *         {@link CardInformationPersistenceModel}
     * @return {@link CardInformation}
     */
    CardInformation mapFrom(CardInformationPersistenceModel cardInformationPersistenceModel);
}
