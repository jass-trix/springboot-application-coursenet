package com.coursenet;

import java.util.List;

import com.coursenet.model.Order;

public interface OrderRepository {
  Order getOrder(Long orderId);

  List<Order> getOrders();

  void insertOrder(Order order);

  void updateOrder(Order order);

  void deleteOrder(Long orderId);
}
