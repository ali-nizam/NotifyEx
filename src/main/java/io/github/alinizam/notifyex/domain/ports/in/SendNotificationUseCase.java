package io.github.alinizam.notifyex.domain.ports.in;

import io.github.alinizam.notifyex.domain.model.Notification;

public interface SendNotificationUseCase {
    Notification send(Notification notification);
}
