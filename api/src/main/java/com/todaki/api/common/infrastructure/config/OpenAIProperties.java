package com.todaki.api.common.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "openai.api")
public class OpenAIProperties {
    private String model;
    private String key;
    private String mediaType;
}
