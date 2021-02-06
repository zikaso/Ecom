package com.example.az.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Category {
    @Id @GeneratedValue
    private   Long id;
    private  String name;
    private  String description;
    @OneToMany(mappedBy ="category" )
    private Collection <Product> products ;

    public Long getIdCategory() {
        return id;
    }
}
