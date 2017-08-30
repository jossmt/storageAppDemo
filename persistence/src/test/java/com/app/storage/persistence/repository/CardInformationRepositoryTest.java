package com.app.storage.persistence.repository;

import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.payment.CardInformationPersistenceModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test for {@link CardInformationRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:JDBCConfig.xml"})
public class CardInformationRepositoryTest {

    /** {@link CardInformationRepository}. */
    @Autowired
    private CardInformationRepository cardInformationRepository;

    /** {@link UserRepository}. */
    @Autowired
    private UserRepository userRepository;

    /**
     * Test basic save function.
     */
    @Test
    public void testSave() {

        //Setup
        final UserPersistenceModel userPersistenceModel = userRepository.findMostRecent();

        final CardInformationPersistenceModel cardInformationPersistenceModel = new CardInformationPersistenceModel();
        cardInformationPersistenceModel.setCardNumber(99944449994L);
        cardInformationPersistenceModel.setCardHolderName("Card Holder Name");
        cardInformationPersistenceModel.setExpirationMonth(02);
        cardInformationPersistenceModel.setExpirationYear(2019);
        cardInformationPersistenceModel.setCvv(123);
        cardInformationPersistenceModel.setUserPersistenceModel(userPersistenceModel);

        //Test
        final CardInformationPersistenceModel cardInformationPersistenceModelSaved = cardInformationRepository.save
                (cardInformationPersistenceModel);

        final CardInformationPersistenceModel cardInformationPersistenceModelUpdated = cardInformationRepository
                .findMostRecent();

        //Assert
        Assert.assertEquals(cardInformationPersistenceModelSaved, cardInformationPersistenceModelUpdated);

        //Clear
        cardInformationRepository.delete(cardInformationPersistenceModelUpdated.getId());
    }
}
