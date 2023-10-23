package com.trello.api.rest.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabelsOnBoard {
    private String id;
    private String idBoard;
    private String name;
    private String color;
}
