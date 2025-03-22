package com.todaki.api.common.application.port;

import java.time.LocalDateTime;

public interface ClockHolder {
    LocalDateTime now();
}
