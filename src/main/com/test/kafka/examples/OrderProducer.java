package main.com.test.kafka.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

@Slf4j
public class OrderProducer implements AutoCloseable {
    private final KafkaProducer<String, String> producer;
    private final String topic;
    private final ObjectMapper objectMapper;

    public OrderProducer(String topic) {
        this.producer = new KafkaProducer<>(KafkaConfig.getProducerProperties());
        this.topic = topic;
        this.objectMapper = new ObjectMapper();
    }

    public void sendOrder(Order order) {
        try {
            String orderJson = objectMapper.writeValueAsString(order);
            ProducerRecord<String, String> record =
                    new ProducerRecord<>(topic, order.getOrderId(), orderJson);

            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    log.error("Error sending message: ", exception);
                } else {
                    log.info("Message sent successfully to topic: {}, partition: {}",
                            metadata.topic(), metadata.partition());
                }
            });
        } catch (Exception e) {
            log.error("Error serializing order: ", e);
        }
    }

    @Override
    public void close() {
        producer.close();
    }
}