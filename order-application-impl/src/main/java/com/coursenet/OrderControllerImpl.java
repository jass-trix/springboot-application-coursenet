package com.coursenet;

import java.util.List;

import com.coursenet.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderControllerImpl implements OrderController {

  @Autowired
  OrderService orderService;

  @Override
  public void createNewOrder(String name, String user) {
    orderService.createNewOrder(name, user);
  }

  @Override
  public List<OrderDTO> getOrderList() {
    return orderService.getOrderList();
  }

  @Override
  public OrderDTO getOrder(Long orderId) {
    return orderService.getOrder(orderId);
  }
}
