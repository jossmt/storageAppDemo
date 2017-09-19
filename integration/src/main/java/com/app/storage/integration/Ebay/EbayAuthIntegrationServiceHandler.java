package com.app.storage.integration.Ebay;

import com.app.storage.domain.model.trade.TradingAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of {@link EbayAuthIntegrationService}
 */
@Service
public class EbayAuthIntegrationServiceHandler implements EbayAuthIntegrationService {

    /** Spring rest template. */
    private RestTemplate restTemplate = new RestTemplate();

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
    public void authenticateNewUser() {

        final String sessionID = ebayRestIntegrationService.generateNewSessionID();

    }
}
