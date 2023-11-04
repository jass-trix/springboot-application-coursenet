package com.coursenet;

import com.coursenet.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryJPA extends JpaRepository<Order, Long> {
  Order findByName(String name);
  Order findByDescription(String description);
}
