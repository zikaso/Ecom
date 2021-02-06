package com.example.az.demo.dao;


import com.example.az.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProductRepo extends JpaRepository<Product,Long> {

     @RestResource( path = "/activeProducts")
     public List<Product> findByActiveTrue();
    @RestResource( path = "/ProductsByKeyWord")
     public List<Product> findByNameContains( @Param("mc") String mc);

}
