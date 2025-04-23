package com.opencart.api.assertions;



import io.restassured.response.Response;
import static org.testng.Assert.*;

import org.testng.Assert;


/**
 * @author Ritu Panchal
 *  */


public class Assertions {

    public static void assertStatusCode1(Response response, int expectedStatus) {
        assertEquals(response.statusCode(), expectedStatus, "Status code mismatch");
    }

    public static void assertKeyPresent1(Response response, String key) {
        assertTrue(response.getBody().jsonPath().get(key) != null, "Key not found: " + key);
    }
    
    /**
     * Asserts that the status code is as expected.
     * 
     * @param response - The Response object
     * @param expectedStatusCode - The expected HTTP status code
     */
    public static void assertStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, 
                "Expected status code " + expectedStatusCode + " but found " + response.getStatusCode());
    }

    /**
     * Asserts that a key is present in the response body.
     * 
     * @param response - The Response object
     * @param key - The JSON key path to check
     */
    public static void assertKeyPresent(Response response, String key) {
        Assert.assertNotNull(response.jsonPath().get(key), 
                "Key not found in response: " + key);
    }

    /**
     * Asserts that the response time is less than a specified maximum.
     * 
     * @param response - The Response object
     * @param maxTimeMillis - Maximum allowed response time in milliseconds
     */
    public static void assertResponseTime(Response response, long maxTimeMillis) {
        long time = response.getTime();
        Assert.assertTrue(time < maxTimeMillis, 
                "Response time exceeded! Took: " + time + "ms, Max allowed: " + maxTimeMillis + "ms");
    }

    /**
     * Asserts that the response matches a given JSON schema.
     * 
     * @param response - The Response object
     * @param schemaPath - Classpath-relative path to the schema file
     */
 

    /**
     * Asserts that a header is present and equals the expected value.
     * 
     * @param response - The Response object
     * @param headerName - Name of the header
     * @param expectedValue - Expected header value
     */
    public static void assertHeader(Response response, String headerName, String expectedValue) {
        String actualValue = response.getHeader(headerName);
        Assert.assertNotNull(actualValue, "Header not found: " + headerName);
        Assert.assertEquals(actualValue, expectedValue, 
                "Header value mismatch for " + headerName);
    }
    
}

