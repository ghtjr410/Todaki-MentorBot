package com.todaki.api.chat.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Entity
@Table(name = "chat_template")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatTemplate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private ChatCategory category;

    @Column(name = "template", nullable = false, length = 1000)
    private String template;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate;

    public static ChatTemplate create(ChatCategory category, String template, LocalDateTime now) {
        return ChatTemplate.builder()
                .category(category)
                .template(template)
                .createdDate(now)
                .updatedDate(now)
                .build();
    }

    public void updateTemplate(String template, LocalDateTime now) {
        this.template = template;
        this.updatedDate = now;
    }
}
