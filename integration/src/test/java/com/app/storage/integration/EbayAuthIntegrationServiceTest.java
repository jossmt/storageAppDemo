package com.app.storage.integration;

import com.app.storage.integration.Ebay.EbayAuthIntegrationService;
import com.app.storage.integration.Ebay.EbayAuthIntegrationServiceHandler;
import com.app.storage.integration.Ebay.EbayRestIntegrationService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Tests for {@link EbayAuthIntegrationService}
 */
@RunWith(MockitoJUnitRunner.class)
public class EbayAuthIntegrationServiceTest {

    /** Mock service. */
    @Mock
    private EbayRestIntegrationService ebayRestIntegrationService;

    /** Class under test. */
    private EbayAuthIntegrationService ebayAuthIntegrationService;

    /**
     * Setup test class.
     */
    @Before
    public void setUp() {
        ebayAuthIntegrationService = new EbayAuthIntegrationServiceHandler(ebayRestIntegrationService);
    }
}
