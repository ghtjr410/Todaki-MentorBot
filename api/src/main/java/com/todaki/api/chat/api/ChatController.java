package com.todaki.api.chat.api;

import com.todaki.api.chat.api.dto.ChatRequest;
import com.todaki.api.chat.api.dto.ChatTemplateCreateRequest;
import com.todaki.api.chat.application.ChatService;
import com.todaki.api.chat.application.ChatTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatTemplateService chatTemplateService;
    private final ChatService chatService;

    @PostMapping("/template/new")
    public void createTemplate(
            @RequestBody ChatTemplateCreateRequest request
    ) {
        chatTemplateService.create(request.template());
    }

    @PostMapping
    public String chat(
            @RequestBody ChatRequest request
    ) {

        return chatService.chat(request.templateId(), request.chat());
    }
}
