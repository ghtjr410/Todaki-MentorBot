package com.todaki.api.common.infrastructure.common;

import com.todaki.api.common.application.port.ClockHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClockHolderImpl implements ClockHolder {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
