package io.github.alinizam.notifyex.infrastructure.sender;

import io.github.alinizam.notifyex.domain.model.Notification;
import io.github.alinizam.notifyex.domain.model.NotificationType;
import io.github.alinizam.notifyex.domain.ports.out.NotificationSender;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TerminalNotificationSender implements NotificationSender {
    @Override
    public void send(Notification notification) {
        System.out.println("--------------------------------------------");
        System.out.printf("SENDING %s to %s%n", notification.type(), notification.recipient());
        System.out.printf("Message: %s%n", notification.message());
        System.out.println("--------------------------------------------");
    }

    @Override
    public boolean supports(NotificationType type) {
        return true;
    }
}
