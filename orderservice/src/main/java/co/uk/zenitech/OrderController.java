package co.uk.zenitech;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class OrderController {

    private Map<String, String> orders;

    @PostConstruct
    public void init() {
        orders = new HashMap<>();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createOrder(@RequestBody String order) {
        String id = UUID.randomUUID().toString();
        orders.put(id, order);

        return id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateOrder(@PathVariable String id, @RequestBody String order) {
        orders.put(id, order);

        return id;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<String> getOrders() {
        return orders.values();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getOrder(@PathVariable String id) {
        return orders.get(id);
    }
}
