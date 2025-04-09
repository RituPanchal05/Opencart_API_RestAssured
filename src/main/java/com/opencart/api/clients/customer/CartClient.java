package com.opencart.api.clients.customer;


import io.restassured.response.Response;

import com.opencart.api.utils.TokenManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CartClient {
	// ✅ Get API token from TokenManager (admin login happens only once)
    String token = TokenManager.getToken();


    // Method to handle the add product to cart request
    public Response addProductToCart(int productId, int quantity) {
        return RestAssured.given()
                .formParam("product_id", productId)  // Product ID parameter
                .formParam("quantity", quantity)  
                .queryParam("api_token", token)
                .when()
                .post("http://127.0.0.1/opencart/index.php?route=api/cart/add")
                .then()
                .extract().response();  // Extract the response from the request
    }
}
