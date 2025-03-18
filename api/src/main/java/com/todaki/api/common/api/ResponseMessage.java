package com.todaki.api.common.api;

import com.todaki.api.common.domain.BaseMessage;
import lombok.Getter;

@Getter
public enum ResponseMessage implements BaseMessage {
    SUCCESS("Success"),
    ERROR("Error");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }
}
