package io.github.alinizam.notifyex.domain.service;

import io.github.alinizam.notifyex.domain.model.Notification;
import io.github.alinizam.notifyex.domain.ports.in.SendNotificationUseCase;
import io.github.alinizam.notifyex.domain.ports.out.NotificationRepository;
import io.github.alinizam.notifyex.domain.ports.out.NotificationSender;

import java.util.List;

public class NotificationService implements SendNotificationUseCase {
    private final NotificationRepository repository;
    private final List<NotificationSender> senders;

    public NotificationService(NotificationRepository repository, List<NotificationSender> senders) {
        this.repository = repository;
        this.senders = senders;
    }

    @Override
    public Notification send(Notification notification) {
        repository.save(notification);
        senders.stream()
                .filter(s -> s.supports(notification.type()))
                .findFirst()
                .ifPresent(s -> s.send(notification));

        return notification;
    }
}
