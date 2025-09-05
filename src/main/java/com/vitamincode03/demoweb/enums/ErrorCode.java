package com.vitamincode03.demoweb.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
/*
      1xx (100 – 199): Information responses
      2xx (200 – 299): Successful responses
      3xx (300 – 399): Redirects
      4xx (400 – 499): Client errors
      5xx (500 – 599): Server errors

  CUSTOM:
      1xxx (1000 - 1999): User features errors
 */
public enum ErrorCode {

    INCORRECT_PASSWORD(401 , "Wrong password"),
    LIST_REQUEST_EMPTY(405, "Null request"),


    // define Error Code
    LIST_USER_NOT_FOUND(1000 , "User list not found"),
    USER_NOT_FOUND(1001 , "User not found"),

    BAD_SQL(500 , "Bad SQL"),
    NULL_POINTER(500 , "Null Pointer"),

    UNKNOWN_EXCEPTION(500, "")
    ;

    //properties
    private final Integer code;
    private final String message;
}
