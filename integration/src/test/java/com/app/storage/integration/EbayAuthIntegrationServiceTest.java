package com.app.storage.integration;

import com.app.storage.integration.Ebay.EbayAuthIntegrationService;
import com.app.storage.integration.Ebay.EbayAuthIntegrationServiceHandler;
import com.app.storage.integration.Ebay.EbayRestIntegrationService;
import com.app.storage.integration.model.Ebay.Responses.GetSessionIDResponseIntegrationModel;
import com.app.storage.integration.model.Ebay.SubModels.General.Other.AckCodeType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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


    /**
     * Validates new authentication through session id retrievel and redirect url generation.
     */
    @Test
    public void validateAuthenticateNewUser() {

        //Setup
        final GetSessionIDResponseIntegrationModel sessionIDResponse = new GetSessionIDResponseIntegrationModel();
        sessionIDResponse.setSessionID("testid");
        sessionIDResponse.setAckCodeType(AckCodeType.Success);

        final String encodedSessionId = EncodeDecodeHandler.encodeString("testid");

        final String urlResponse = "https://signin.sandbox.ebay.com/ws/eBayISAPI" +
                ".dll?SignIn&RuName=Joss_Miller-Tod-JossMill-Numori-vjplv&SessID=dGVzdGlk";

        //Mock
        Mockito.when(ebayRestIntegrationService.generateNewSessionID()).thenReturn(sessionIDResponse);

        //Test
        final String response = ebayAuthIntegrationService.authenticateNewUser();

        //Validate
        Mockito.verify(ebayRestIntegrationService).generateNewSessionID();

        //Assert
        System.out.println(urlResponse);
        Assert.assertEquals(urlResponse, response);
    }
}
