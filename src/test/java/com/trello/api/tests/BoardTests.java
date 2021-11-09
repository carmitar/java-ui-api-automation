package com.trello.api.tests;

import com.trello.api.rest.model.response.BoardResponse;
import com.trello.support.HelperMethods;
import com.trello.support.ReadPropertyFile;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.AssertJUnit.assertEquals;

public class BoardTests extends ReadPropertyFile {

    private final String BOARD_NAME = "My board";
    private final String NEW_BOARD = HelperMethods.randomString(10);
    private final String PATH_PARAM_ID = "id";
    private final String PATH_PARAM_VALUE = "60ac9ea527e01b4687cbfa02";

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

