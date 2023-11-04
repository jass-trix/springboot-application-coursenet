package com.coursenet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
  @Id
  @SequenceGenerator(name = "order_seq", sequenceName = "orders_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
  private Long id;

  @Column(name="name")
  private String name;
  private String description;

  public Order() {
  }

  public Order(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Order(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name + " " + id;
  }

  public void setName(String name) {
    this.name = "Bapak/Ibu" + name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
