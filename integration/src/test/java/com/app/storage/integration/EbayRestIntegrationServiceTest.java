package com.app.storage.integration;

import com.app.storage.integration.Ebay.EbayRestIntegrationService;
import com.app.storage.integration.Ebay.EbayRestIntegrationServiceHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link EbayRestIntegrationService}
 */
public class EbayRestIntegrationServiceTest {

    /** Class under test. */
    private EbayRestIntegrationService ebayRestIntegrationService;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        ebayRestIntegrationService = new EbayRestIntegrationServiceHandler();
    }

    /**
     * Test ebay session id generation functionality.
     */
    @Test
    public void generateSessionIDTest() {

        //Test
        final String sessionID = ebayRestIntegrationService.generateNewSessionID();

        //Assert
        Assert.assertNotNull(sessionID);

    }
}
