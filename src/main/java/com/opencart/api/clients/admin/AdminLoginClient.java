package com.opencart.api.clients.admin;

import com.opencart.api.config.ConfigManager;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/** @author Ritu Panchal
 * This class is responsible for handling the Admin login functionality via API.
 * It sends a POST request with admin credentials and returns the response.
 
 * FLOW is: Config.Properties --> ConfigManager --> AdminLoginClient --> Testcase(LoginAdmin)
 */

public class AdminLoginClient {

    /**
     * Logs in as an Admin using OpenCart's API.
     *
     * The endpoint being hit: http://<base_url>/index.php?route=api/login
     * Required parameters: username, key (API Key)
     *
     * @return Response object containing the login API response
     */
	
    public Response loginAsAdmin() {

        // Initiating the login request using Rest Assured
    	System.out.println("📁 Step 2: Sending login request via AdminLoginClient.java");
        return given()
        		
                // Base URL (excluding route param) from config.properties
        		
                .baseUri(ConfigManager.getBaseUrl())

                // Adding query parameter required by OpenCart's login API
                
                .queryParam("route", "api/login")

                // Tells server we are sending URL-encoded form data
                
                .contentType("application/x-www-form-urlencoded")

                // Adding form parameters: admin username & API Key
                
                .formParam("username", ConfigManager.getAdminUsername())
                .formParam("key", ConfigManager.getAdminApiKey())

                // Logging full request details for debugging
                
                .log().all()

                
                .post()

                // Logging full response details for debugging
                
                .then().log().all()

                // Returning the extracted response
                
                .extract().response();
    }
}
