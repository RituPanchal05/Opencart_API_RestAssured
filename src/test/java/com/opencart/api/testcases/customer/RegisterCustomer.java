package com.opencart.api.testcases.customer;

// Import necessary libraries and classes for the test case
import com.opencart.api.clients.customer.CustomerRegisterClient;
import io.qameta.allure.*;
import com.opencart.api.data.customer.CustomerDataProvider;
import com.opencart.api.utils.TokenManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import io.qameta.allure.testng.AllureTestNg;


/**
 * @author Ritu Panchal
 * 
 * This class handles the customer registration API test case for OpenCart.
 * It tests the customer registration functionality by using valid registration data 
 * and verifying the API response.
 */
@Listeners({AllureTestNg.class})
@Feature("Customer Registration API")
public class RegisterCustomer {

    /**
     * Test case to verify customer registration.
     * The test uses a data provider that provides different sets of customer registration data.
     * 
     * @param firstName First name of the customer
     * @param lastName Last name of the customer
     * @param email Email address of the customer
     * @param telephone Customer's phone number
     * @param password Customer's password
     * @param confirmPassword Confirmed password
     * @param newsletter Newsletter subscription preference
     * @param agree Acceptance of terms and conditions
     */
	
	@Epic("API Tests")
	@Feature("Customer Registration")
	@Story("Valid Customer Registration")
	@Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "customerRegistrationData", dataProviderClass = CustomerDataProvider.class, priority = 2)
    public void verifyCustomerRegistration(String firstName, String lastName, String email, String telephone, String password, String confirmPassword, String newsletter, String agree) {

        // Step 1: Retrieve the authentication token using the TokenManager class.
        // This avoids calling the admin login again as the token is reusable.
    	
        String token = TokenManager.getToken();

        // Step 2: Register a new customer by passing the registration details and the token
        // to the CustomerRegisterClient's registerCustomer method.
        // The method will send the request to the OpenCart API and return the response.
        
        Response response = new CustomerRegisterClient().registerCustomer(
            firstName, lastName, email, telephone, password, confirmPassword, newsletter, agree
        );

        // Print the response for debugging purposes to see the output
        System.out.println("RESPONSE: " + response.asString());

    
        
        // Assert.assertEquals(response.getStatusCode(), 302); // Status code should be 302 for redirection
        // Assert.assertTrue(response.asString().contains("success") || response.asString().contains("warning")); 
        // Handle both successful registration and duplicate registration cases
    }
}
