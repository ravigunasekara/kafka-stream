package org.ravig.kafka.service;

import org.ravig.kafka.config.AppConstants;
import org.ravig.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private final Logger logger =
            LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "${general.topic.name}",
            groupId = "${general.topic.group.id}")
    public void consume(String message)
    {
        logger.info(String.format("Message recieved -> %s", message));
    }

    @KafkaListener(topics = "${user.topic.name}",
            groupId = "${user.topic.group.id}",
            containerFactory = "userKafkaListenerContainerFactory")
    public void consume(User user)
    {
        logger.info(String.format("User created -> %s", user));
    }
}
