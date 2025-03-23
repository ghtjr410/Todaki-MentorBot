package com.todaki.api.chat.infrastructure.dto;

import com.todaki.api.common.infrastructure.config.OpenAIProperties;

import java.util.List;

public record ChatGPTRequest(
        String model,
        List<ChatGPTMessage> messages
) {
    public static ChatGPTRequest from(String model, List<ChatGPTMessage> messages) {
        return new ChatGPTRequest(
                model,
                messages
        );
    }
}
