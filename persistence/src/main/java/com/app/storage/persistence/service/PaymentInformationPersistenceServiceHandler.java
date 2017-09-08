package com.app.storage.persistence.service;

import com.app.storage.domain.model.payment.PaymentInformation;
import com.app.storage.persistence.mapper.payment.PaymentInformationPersistenceMapper;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.payment.PaymentInformationPersistenceModel;
import com.app.storage.persistence.repository.PaymentInformationRepository;
import com.app.storage.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link PaymentInformationPersistenceService}
 */
@Service
public class PaymentInformationPersistenceServiceHandler implements PaymentInformationPersistenceService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PaymentInformationPersistenceService.class);

    /** {@link PaymentInformationPersistenceMapper}. */
    private final PaymentInformationPersistenceMapper paymentInformationPersistenceMapper;

    /** {@link UserRepository}. */
    private final UserRepository userRepository;

    /** {@link PaymentInformationRepository}. */
    private final PaymentInformationRepository paymentInformationRepository;

    /**
     * Constructor
     */
    @Autowired
    public PaymentInformationPersistenceServiceHandler(final PaymentInformationPersistenceMapper
                                                               paymentInformationPersistenceMapper,
                                                       final UserRepository userRepository,
                                                       final PaymentInformationRepository
                                                               paymentInformationRepository) {

        this.paymentInformationPersistenceMapper = paymentInformationPersistenceMapper;
        this.userRepository = userRepository;
        this.paymentInformationRepository = paymentInformationRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void updateUserPaymentInformation(final String userEmail, final PaymentInformation paymentInformation) {

        LOG.debug("Updating users paypal details");

        final PaymentInformationPersistenceModel paymentInformationPersistenceModel =
                paymentInformationPersistenceMapper.mapTo(paymentInformation);

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(userEmail);

        //Updates either paypal info or card info depending on whats been populated
        PaymentInformationPersistenceModel paymentInformationPersistenceModelSaved = null;
        if (paymentInformationPersistenceModel.getPaypalUsername() != null) {

            if (userPersistenceModel.getPaymentInformationPersistenceModel() != null) {

                userPersistenceModel.getPaymentInformationPersistenceModel().setPaypalUsername
                        (paymentInformationPersistenceModel.getPaypalUsername());
            } else {
                paymentInformationPersistenceModelSaved =
                        paymentInformationRepository.save(paymentInformationPersistenceModel);
            }

        } else {

            final PaymentInformationPersistenceModel currentPaymentModel = userPersistenceModel
                    .getPaymentInformationPersistenceModel();
            if (currentPaymentModel != null) {

                currentPaymentModel.setCardHolderName(paymentInformationPersistenceModel.getCardHolderName());
                currentPaymentModel.setCardNumber(paymentInformationPersistenceModel.getCardNumber());
                currentPaymentModel.setCvv(paymentInformationPersistenceModel.getCvv());
                currentPaymentModel.setExpirationMonth(paymentInformationPersistenceModel.getExpirationMonth());
                currentPaymentModel.setExpirationYear(paymentInformationPersistenceModel.getExpirationYear());

            } else {

                paymentInformationPersistenceModelSaved = paymentInformationRepository.save
                        (paymentInformationPersistenceModel);
            }
        }

        if (paymentInformationPersistenceModelSaved != null) {
            paymentInformationPersistenceModelSaved.setUserPersistenceModel(userPersistenceModel);
            userPersistenceModel.setPaymentInformationPersistenceModel(paymentInformationPersistenceModelSaved);
        }


        LOG.debug("Successfully updated users paypal details");
    }

}
