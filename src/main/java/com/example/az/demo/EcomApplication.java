package com.example.az.demo;

import com.example.az.demo.dao.CategoryRepo;
import com.example.az.demo.dao.ProductRepo;
import com.example.az.demo.entities.Category;
import com.example.az.demo.entities.Product;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class EcomApplication implements CommandLineRunner {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;


    public static void main(String[] args) {
        SpringApplication.run(EcomApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        categoryRepo.save( new Category(null, "Laptop","Laptop HP",null));
        categoryRepo.save( new Category(null ,"phones","Laptop HP",null));
        categoryRepo.save( new Category(null ,"screen","Laptop DELL",null));

        Random random = new Random();
        categoryRepo.findAll().forEach(category -> {
            for (int i = 0; i < 10; i++) {
                Product product =  new Product();
                product.setName(RandomString.make(10).toString());
                product.setPrice(random.nextInt(1000)+300);
                product.setActive(random.nextBoolean());
                product.setPromotion(random.nextBoolean());
                product.setCategory(category);
                product.setImage("unknow.png");
                productRepo.save(product);
            }
        });
    }
}
