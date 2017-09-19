package com.app.storage.integration.Ebay;

import com.app.storage.domain.model.trade.TradingAccount;
import com.app.storage.integration.EncodeDecodeHandler;
import com.app.storage.integration.IntegrationConstants;
import com.app.storage.integration.model.Ebay.EbayRequestType;
import com.app.storage.integration.model.Ebay.Responses.FetchTokenResponseIntegrationModel;
import com.app.storage.integration.model.Ebay.Responses.GetSessionIDResponseIntegrationModel;
import com.app.storage.integration.model.Ebay.SubModels.General.Other.AckCodeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Implementation of {@link EbayAuthIntegrationService}
 */
@Service
public class EbayAuthIntegrationServiceHandler implements EbayAuthIntegrationService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(EbayAuthIntegrationService.class);

    /** {@link EbayRestIntegrationService}./ */
    private final EbayRestIntegrationService ebayRestIntegrationService;

    /**
     * Constructor.
     *
     * @param ebayRestIntegrationService
     *         {@link EbayRestIntegrationService}
     */
    @Autowired
    public EbayAuthIntegrationServiceHandler(final EbayRestIntegrationService ebayRestIntegrationService) {
        this.ebayRestIntegrationService = ebayRestIntegrationService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String authenticateNewUser() {

        final GetSessionIDResponseIntegrationModel sessionIDResponseModel = ebayRestIntegrationService
                .generateNewSessionID();

        String sessionID = null;
        if (sessionIDResponseModel.getAckCodeType().equals(AckCodeType.Success)) {

            sessionID = sessionIDResponseModel.getSessionID();
        } else {

            handleRequestErrorResponses(sessionIDResponseModel.getErrorList(), EbayRequestType.GET_SESSION_ID);
        }

        final String encodedSessionID = EncodeDecodeHandler.encodeString(sessionID);

        final String redirectURL = String.format(IntegrationConstants.EBAY_SANDBOX_LOGIN_URL, encodedSessionID);

        LOG.debug("Successfully built redirect url: {}", redirectURL);

        return redirectURL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUserAuthToken(final String sessionIdEncoded) {

        LOG.debug("Updating user authorisation token.");

        final String sessionIdDecoded = EncodeDecodeHandler.decodeString(sessionIdEncoded);

        final FetchTokenResponseIntegrationModel fetchTokenResponseIntegrationModel = ebayRestIntegrationService
                .fetchUserToken(sessionIdEncoded);
    }

    /**
     * Handles error responses.
     *
     * @param errors
     *         list of {@link Error}
     * @param requestType
     *         {@link EbayRequestType}
     */
    private void handleRequestErrorResponses(final List<Error> errors, final EbayRequestType requestType) {


    }
}
