package com.app.storage.persistence.mapper.payment;

import com.app.storage.domain.model.payment.CardInformation;
import com.app.storage.persistence.model.payment.CardInformationPersistenceModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link CardInformationPersistenceMapper}
 */
public class CardInformationPersistenceMapperTest {

    /** {@link CardInformationPersistenceMapper}. */
    private CardInformationPersistenceMapper cardInformationPersistenceMapper;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        cardInformationPersistenceMapper = new CardInformationPersistenceMapperHandler();
    }

    /**
     * Check full map to persistence model test.
     */
    @Test
    public void checkFullMapTo() {

        //Setup
        final CardInformation cardInformation = new CardInformation();
        cardInformation.setExpirationYear(2019);
        cardInformation.setExpirationMonth(02);
        cardInformation.setCardNumber(4762300018009393L);
        cardInformation.setCvvValue(133);
        cardInformation.setCardHolderName("Card Holder Name");

        final CardInformationPersistenceModel cardInformationPersistenceModel = new CardInformationPersistenceModel();
        cardInformationPersistenceModel.setExpirationYear(2019);
        cardInformationPersistenceModel.setExpirationMonth(02);
        cardInformationPersistenceModel.setCardNumber(4762300018009393L);
        cardInformationPersistenceModel.setCvv(133);
        cardInformationPersistenceModel.setCardHolderName("Card Holder Name");

        //Test
        final CardInformationPersistenceModel cardInformationPersistenceModelActual = cardInformationPersistenceMapper
                .mapTo(cardInformation);

        //Assert
        Assert.assertEquals(cardInformationPersistenceModelActual, cardInformationPersistenceModel);

    }

    /**
     * Check full map from persistence model test.
     */
    @Test
    public void checkFullMapFrom() {

        //Setup
        final CardInformation cardInformation = new CardInformation();
        cardInformation.setExpirationYear(2019);
        cardInformation.setExpirationMonth(02);
        cardInformation.setCardNumber(4762300018009393L);
        cardInformation.setCvvValue(133);
        cardInformation.setCardHolderName("Card Holder Name");

        final CardInformationPersistenceModel cardInformationPersistenceModel = new CardInformationPersistenceModel();
        cardInformationPersistenceModel.setExpirationYear(2019);
        cardInformationPersistenceModel.setExpirationMonth(02);
        cardInformationPersistenceModel.setCardNumber(4762300018009393L);
        cardInformationPersistenceModel.setCvv(133);
        cardInformationPersistenceModel.setCardHolderName("Card Holder Name");

        //Test
        final CardInformation cardInformationActual = cardInformationPersistenceMapper.mapFrom
                (cardInformationPersistenceModel);

        //Assert
        Assert.assertEquals(cardInformation, cardInformationActual);
    }
}
