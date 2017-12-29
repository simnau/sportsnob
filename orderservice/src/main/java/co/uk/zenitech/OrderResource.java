package co.uk.zenitech;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class OrderResource {

    private OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Order updateOrder(@PathVariable String id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Order> getOrders() {
        return orderService.getOrders();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }
}
