package com.coursenet;

import com.coursenet.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }


  @Autowired
  private OrderController orderController;

  @Override
  public void run(String... args) throws Exception {
    orderController.createNewOrder("Order 1", "Jasson");
    orderController.createNewOrder("Order 2", "Jasson");
    orderController.createNewOrder("Order 3", "Jasson");
    orderController.createNewOrder("Order 4", "Jasson");


    orderController.getOrderList().forEach(orderDTO -> {
      System.out.println(orderDTO.getName() + " " + orderDTO.getDescription());
    });

    OrderDTO findOrder = orderController.getOrder(1L);
    System.out.println(findOrder.getName() + " " + findOrder.getDescription());
  }

}