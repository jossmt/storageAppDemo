package com.app.storage.persistence.mapper.payment;

import com.app.storage.domain.model.payment.PaymentInformation;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.model.payment.PaymentInformationPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link PaymentInformationPersistenceMapper}
 */
@Component
public class PaymentInformationPersistenceMapperHandler implements PaymentInformationPersistenceMapper,
        AbstractMapper<PaymentInformationPersistenceModel, PaymentInformation> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PaymentInformationPersistenceMapper.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public PaymentInformationPersistenceModel mapTo(final PaymentInformation paymentInformation) {

        LOG.debug("Mapping from domain model: {} to persistence model", paymentInformation);

        PaymentInformationPersistenceModel paymentInformationPersistenceModel = null;
        if (paymentInformation != null) {
            paymentInformationPersistenceModel = new PaymentInformationPersistenceModel();
            paymentInformationPersistenceModel.setCardHolderName(paymentInformation.getCardHolderName());
            paymentInformationPersistenceModel.setCardNumber(paymentInformation.getCardNumber());
            paymentInformationPersistenceModel.setCvv(paymentInformation.getCvvValue());
            paymentInformationPersistenceModel.setExpirationMonth(paymentInformation.getExpirationMonth());
            paymentInformationPersistenceModel.setExpirationYear(paymentInformation.getExpirationYear());
            paymentInformationPersistenceModel.setPaypalUsername(paymentInformation.getPaypalUsername());
        }

        LOG.debug("Successfully mapped to persistence model: {}", paymentInformationPersistenceModel);

        return paymentInformationPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaymentInformation mapFrom(final PaymentInformationPersistenceModel paymentInformationPersistenceModel) {

        LOG.debug("Mapping from persistence model: {} to domain model", paymentInformationPersistenceModel);

        PaymentInformation paymentInformation = null;
        if (paymentInformationPersistenceModel != null) {

            paymentInformation = new PaymentInformation();
            paymentInformation.setCardHolderName(paymentInformationPersistenceModel.getCardHolderName());
            paymentInformation.setCvvValue(paymentInformationPersistenceModel.getCvv());
            paymentInformation.setCardNumber(paymentInformationPersistenceModel.getCardNumber());
            paymentInformation.setExpirationMonth(paymentInformationPersistenceModel.getExpirationMonth());
            paymentInformation.setExpirationYear(paymentInformationPersistenceModel.getExpirationYear());
            paymentInformation.setPaypalUsername(paymentInformationPersistenceModel.getPaypalUsername());
        }

        LOG.debug("Successfully mapped to domain model: {}", paymentInformation);

        return paymentInformation;
    }
}
