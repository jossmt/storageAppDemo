package com.app.storage.integration.Ebay;

import com.app.storage.integration.Ebay.config.ClientSetup;
import com.app.storage.integration.Ebay.config.EbayAPIRequestHeadersBuilder;
import com.app.storage.integration.IntegrationConstants;
import com.app.storage.integration.model.Ebay.EbayRequestType;
import com.app.storage.integration.model.Ebay.Requests.GetSessionIDRequestIntegrationModel;
import com.app.storage.integration.model.Ebay.Responses.EbayGenericErrorResponseIntegrationModel;
import com.app.storage.integration.model.Ebay.Responses.GetSessionIDResponseIntegrationModel;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;


/**
 * Implementation of {@link EbayRestIntegrationService}
 */
public class EbayRestIntegrationServiceHandler extends ClientSetup implements EbayRestIntegrationService {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(EbayRestIntegrationService.class);

    /**
     * Constructor
     */
    public EbayRestIntegrationServiceHandler() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateNewSessionID() {

        LOG.debug("Generating new session id.");

        final GetSessionIDRequestIntegrationModel sessionIDRequest = new
                GetSessionIDRequestIntegrationModel();

        sessionIDRequest.setRuName(IntegrationConstants.EBAY_SANDBOX_RUNAME);

        final Entity entity = Entity.xml(sessionIDRequest);

        final MultivaluedMap<String, Object> headers = EbayAPIRequestHeadersBuilder.buildFullHeadersSandbox
                (EbayRequestType.GET_SESSION_ID.name());

        final Response response = getWebTarget().request(MediaType.APPLICATION_XML).headers(headers)
                .post(entity);

        GetSessionIDResponseIntegrationModel getSessionIDResponseIntegrationModel =
                (GetSessionIDResponseIntegrationModel) handleGenericErrorConditions(response);

        LOG.debug("Found session id");

        return getSessionIDResponseIntegrationModel.getSessionID();
    }


    /**
     * Handler for request error conditions.
     *
     * @param response
     * @return
     */
    private Object handleGenericErrorConditions(final Response response) {

        LOG.debug("Handling error conditions for response: {}", response.toString());

        if (response.getStatus() == 200 || response.getStatus() == 202) {

            return response.getEntity();

        } else if (response.getEntity() instanceof EbayGenericErrorResponseIntegrationModel) {

            throw new IllegalStateException("Ebay specific generic error - replace with descriptive");

        } else {

            throw new IllegalStateException("Unknown error - return descriptive error to user");
        }
    }


//    final HttpEntity<GetSessionIDRequestIntegrationModel> request = new
//            HttpEntity<>(sessionIDRequest, headers);
//
//    final String responseString = restTemplate.postForObject(
//            IntegrationConstants.EBAY_SANDBOX_URL, request, String.class);
//
//        System.out.println(responseString);
//
//    final ResponseEntity<Object> genericResponse = restTemplate.postForEntity(
//            IntegrationConstants.EBAY_SANDBOX_URL, request, Object.class);
//
//        System.out.println(genericResponse.getBody());
//
//    GetSessionIDResponseIntegrationModel getSessionIDResponseIntegrationModel = null;
//        if (genericResponse.getBody() instanceof GetSessionIDResponseIntegrationModel) {
//        getSessionIDResponseIntegrationModel = (GetSessionIDResponseIntegrationModel) genericResponse.getBody();
//
//        System.out.println("response 200: " + getSessionIDResponseIntegrationModel.toString());
//    } else if(genericResponse.getBody() instanceof EbayGenericErrorResponseIntegrationModel) {
//
//        final EbayGenericErrorResponseIntegrationModel ebayGenericErrorResponse =
//                (EbayGenericErrorResponseIntegrationModel) genericResponse.getBody();
//
//        System.out.println(ebayGenericErrorResponse.toString());
//    }else{
//        System.out.println("Response else: " + genericResponse.toString());
//    }
//
//        return getSessionIDResponseIntegrationModel.getSessionID();
}
