package com.coursenet;

import java.util.List;

import com.coursenet.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/orders", produces = "application/json")
public class OrderControllerImpl implements OrderController {

  @Autowired
  OrderService orderService;


  // /orders
  @PostMapping(value = "", consumes = "application/json")
  @Override
  public @ResponseBody void createNewOrder(@RequestBody OrderDTO orderDTO) {
    orderService.createNewOrder(orderDTO.getName(), orderDTO.getDescription());
  }

  // /orders
  @GetMapping(value = "")
  @Override
  public @ResponseBody List<OrderDTO> getOrderList() {
    return orderService.getOrderList();
  }


  // /orders/1
  @GetMapping(value = "/{id}")
  @Override
  public @ResponseBody OrderDTO getOrder(@PathVariable(value = "id") Long orderId) {
    return orderService.getOrder(orderId);
  }

  // /orders/1
  @DeleteMapping(value = "/{id}")
  @Override
  public @ResponseBody void deleteOrder(@PathVariable(value = "id") Long orderId) {
    orderService.deleteOrder(orderId);
  }


  // /orders/1
  @PutMapping(value = "/{id}", consumes = "application/json")
  @Override
  public @ResponseBody void updateOrder(@PathVariable(value = "id") long orderId, @RequestBody OrderDTO orderDTO) {
    orderService.updateOrder(orderId, orderDTO);
  }

  // /orders/1
  @PatchMapping(value = "/{id}", consumes = "application/json")
  @Override
  public @ResponseBody void updateOrder(@PathVariable(value = "id") long orderId, @RequestBody String descriptionData) {
    orderService.updateOrder(orderId, descriptionData);
  }
}
