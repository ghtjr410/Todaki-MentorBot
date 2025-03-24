package com.todaki.api.chat.infrastructure.client;

import com.todaki.api.chat.infrastructure.dto.ChatGPTMessage;
import com.todaki.api.chat.infrastructure.dto.ChatGPTRequest;
import com.todaki.api.common.application.port.ChatGPTClient;
import com.todaki.api.common.infrastructure.config.OpenAIProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ChatGPTClientImpl implements ChatGPTClient {

    private final RestClient restClient;
    private final OpenAIProperties openAIProperties;

    @Override
    public String chat(String prompt) {

        List<ChatGPTMessage> messages = new ArrayList<>();

        messages.add(ChatGPTMessage.system("당신은 친절한 고민 상담사 입니다."));
        messages.add(ChatGPTMessage.user(prompt));

        ChatGPTRequest request = ChatGPTRequest.from(openAIProperties.getModel(), messages);

        return restClient.post()
                .header("Authorization", "Bearer " + openAIProperties.getKey())
                .header("Content-Type", openAIProperties.getMediaType())
                .body(request)
                .retrieve()
                .body(String.class);

    }
}
