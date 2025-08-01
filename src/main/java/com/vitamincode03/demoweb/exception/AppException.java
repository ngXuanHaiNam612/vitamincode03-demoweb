package com.vitamincode03.demoweb.exception;

import com.vitamincode03.demoweb.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppException extends RuntimeException {
    ErrorCode errorCode;
}
