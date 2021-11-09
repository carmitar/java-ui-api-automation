package com.trello.api.rest.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AccessRequest {

    private String trelloKey;
    private String trelloToken;

}
