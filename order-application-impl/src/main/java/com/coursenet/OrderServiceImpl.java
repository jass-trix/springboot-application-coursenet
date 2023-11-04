package com.coursenet;

import java.util.List;

import com.coursenet.model.Order;
import com.coursenet.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepositoryJPA orderRepository;

  @Override
  public void createNewOrder(String name, String user) {
    orderRepository.save(
        new Order(
            name,
            "order made by " + user
        )
    );
    // add data to table order_user
    // reduce stock from table product
  }

  @Override
  public List<OrderDTO> getOrderList() {
    List<Order> orders = orderRepository.findAll();
    // convert Order to OrderDTO
    List<OrderDTO> orderDTOs = orders.stream().map(order -> new OrderDTO(order.getName(), order.getDescription())).toList();
    return orderDTOs;
  }

  @Override
  public OrderDTO getOrder(Long orderId) {
    Order order = orderRepository.findById(orderId).orElse(null);
    if (order == null) {
      return null;
    }
    return new OrderDTO(
        order.getName(),
        order.getDescription()
    );
  }
}
