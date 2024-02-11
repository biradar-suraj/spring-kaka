package com.drogo.kafka.consumer;

import com.drogo.kafka.payload.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    /*@KafkaListener(
            topics = "springAppTopic",
            groupId = "myGroup")*/
    public void consumeMessage(String message) {
        LOGGER.info(String.format("Consuming message from springAppTopic:: %s", message));

    }

    @KafkaListener(
            topics = "springAppTopic",
            groupId = "myGroup")
    public void consumeJsonMessage(Student student) {
        LOGGER.info(String.format("Consuming JSON message from springAppTopic:: %s", student.toString()));

    }
}
