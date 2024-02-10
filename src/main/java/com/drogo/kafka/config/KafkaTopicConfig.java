package com.drogo.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class KafkaTopicConfig {

    @Bean
    public NewTopic springAppTopic() {
        return TopicBuilder
                .name("springAppTopic")
                .partitions(5)
                .build();

    }

}
