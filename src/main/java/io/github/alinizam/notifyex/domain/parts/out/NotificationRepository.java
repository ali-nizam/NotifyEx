package io.github.alinizam.notifyex.domain.parts.out;

import io.github.alinizam.notifyex.domain.model.Notification;

import java.util.Optional;

public interface NotificationRepository {
    void save(Notification notification);
    Optional<Notification> findById(String id);
}
