package com.app.storage.persistence.mapper.constants;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base64 encoder
 */
public class Base64ImageEncoder {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(Base64ImageEncoder.class);

    /**
     * Returns base64 encoded url image for jsp rendering.
     *
     * @param image
     *         byte array image
     * @return Url.
     */
    public static String encodeImageUrl(final byte[] image) {

        LOG.debug("Encoding image");

        final String imageUrl = "data:image/png;base64," + Base64.encode(image);

        LOG.debug("Successfully encoded image returning url: {}", imageUrl);

        return imageUrl;
    }
}
