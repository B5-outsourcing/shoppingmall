package com.sparta.shoppingmall.common.util;

import com.sparta.shoppingmall.common.base.dto.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Slf4j(topic = "Controller")
public final class ControllerUtil {

    private ControllerUtil() {
    }

    public static <T> ResponseEntity<CommonResponse<T>> getFieldErrorResponseEntity(BindingResult bindingResult, String message) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            log.error("{} field : {}", fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest()
                .body((CommonResponse<T>) CommonResponse.<List<FieldError>>builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(message)
                        .data(fieldErrors)
                        .build());
    }

    public static <T> ResponseEntity<CommonResponse<T>> getBadRequestResponseEntity(Exception e) {
        return ResponseEntity.badRequest()
                .body((CommonResponse<T>) CommonResponse.builder()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .message(e.getMessage())
                    .build());
    }

    public static <T> ResponseEntity<CommonResponse<T>> getResponseEntity(Object response, String message) {

        return ResponseEntity.ok()
                .body((CommonResponse<T>) CommonResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message(message)
                        .data(response)
                        .build());
    }

}
