package com.todaki.api.chat.application;

import com.todaki.api.common.application.port.ChatGPTClient;
import com.todaki.api.chat.domain.ChatTemplate;
import com.todaki.api.chat.infrastructure.repository.ChatTemplateRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatTemplateRepositoryImpl ChatTemplateRepositoryImpl;
    private final ChatGPTClient gptClient;

    public String chat(long chatTemplateId, String message) {
        ChatTemplate chatTemplate = ChatTemplateRepositoryImpl.findById(chatTemplateId)
                .orElseThrow(RuntimeException::new);

        String prompt = chatTemplate.getTemplate().replace("{user_input}", message);

        return gptClient.chat(prompt);
    }
}
