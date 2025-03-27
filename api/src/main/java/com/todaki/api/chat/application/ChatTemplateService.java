package com.todaki.api.chat.application;

import com.todaki.api.common.application.port.ClockHolder;
import com.todaki.api.chat.domain.ChatCategory;
import com.todaki.api.chat.domain.ChatTemplate;
import com.todaki.api.chat.infrastructure.repository.ChatTemplateRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatTemplateService {

    private final ClockHolder clockHolder;
    private final ChatTemplateRepositoryImpl chatTemplateRepository;

    public void create(String template) {
        ChatTemplate chatTemplate = ChatTemplate.create(ChatCategory.FAMILY, template, clockHolder.now());
        chatTemplateRepository.save(chatTemplate);
    }

    public void update(long id, String template) {
        ChatTemplate chatTemplate = chatTemplateRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        chatTemplate.updateTemplate(template, clockHolder.now());
    }

    /**
     * 1. 템플릿 생성하는거 세분화해서 잘해봐
     * 2. 사용자의 대화요청을 템플릿에 맞춰서 세분화하기 요청만받아봐
     * 3. 사용자의 대화요청을 템플릿으로 어쩌고해서 그 저거해봐 api로 받아와바
     */
}
