package com.vitamincode03.demoweb.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ApiResponse<T> {
    private Integer statusCode;
    private Boolean success;
    private String message;
    private T data;
}
