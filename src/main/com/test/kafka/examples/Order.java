package main.com.test.kafka.examples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.com.test.kafka.examples.OrderItem;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private long userId;
    private double amount;
    private List<OrderItem> items;

    public Order(long userId, double amount, List<OrderItem> items) {
        this.orderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.amount = amount;
        this.items = items;
    }
}