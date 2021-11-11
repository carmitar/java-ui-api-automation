package com.trello.api.rest.service;

import support.ApplicationUrlUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TrelloApiService {

    public RequestSpecification accessTrello() {
        return RestAssured.given()
                .baseUri(ApplicationUrlUtils.getBaseUrlApi())
                .header("Accept", "application/json")
                .queryParam("key", ApplicationUrlUtils.getKey())
                .queryParam("token", ApplicationUrlUtils.getToken());
    }

    public Response createBoardParams(String boardName, String endPoint) {
        RequestSpecification request = RestAssured.given();
        return request
                .baseUri(ApplicationUrlUtils.getBaseUrlApi())
                .queryParam("name", boardName)
                .queryParam("key", ApplicationUrlUtils.getKey())
                .queryParam("token", ApplicationUrlUtils.getToken())
                .queryParam("defaultList", ApplicationUrlUtils.getDefaultList())
                .queryParam("boardId", ApplicationUrlUtils.getBoardId())
                .queryParam("idOrganization", ApplicationUrlUtils.getIdOrganization())
                .body("")
                .post(endPoint);
    }

}
