package co.uk.microservice.notificationservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @KafkaListener(topics = "notifyTopic")
    public void handleNotify(String name) {
        System.out.println(name);
    }
}
