package com.trello.api.tests;

import com.trello.api.rest.model.response.BoardResponse;
import com.trello.api.rest.service.TrelloApiService;
import support.HelperMethods;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.AssertJUnit.assertEquals;

public class BoardTests {

    private final String BOARD_NAME = "My board";
    private final String NEW_BOARD = HelperMethods.randomString(10);
    private final String PATH_PARAM_ID = "id";
    private final String PATH_PARAM_VALUE = "614cf3e7fe77601acc604bad";
    private TrelloApiService trelloApiService = new TrelloApiService();

    @Test(enabled = true)
    public void getBoard() {
        BoardResponse boardResponse = trelloApiService
                .accessTrello()
                .pathParam(PATH_PARAM_ID, PATH_PARAM_VALUE)
                .body("")
                .get("/1/boards/{id}")
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(BoardResponse.class);
        assertEquals(BOARD_NAME, boardResponse.getName());
    }

    @Test(enabled = true)
    public void createBoard() {
        BoardResponse boardResponse = trelloApiService
                .createBoardParams(NEW_BOARD, "/1/boards/")
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(BoardResponse.class);
        assertEquals(NEW_BOARD, boardResponse.getName());
    }
}

