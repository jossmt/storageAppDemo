package com.app.storage.persistence.mapper.payment;

import com.app.storage.domain.model.payment.CardInformation;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.model.payment.CardInformationPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link CardInformationPersistenceMapper}
 */
@Component
public class CardInformationPersistenceMapperHandler implements CardInformationPersistenceMapper,
        AbstractMapper<CardInformationPersistenceModel, CardInformation> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(CardInformationPersistenceMapper.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public CardInformationPersistenceModel mapTo(final CardInformation cardInformation) {

        LOG.debug("Mapping from domain model: {} to persistence model", cardInformation);

        CardInformationPersistenceModel cardInformationPersistenceModel = null;
        if (cardInformation != null) {
            cardInformationPersistenceModel = new CardInformationPersistenceModel();
            cardInformationPersistenceModel.setCardHolderName(cardInformation.getCardHolderName());
            cardInformationPersistenceModel.setCardNumber(cardInformation.getCardNumber());
            cardInformationPersistenceModel.setCvv(cardInformation.getCvvValue());
            cardInformationPersistenceModel.setExpirationMonth(cardInformation.getExpirationMonth());
            cardInformationPersistenceModel.setExpirationYear(cardInformation.getExpirationYear());
        }

        LOG.debug("Successfully mapped to persistence model: {}", cardInformationPersistenceModel);

        return cardInformationPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardInformation mapFrom(final CardInformationPersistenceModel cardInformationPersistenceModel) {

        LOG.debug("Mapping from persistence model: {} to domain model", cardInformationPersistenceModel);

        CardInformation cardInformation = null;
        if (cardInformationPersistenceModel != null) {

            cardInformation = new CardInformation();
            cardInformation.setCardHolderName(cardInformationPersistenceModel.getCardHolderName());
            cardInformation.setCvvValue(cardInformationPersistenceModel.getCvv());
            cardInformation.setCardNumber(cardInformationPersistenceModel.getCardNumber());
            cardInformation.setExpirationMonth(cardInformationPersistenceModel.getExpirationMonth());
            cardInformation.setExpirationYear(cardInformationPersistenceModel.getExpirationYear());
        }

        LOG.debug("Successfully mapped to domain model: {}", cardInformation);

        return cardInformation;
    }
}
