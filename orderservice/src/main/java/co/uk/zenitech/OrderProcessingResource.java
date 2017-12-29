package co.uk.zenitech;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProcessingResource {

    private OrderService orderService;

    public OrderProcessingResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/approved/{id}", method = RequestMethod.GET)
    public void approveOrder(@PathVariable String id) {
        orderService.approveOrder(id);
    }

    @RequestMapping(value = "/rejected/{id}", method = RequestMethod.GET)
    public void rejectOrder(@PathVariable String id) {
        orderService.rejectOrder(id);
    }

}
