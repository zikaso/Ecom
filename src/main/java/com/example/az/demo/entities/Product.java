package com.example.az.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Product {
     @Id @GeneratedValue
     private  Long id;
     private  String name;
     private  String description;
     private  double price;
     private  String image;
     private  boolean active;
     private  boolean promotion;
     private  boolean available ;
     @ManyToOne()
     private Category category;

     public Long getIdProduct() {
          return id;
     }
}
