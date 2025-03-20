package com.todaki.api.chat.api.dto;

public record ChatRequest(
        Long templateId,
        String chat
) {
}
