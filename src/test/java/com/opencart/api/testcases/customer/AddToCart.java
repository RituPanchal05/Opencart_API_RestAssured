package com.opencart.api.testcases.customer;


import com.opencart.api.clients.customer.CartClient;
import io.qameta.allure.*;
import com.opencart.api.data.customer.CartDataProvider;
import com.opencart.api.utils.TokenManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.File;
import io.qameta.allure.testng.AllureTestNg;



/**
 * Author: Ritu
 * 
 * This class tests the "Add Product to Cart" functionality for OpenCart.
 * It verifies the successful addition of products to the cart.
 */
@Listeners({AllureTestNg.class})
@Feature("Add To Cart API")
public class AddToCart {

    /**
     * Test case to verify adding a product to the cart with valid details.
     * 
     * @param productId ID of the product to be added
     * @param quantity Quantity of the product to be added
     */
	
	@Epic("API Tests")
	@Feature("Customer Registration")
	@Story("Valid Customer Registration")
	@Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "productData", dataProviderClass = CartDataProvider.class, priority = 5)
    public void verifyAddProductToCart(int productId, int quantity) {

        // Step 1: Get token from TokenManager (if needed for cart functionality)
        String token = TokenManager.getToken();

        // Step 2: Send request to add product to the cart
        Response response = new CartClient().addProductToCart(productId, quantity);

        // Print the response for debugging
        System.out.println("CART RESPONSE: " + response.asString());


    }


   
}

