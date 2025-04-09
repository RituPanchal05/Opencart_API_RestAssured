package com.opencart.api.utils;


import com.opencart.api.clients.admin.AdminLoginClient;
import io.restassured.path.json.JsonPath;

public class TokenManager {
    private static String token;

    public static String getToken() {
        if (token == null) {
            AdminLoginClient loginClient = new AdminLoginClient();
            JsonPath jp = loginClient.loginAsAdmin().jsonPath();
            token = jp.getString("api_token");
        }
        return token;
    }
}

