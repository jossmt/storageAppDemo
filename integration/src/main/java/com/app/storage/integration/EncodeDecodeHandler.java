package com.app.storage.integration;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Handles text encoding/decoding
 */
public class EncodeDecodeHandler {

    /**
     * Handles string encoding
     *
     * @param text
     *         Text to encode.
     * @return Encoded text.
     * @throws UnsupportedEncodingException
     */
    public static String encodeString(final String text) {

        byte[] bytes = new byte[0];
        try {
            bytes = text.getBytes("UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

            throw new IllegalStateException("Unable to encode text: " + text);
        }
        return Base64.encode(bytes);
    }

    /**
     * Handles string decoding.
     *
     * @param encodedText
     *         Encoded text.
     * @return Original text.
     * @throws UnsupportedEncodingException
     * @throws Base64DecodingException
     */
    public static String decodeString(final String encodedText) {

        byte[] decodeBytes = new byte[0];
        try {
            decodeBytes = Base64.decode(encodedText);

            return new String(decodeBytes, "UTF-8");

        } catch (Base64DecodingException | UnsupportedEncodingException e) {
            e.printStackTrace();

            throw new IllegalStateException("Unable to decode string: {}" + encodedText);
        }
    }
}
