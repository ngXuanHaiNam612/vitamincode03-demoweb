package com.vitamincode03.demoweb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PageDtoRequest {
    private int page;
    private int size;
    // condition clause
    // sort direction

    public int getOffset() {
        return (this.getPage() - 1) * this.getSize();
    }

}
