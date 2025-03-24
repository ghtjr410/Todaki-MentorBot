package com.todaki.api.chat.infrastructure.repository;

import com.todaki.api.chat.domain.ChatTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatTemplateRepositoryImpl extends JpaRepository<ChatTemplate, Long> {
}
