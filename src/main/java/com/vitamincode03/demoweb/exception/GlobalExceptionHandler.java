package com.vitamincode03.demoweb.exception;


import com.vitamincode03.demoweb.dto.response.ApiResponse;
import com.vitamincode03.demoweb.enums.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    public void logError(Exception e, HttpServletRequest request) {
        log.error(">>> Fail to call api: " + request.getRequestURI() + " with ERROR: " + e.getClass().getSimpleName());
    }

    @ExceptionHandler(value = BadSqlGrammarException.class)
    ResponseEntity<ApiResponse> handleBadSqlGrammarException(BadSqlGrammarException e, HttpServletRequest request){
        logError(e, request);
        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .statusCode(ErrorCode.BAD_SQL.getCode())
                        .success(Boolean.FALSE)
                        .message(ErrorCode.BAD_SQL.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(value = NullPointerException.class)
    ResponseEntity<ApiResponse> handleNullPointerException(NullPointerException e, HttpServletRequest request){
        logError(e, request);
        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .statusCode(ErrorCode.BAD_SQL.getCode())
                        .success(Boolean.FALSE)
                        .message(ErrorCode.BAD_SQL.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handleUnKnownException(Exception e, HttpServletRequest request){
        logError(e, request);
        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .statusCode(ErrorCode.UNKNOWN_EXCEPTION.getCode())
                        .success(Boolean.FALSE)
                        .message(">>>> Error:" + e.getClass().getSimpleName())
                        .build()
        );
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handleAppException(AppException e, HttpServletRequest request){
        logError(e, request);
        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .statusCode(e.getErrorCode().getCode())
                        .success(Boolean.FALSE)
                        .message(e.getErrorCode().getMessage())
                        .build()
        );
    }
}
