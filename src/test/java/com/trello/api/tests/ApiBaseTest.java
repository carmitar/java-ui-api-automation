package com.trello.api.tests;

import com.trello.api.rest.model.response.BoardResponse;
import com.trello.api.rest.service.TrelloApiService;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import support.ApplicationUrlUtils;

public class ApiBaseTest {
    TrelloApiService trelloApiService = new TrelloApiService();

    @BeforeMethod
    public void readPropertiesFile() {
        trelloApiService
                .accessTrello();
    }

}
