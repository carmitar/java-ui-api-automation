package com.trello.api.rest.service;

import com.trello.api.rest.model.response.LabelsOnBoard;
import org.testng.Assert;
import support.ApplicationUrlUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;

public class TrelloApiService {

    private final String PATH_PARAM_ID = "id";
    private final String PATH_PARAM_VALUE = "614cf3e7fe77601acc604bad";

    public RequestSpecification accessTrello() {
        return RestAssured.given()
                .baseUri(ApplicationUrlUtils.getBaseUrlApi())
                .header("Accept", "application/json")
                .queryParam("key", ApplicationUrlUtils.getKey())
                .queryParam("token", ApplicationUrlUtils.getToken());
    }

    public Response createBoardParams(String boardName, String endPoint) {
        return accessTrello()
                .queryParam("name", boardName)
                .queryParam("defaultList", ApplicationUrlUtils.getDefaultList())
                .queryParam("boardId", ApplicationUrlUtils.getBoardId())
                .queryParam("idOrganization", ApplicationUrlUtils.getIdOrganization())
                .body("")
                .post(endPoint);
    }

    public LabelsOnBoard[] colorLabelService() {
        return accessTrello()
                .pathParam(PATH_PARAM_ID, PATH_PARAM_VALUE)
                .body("")
                .get(ApplicationUrlUtils.getBoardsEndPoint() + "{id}" + ApplicationUrlUtils.getLabelsEndPoint())
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(LabelsOnBoard[].class);
    }
}
