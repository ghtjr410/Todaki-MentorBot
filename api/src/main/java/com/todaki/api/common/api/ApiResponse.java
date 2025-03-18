package com.todaki.api.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static com.todaki.api.common.api.ResponseMessage.*;

public record ApiResponse<T>(
        String message,
        @JsonInclude(NON_NULL)
        T data
) {
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(SUCCESS.getMessage(), null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(SUCCESS.getMessage(), data);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(message, null);
    }
}
