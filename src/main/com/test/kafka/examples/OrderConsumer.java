package main.com.test.kafka.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class OrderConsumer implements AutoCloseable {
    private final KafkaConsumer<String, String> consumer;
    private final ObjectMapper objectMapper;
    private volatile boolean running = true;

    public OrderConsumer() {
        this.consumer = new KafkaConsumer<>(KafkaConfig.getConsumerProperties());
        this.objectMapper = new ObjectMapper();
    }

    public void subscribe(String topic) {
        consumer.subscribe(Collections.singletonList(topic));
        log.info("Subscribed to topic: {}", topic);

        try {
            while (running) {
                ConsumerRecords<String, String> records =
                        consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, String> record : records) {
                    processOrder(record);
                    consumer.commitSync();
                }
            }
        } catch (Exception e) {
            log.error("Error while consuming messages: ", e);
        }
    }

    private void processOrder(ConsumerRecord<String, String> record) {
        try {
            Order order = objectMapper.readValue(record.value(), Order.class);

            double totalAmount = order.getAmount();
            int totalItems = order.getItems().stream()
                    .mapToInt(OrderItem::getQuantity)
                    .sum();

            String orderCategory = totalAmount > 1000 ? "HIGH_VALUE" :
                    totalAmount > 500 ? "MEDIUM_VALUE" : "STANDARD";

            log.info("\nOrder Processed Successfully:" +
                            "\nOrder ID: {}" +
                            "\nTotal Items: {}" +
                            "\nTotal Amount: ${}" +
                            "\nOrder Category: {}" +
                            "\nProducts Ordered: {}",
                    order.getOrderId(),
                    totalItems,
                    totalAmount,
                    orderCategory,
                    formatOrderItems(order.getItems()));

        } catch (Exception e) {
            log.error("Error processing order: ", e);
        }
    }

    private String formatOrderItems(List<OrderItem> items) {
        return items.stream()
                .map(item -> String.format("\n  - Product: %s, Quantity: %d, Price: $%.2f",
                        item.getProductId(),
                        item.getQuantity(),
                        item.getPrice()))
                .collect(Collectors.joining());
    }

    public void shutdown() {
        running = false;
    }

    @Override
    public void close() {
        shutdown();
        consumer.close();
    }
}