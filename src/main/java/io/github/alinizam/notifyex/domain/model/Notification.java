package io.github.alinizam.notifyex.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record Notification(String id, String recipient, String message, NotificationType type, LocalDateTime createdAt) {
    public Notification(String recipient, String message, NotificationType type) {
        this(UUID.randomUUID().toString(), recipient, message, type, LocalDateTime.now());
    }
}
