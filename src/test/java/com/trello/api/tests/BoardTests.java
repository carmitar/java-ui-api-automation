package com.trello.api.tests;

import com.trello.BaseTest;
import com.trello.api.rest.model.response.BoardResponse;
import support.HelperMethods;
import support.ApplicationUrlUtils;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.AssertJUnit.assertEquals;

public class BoardTests extends BaseTest {

    private final String BOARD_NAME = "My board";
    private final String NEW_BOARD = HelperMethods.randomString(10);
    private final String PATH_PARAM_ID = "id";
    private final String PATH_PARAM_VALUE = "618060f9d25e885a37f6aa1c";

    @Test
    public void getBoard() {
        BoardResponse response = trelloApiService
                .accessTrello()
                .pathParam(PATH_PARAM_ID, PATH_PARAM_VALUE)
                .body("")
                .get("/1/boards/{id}")
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(BoardResponse.class);
        assertEquals(BOARD_NAME, response.getName());
    }

    @Test
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

