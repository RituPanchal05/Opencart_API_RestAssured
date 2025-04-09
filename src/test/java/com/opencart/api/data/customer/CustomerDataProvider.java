package com.opencart.api.data.customer;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {

    @DataProvider(name = "customerRegistrationData")
    public Object[][] provideCustomerData() {
        return new Object[][] {
            // ✅ Positive Test Data
            {"Ritu", "Panchal", "ritu1@example.com", "9876543210", "Pass1234", "Pass1234", "1", "1"},
            {"Krishn", "Panchal", "krishn@example.com", "9123456789", "Test@456", "Test@456", "1", "1"},
            {"Test", "User", "user@example.com", "9012345678", "Sample123", "Sample123", "0", "1"},
        };
    }
}