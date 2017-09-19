package com.app.storage.integration.Ebay;

import com.app.storage.integration.Ebay.config.ClientSetup;
import com.app.storage.integration.Ebay.config.EbayAPIRequestHeadersBuilder;
import com.app.storage.integration.IntegrationConstants;
import com.app.storage.integration.model.Ebay.EbayRequestType;
import com.app.storage.integration.model.Ebay.Requests.GetSessionIDRequestIntegrationModel;
import com.app.storage.integration.model.Ebay.Responses.EbayApplicationLevelErrorResponseModel;
import com.app.storage.integration.model.Ebay.Responses.GetSessionIDResponseIntegrationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


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
    public GetSessionIDResponseIntegrationModel generateNewSessionID() {

        LOG.debug("Generating new session id.");

        final GetSessionIDRequestIntegrationModel sessionIDRequest = new
                GetSessionIDRequestIntegrationModel();

        sessionIDRequest.setRuName(IntegrationConstants.EBAY_SANDBOX_RUNAME);

        final Entity entity = Entity.xml(sessionIDRequest);

        final MultivaluedMap<String, Object> headers = EbayAPIRequestHeadersBuilder.buildFullHeadersSandbox
                (EbayRequestType.GET_SESSION_ID.getRequestType());

//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(GetSessionIDRequestIntegrationModel.class);
//            Marshaller jaxbMarshaller = null;
//
//            jaxbMarshaller = jaxbContext.createMarshaller();
//
//            // output pretty printed
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            jaxbMarshaller.marshal(sessionIDRequest, System.out);
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

        final Response response = getWebTarget().request(MediaType.APPLICATION_XML).headers(headers)
                .post(entity);

        response.bufferEntity();
        handleApplicationLevelErrorResponse(response);

        final GetSessionIDResponseIntegrationModel getSessionIDResponseIntegrationModel = response.readEntity
                (GetSessionIDResponseIntegrationModel.class);

        LOG.debug("Found session get session response.");

        return getSessionIDResponseIntegrationModel;
    }


    /**
     * Handles ebay generic error response
     *
     * @param response
     *         {@link Response}
     */
    private void handleApplicationLevelErrorResponse(final Response response) {

        EbayApplicationLevelErrorResponseModel genericErrorResponse;
        try {
            genericErrorResponse = response.readEntity
                    (EbayApplicationLevelErrorResponseModel.class);

        } catch (Exception e) {

            LOG.debug("Response not ebay application-level error response");
            return;
        }

        throw new IllegalStateException(genericErrorResponse.toString());
    }
}
