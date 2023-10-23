package com.trello.api.tests;

import com.trello.BaseTest;
import com.trello.api.rest.model.response.LabelsOnBoard;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class LabelsTests extends BaseTest {


    @Test
    public void getColorsTest() {
        LabelsOnBoard[] labelsOnBoards = trelloApiService
                .colorLabelService();
        for(LabelsOnBoard item : labelsOnBoards) {
            System.out.println(item.getColor());
            if (item.getName().equals("green") || item.getName().equals("red")) {
                assertEquals(item.getName(), "green");
                assertEquals(item.getName(), "red");
            }
        }
    }
}
