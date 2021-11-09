package com.trello.api.rest.service;

import com.trello.support.HelperMethods;
import com.trello.support.ReadPropertyFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TrelloApiService {

    public RequestSpecification accessTrello() {
        return RestAssured.given()
                .baseUri(ReadPropertyFile.getBaseUrl())
                .header("Accept", "application/json")
                .queryParam("key", ReadPropertyFile.getKey())
                .queryParam("token", ReadPropertyFile.getToken());
    }

    public Response createBoardParams(String boardName, String endPoint) {
        RequestSpecification request = RestAssured.given();
        return request
                .baseUri(ReadPropertyFile.getBaseUrl())
                .queryParam("name", boardName)
                .queryParam("key", ReadPropertyFile.getKey())
                .queryParam("token", ReadPropertyFile.getToken())
                .queryParam("defaultList", ReadPropertyFile.getDefaultList())
                .queryParam("boardId", ReadPropertyFile.getBoardId())
                .queryParam("idOrganization", ReadPropertyFile.getIdOrganization())
                .body("")
                .post(endPoint);
    }

}
