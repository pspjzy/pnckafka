package com.ibm.pnckafka.kafkastream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * https://www.confluent.io/blog/apache-kafka-spring-boot-application/
 */

@Service
public class producer {
    private static final Logger logger = LoggerFactory.getLogger(producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg(String msg){
        logger.info(String.format("#### -> Producing message -> %s", msg));
        this.kafkaTemplate.send(KafkaStream.BTOPIC,msg);
    }
}
