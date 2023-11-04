package com.coursenet;

import java.util.ArrayList;
import java.util.List;

import com.coursenet.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderRepositoryImpl implements OrderRepository {

  @Autowired
  @Qualifier("postgreSQLDatabaseConnection")
  private DatabaseConnection databaseConnection;

  @Override
  public Order getOrder(Long orderId) {
    databaseConnection.select();
    return new Order(orderId, "Order 1", "Order 1 description");
  }

  @Override
  public List<Order> getOrders() {
    databaseConnection.select();
    List<Order> orders = new ArrayList<>();
    orders.add(new Order(
        1L,
        "Order 1",
        "Order 1 description"
    ));

    orders.add(
        new Order(
            2L,
            "Order 2",
            "Order 2 description"
        )
    );
    return orders;
  }

  @Override
  public void insertOrder(Order order) {
      databaseConnection.insert();
  }

  @Override
  public void updateOrder(Order order) {
    databaseConnection.update();
  }

  @Override
  public void deleteOrder(Long orderId) {
    databaseConnection.delete();
  }
}
