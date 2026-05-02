package io.github.alinizam.notifyex.domain.service;

import io.github.alinizam.notifyex.domain.model.Notification;
import io.github.alinizam.notifyex.domain.parts.in.SendNotificationUseCase;
import io.github.alinizam.notifyex.domain.parts.out.NotificationRepository;

public class NotificationService implements SendNotificationUseCase {
    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notification send(Notification notification) {
        System.out.println("Processing notification for: " + notification.recipient());
        repository.save(notification);
        return notification;
    }
}
