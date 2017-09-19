package com.app.storage.integration;

/**
 * Integration constants values.
 */
public class IntegrationConstants {

    //Ebay Constants

    /** Ebay sandbox url. */
    public static final String EBAY_SANDBOX_URL = "https://api.sandbox.ebay.com/ws/api.dll";

    /** Ebay sandbox session url. */
    public static final String EBAY_SANDBOX_RUNAME = "Joss_Miller-Tod-JossMill-Numori-vjplv";

    //Header keys
    /** Refers to the key for ebay release version the application supports */
    public static final String EBAY_COMPATIBILITY_KEY = "X-EBAY-API-COMPATIBILITY-LEVEL";

    /** Your ebay developer id key needed for authorisation requests. */
    public static final String EBAY_DEV_NAME_KEY = "X-EBAY-API-DEV-NAME";

    /** your ebay developer application name key needed for authorisation requests. */
    public static final String EBAY_APP_NAME_KEY = "X-EBAY-API-APP-NAME";

    /** your ebay developer certificate name key needed for authorisation requests. */
    public static final String EBAY_CERT_NAME_KEY = "X-EBAY-API-CERT-NAME";

    /** key for header relating to type of api call send to ebay endpoint. */
    public static final String EBAY_CALL_NAME_KEY = "X-EBAY-API-CALL-NAME";

    /** Refers to specific api site endpoint to send requests (dependent on country). */
    public static final String EBAY_SITE_ID_KEY = "X-EBAY-API-SITEID";

    //Header Values
    /** Ebay schema version number. */
    public static final String EBAY_SCHEMA_VERSION_082017 = "967";

    /** Ebay Sandbox dev name id. */
    public static final String EBAY_DEV_NAME_SANDBOX_VALUE = "ef279a4b-8b6e-44e6-9da8-d993ad2c47c9";

    /** Sandbox APP ID value. */
    public static final String EBAY_APP_NAME_SANDBOX_VALUE = "JossMill-NumoriSa-SBX-65d7504c4-cc1d59d6";

    /** Ebay sandbox certificate id value. */
    public static final String EBAY_CERT_NAME_SANDBOX_VALUE = "SBX-5d7504c435c6-56c1-4ab9-8b71-94e4";

    /** Ebay UK site id url. */
    public static final String EBAY_SITE_ID_UK_VALUE = "http://www.ebay.co.uk";

    /** Ebay auth n auth cert redirect url. */
    public static final String EBAY_AUTHnAUTH_CERT_URL = "https://signin.sandbox.ebay.com/ws/eBayISAPI" +
            ".dll?SignIn&runame=Joss_Miller-Tod-JossMill-Numori-vjplv&SessID=<SESSION_ID>";

    //Other

    /** Type of content of request - normally xml. */
    public static final String CONTENT_TYPE_KEY = "Content-Type";

    /** XML Content type header value. */
    public static final String XML_CONTENT_TYPE_VALUE = "text/xml";


}
