package io.github.alinizam.notifyex.domain.service;

import io.github.alinizam.notifyex.domain.model.Notification;
import io.github.alinizam.notifyex.domain.model.NotificationType;
import io.github.alinizam.notifyex.domain.ports.out.NotificationSender;
import io.github.alinizam.notifyex.infrastructure.repository.InMemoryNotificationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class NotificationServiceTest {
    @Test
    void shouldStoreAndSendNotificationSuccessfully() {
        var mockRepo = new InMemoryNotificationRepository();
        final AtomicBoolean isSenderCalled = new AtomicBoolean(false);

        NotificationSender mockSender = new NotificationSender() {
            @Override
            public void send(Notification notification) {
                isSenderCalled.set(true);
            }

            @Override
            public boolean supports(NotificationType type) {
                return type == NotificationType.EMAIL;
            }
        };

        var service = new NotificationService(mockRepo, List.of(mockSender));
        var notification = new Notification("ali@nizam.dev", "Hello NotifyEx!", NotificationType.EMAIL);
        var result = service.send(notification);

        Assertions.assertNotNull(result.id());
        Assertions.assertEquals("ali@nizam.dev", mockRepo.findById(result.id())
                .orElseThrow(() -> new AssertionError("Notification should be present in repository"))
                .recipient());

        Assertions.assertTrue(isSenderCalled.get(), "NotificationSender should have been called");
    }
}
