package main.com.test.kafka;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class SimpleKafkaProducer {
    public static void main(String[] args) {
        // Producer properties
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        // Create producer
        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            // Create record
            ProducerRecord<String, String> record =
                    new ProducerRecord<>("test-topic", "key1", "Hello Kafka");

            // Send record and get metadata (blocking call)
            RecordMetadata metadata = producer.send(record).get();

            System.out.printf("Message sent to topic %s partition %d offset %d%n",
                    metadata.topic(), metadata.partition(), metadata.offset());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}