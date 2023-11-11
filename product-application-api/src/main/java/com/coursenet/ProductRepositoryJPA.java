package com.coursenet;

import com.coursenet.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
