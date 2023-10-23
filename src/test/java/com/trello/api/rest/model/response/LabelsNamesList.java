package com.trello.api.rest.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LabelsNamesList {
    private List<LabelsOnBoard> labelsOnBoards;
}
