package com.vitamincode03.demoweb.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INCORRECT_PASSWORD(401 , "Sai password"),
    LIST_USER_DTO_REQUEST_EMPTY(405, "Danh sách userDtoRequest rỗng"),

    // define Error Code
    LIST_USER_NOT_FOUND(1000 , "Danh sách user rỗng"),
    USER_NOT_FOUND(1001 , "Không tìm thấy user"),


    BAD_SQL(500 , "Sai syntax SQL"),
    NULL_POINTER(500 , "Lỗi Null Pointer"),

    UNKNOWN_EXCEPTION(500, "")
    ;

    //properties
    private final Integer code;
    private final String message;
}
