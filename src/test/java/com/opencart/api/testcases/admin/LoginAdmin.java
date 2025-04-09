package com.opencart.api.testcases.admin;

import com.opencart.api.clients.admin.AdminLoginClient;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;


/** @author Ritu Panchal


 * Test class to verify successful login functionality for Admin API in OpenCart.
 * FLOW is: Config.Properties --> ConfigManager --> AdminLoginClient --> Testcase(LoginAdmin)
 */

@Listeners({AllureTestNg.class})
@Feature("Admin Registration API")
public class LoginAdmin {

    private AdminLoginClient adminLoginClient;

    /**
     * This method runs before any test in this class.
     * Initializes the AdminLoginClient instance to extract username and key to generate token.
     */
    
    @BeforeClass
    public void setUp() {
        adminLoginClient = new AdminLoginClient();
    }
    

    /**
     * Test case to verify that an Admin user can successfully log in.
    
     * Steps:
     * 1. Send login request with valid admin credentials (from: AdminLoginClient).
     * 2. Verify that the response status code is 200.
     * 3. Verify that the response contains a non-null api_token.
     */
    
    @Epic("API Tests")
    @Feature("Customer Registration")
    @Story("Valid Customer Registration")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Verify Admin Login API returns valid token")
    public void verifyAdminCanLoginSuccessfully() {
        System.out.println("\nStarting Test: Admin Login Flow");

        Response response = new AdminLoginClient().loginAsAdmin();

        System.out.println("Step 3: Validating login response in LoginAdmin.java");
        System.out.println("Full Response: " + response.asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        String token = response.jsonPath().getString("api_token");
        Assert.assertNotNull(token, " Token is null!");

        System.out.println("Admin login test completed successfully.\n");
    }

}
