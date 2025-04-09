package com.opencart.api.clients.customer;

import static io.restassured.RestAssured.given;

import com.opencart.api.utils.TokenManager;
import io.restassured.response.Response;

public class CustomerRegisterClient {

    // ✅ Get API token from TokenManager (admin login happens only once)
    String token = TokenManager.getToken();

    /**
     * Registers a customer using the provided details and logs full request and response.
     *
     * @param firstName         First name of the customer
     * @param lastName          Last name of the customer
     * @param email             Email ID of the customer
     * @param telephone         Customer's phone number
     * @param password          Password for account
     * @param confirmPassword   Confirm password (must match password)
     * @return                  API response object
     */
    public Response registerCustomer(String firstName, String lastName, String email, String telephone, String password, String confirmPassword, String newsletter, String agree) {

        return given()
                .baseUri("http://127.0.0.1/opencart/index.php")
                .queryParam("route", "account/register")
                .formParam("firstname", firstName)
                .formParam("lastname", lastName)
                .formParam("email", email)
                .formParam("telephone", telephone)
                .formParam("password", password)
                .formParam("confirm", confirmPassword)
                .formParam("newsletter", newsletter) // ✅ newsletter field
                .formParam("agree", agree) 
                .queryParam("api_token", token)
                
                // Logs request details (headers, params, body)
                .log().all()
                
                .post()
                
                // Logs the response details (status, headers, body)
                .then().log().all()
                .extract().response();
    }
}
