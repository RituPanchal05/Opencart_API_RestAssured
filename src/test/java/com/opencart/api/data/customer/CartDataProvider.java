package com.opencart.api.data.customer;


import org.testng.annotations.DataProvider;

public class CartDataProvider {

    // Data provider for valid product add to cart
    @DataProvider(name = "productData")
    public Object[][] productData() {
        return new Object[][] {
            { 41, 2 }, 
            { 40, 1 },  
            { 100, 100 },  
            { 40, -3 },  
            { 41, 0 }, 
            {0,-0}
        };
    }

  
}

