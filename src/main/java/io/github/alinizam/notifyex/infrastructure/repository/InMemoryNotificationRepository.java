package io.github.alinizam.notifyex.infrastructure.repository;

import io.github.alinizam.notifyex.domain.model.Notification;
import io.github.alinizam.notifyex.domain.ports.out.NotificationRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class InMemoryNotificationRepository implements NotificationRepository {
    private final Map<String, Notification> database = new ConcurrentHashMap<>();

    @Override
    public void save(Notification notification) {
        database.put(notification.id(), notification);
        System.out.println("[In-Memory DB] Notification saved: " + notification.id());
    }

    @Override
    public Optional<Notification> findById(String id) {
        return Optional.ofNullable(database.get(id));
    }
}
