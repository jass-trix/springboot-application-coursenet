package com.coursenet;

import com.coursenet.model.Order;
import com.coursenet.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest-orders", produces = "application/json")
public class OrderRestControllerImpl implements OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "", consumes = "application/json")
    @Override
    public void createNewOrder(@RequestBody OrderDTO orderDTO) {
        orderService.createNewOrder(orderDTO.getName(), orderDTO.getDescription());
    }

    @GetMapping(value = "")
    @Override
    public List<OrderDTO> getOrderList() {
        return orderService.getOrderList();
    }

    @GetMapping(value = "/{id}")
    @Override
    public OrderDTO getOrder(@PathVariable(value = "id") Long orderId) {
        return orderService.getOrder(orderId);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public void deleteOrder(@PathVariable(value = "id") Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    @Override
    public void updateOrder(@PathVariable(value = "id") long orderId, @RequestBody OrderDTO orderDTO) {
        orderService.updateOrder(orderId, orderDTO);
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    @Override
    public void updateOrder(@PathVariable(value = "id") long orderId, @RequestBody String descriptionData) {
        orderService.updateOrder(orderId, descriptionData);
    }


    // --------
    @GetMapping(value = "/test", produces = "application/json")
    public ResponseEntity<OrderCustomResponse> testEndpoint() {
        OrderDTO order = orderService.getOrder(2L);

        OrderCustomResponse orderCustomResponse = new OrderCustomResponse();
        orderCustomResponse.setOrder(order);
        orderCustomResponse.setStatus(200);
        orderCustomResponse.setMessage("OK");
        orderCustomResponse.setSuccess(true);

//        return ResponseEntity.ok(orderCustomResponse);
        return ResponseEntity.status(HttpStatus.OK).body(orderCustomResponse);
    }
}
