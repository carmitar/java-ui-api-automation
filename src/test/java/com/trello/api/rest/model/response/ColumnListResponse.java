package com.trello.api.rest.model.response;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ColumnListResponse implements Comparable<ColumnListResponse> {

    private String id;
    private String name;
    private boolean closed;
    private int pos;
    private String softLimit;
    private String idBoard;
    private boolean subscribed;

    public ColumnListResponse(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(ColumnListResponse columnListResponse) {
        return this.name.compareTo(columnListResponse.name);
    }
}
