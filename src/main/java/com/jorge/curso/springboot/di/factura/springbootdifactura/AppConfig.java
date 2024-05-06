package com.jorge.curso.springboot.di.factura.springbootdifactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jorge.curso.springboot.di.factura.springbootdifactura.models.Item;
import com.jorge.curso.springboot.di.factura.springbootdifactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

  @Bean
  List<Item> itemsInvoice() {
    return Arrays.asList(
        new Item(new Product("Camara Sony", 800), 2),
        new Item(new Product("Bicicleta", 1200), 4));
  }

}
