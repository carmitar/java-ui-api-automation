package com.trello.api.rest.model.response;

import lombok.*;

@Getter
@Setter
public class BoardResponse {

    private String id;
    private String name;
    private String desc;
    private String descData;
    private boolean closed;
    private String idOrganization;
    private String idEnterprise;
    private boolean pinned;
    private String url;
    private String shortUrl;
    private Prefs prefs;
    private LabelNames labelNames;
}
