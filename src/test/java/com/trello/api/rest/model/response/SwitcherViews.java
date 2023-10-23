package com.trello.api.rest.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwitcherViews {
    private String _id;
    private String viewType;
    private boolean enabled;
}
