package com.my.research.and.dev.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

// /Users/dmitry.palaznik/.m2/repository/org/apache/kafka/kafka-clients/0.10.1.0/kafka-clients-0.10.1.0.jar
// /Users/dmitry.palaznik/.m2/repository/org/apache/kafka/kafka-clients/0.10.0.1/kafka-clients-0.10.0.1.jar

public class ConsumerGroup {

    public static void main(final String[] args) throws Exception {

        if (args.length < 2) {
            System.out.println("Usage: consumer <topic> <groupname>");
            return;
        }

        final String topic = args[0];
        final String group = args[1];

        final Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", group);
        props.put("enable.auto.commit", "true");
        props.put("auto.offset.reset", "earliest");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));
        System.out.println("Subscribed to topic " + topic);

        while (true) {
            final ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
            }
        }
    }
}
