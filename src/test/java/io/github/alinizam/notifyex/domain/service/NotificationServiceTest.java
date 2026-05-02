package io.github.alinizam.notifyex.domain.service;

import io.github.alinizam.notifyex.domain.model.Notification;
import io.github.alinizam.notifyex.domain.model.NotificationType;
import io.github.alinizam.notifyex.infrastructure.repository.InMemoryNotificationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotificationServiceTest {
    @Test
    void shouldStoreNotificationSuccessfully() {
        var mockRepo = new InMemoryNotificationRepository();
        var service = new NotificationService(mockRepo);
        var notification = new Notification("ali@nizam.dev", "Hello NotifyEx!", NotificationType.EMAIL);
        var result = service.send(notification);

        Assertions.assertNotNull(result.id());
        Assertions.assertEquals("ali@nizam.dev", mockRepo.findById(result.id())
                .orElseThrow(() -> new AssertionError("Notification should be present in repository")).recipient());
    }
}
