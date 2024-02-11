package com.drogo.kafka.producer;

import com.drogo.kafka.payload.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {
    private final KafkaTemplate<String, Student> kafkaTemplate;

    @Autowired
    public KafkaJsonProducer(KafkaTemplate<String, Student> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJsonMessage(Student student) {
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "springAppTopic")
                .build();
        kafkaTemplate.send(message);
    }
}
