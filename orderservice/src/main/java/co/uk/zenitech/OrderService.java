package co.uk.zenitech;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {
    private Map<String, Order> orders;

    @PostConstruct
    public void init() {
        orders = new HashMap<>();
    }

    public Order createOrder(@RequestBody Order order) {
        String id = UUID.randomUUID().toString();
        order.setId(id);
        order.setStatus(OrderStatus.PROCESSING);
        orders.put(id, order);

        return order;
    }

    public Order updateOrder(String id, Order order) {
        if (orders.get(id).getStatus() != OrderStatus.PROCESSING) {
            throw new IllegalStateException("Cannot update a processed order");
        }

        orders.put(id, order);

        return order;
    }

    public Collection<Order> getOrders() {
        return orders.values();
    }

    public Order getOrder(String id) {
        return orders.get(id);
    }

    public void approveOrder(String id) {
        Order order = orders.get(id);
        order.setStatus(OrderStatus.APPROVED);
    }

    public void rejectOrder(String id) {
        Order order = orders.get(id);
        order.setStatus(OrderStatus.REJECTED);
    }
}
