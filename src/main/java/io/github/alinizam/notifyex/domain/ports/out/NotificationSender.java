package io.github.alinizam.notifyex.domain.ports.out;

import io.github.alinizam.notifyex.domain.model.Notification;
import io.github.alinizam.notifyex.domain.model.NotificationType;

public interface NotificationSender {
    void send(Notification notification);
    boolean supports(NotificationType type);
}
