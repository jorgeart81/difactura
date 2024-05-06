package com.jorge.curso.springboot.di.factura.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Invoice {

  @Autowired
  private Client client;

  @Value("${invoice.description}")
  private String description;

  @Autowired
  private List<Item> items;

  @PostConstruct
  public void init() {
    System.out.println("Creating the Invoice component");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Destroying the Invoice component");
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public int getTotal() {
    return items.stream()
        .map(item -> item.getAmount())
        .reduce(0, (sum, amount) -> sum + amount);
  }
}
