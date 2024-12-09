package main.com.test.kafka.examples;

import java.util.List;

public class DemoApplication {
    private static final String TOPIC = "orders";

    public static void main(String[] args) {
        Thread consumerThread = new Thread(() -> {
            try (OrderConsumer consumer = new OrderConsumer()) {
                consumer.subscribe(TOPIC);
            }
        });
        consumerThread.start();

        try (OrderProducer producer = new OrderProducer(TOPIC)) {

            OrderItem item = new OrderItem("PROD-1", 2, 29.99);
            OrderItem item1 = new OrderItem("PROD-2", 10, 50.1);
            OrderItem item2 = new OrderItem("PROD-2", 1, 1001);
            Order order = new Order(123L, 59.98, List.of(item));
            Order order1 = new Order(555L, 501, List.of(item1));
            Order order2 = new Order(777L, 1001, List.of(item2));

            producer.sendOrder(order);
            producer.sendOrder(order1);
            producer.sendOrder(order2);
        }
    }
}