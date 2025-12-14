package com.pastcampus.sns.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT,"USER NAME IS DUPLICATED"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"USER NOT FOUND"),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED,"Password is invalid"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"Internal server error"),;

    private HttpStatus status;
    private String message;
}
