package com.ibm.pnckafka.kafkastream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class consumer {
    private final Logger logger = LoggerFactory.getLogger(producer.class);

    @KafkaListener(topics = "Balance", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
