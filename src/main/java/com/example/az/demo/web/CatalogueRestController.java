package com.example.az.demo.web;

import com.example.az.demo.dao.ProductRepo;
import com.example.az.demo.entities.Product;
import com.example.az.demo.exception.ErrorMessages;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@RestController
public class CatalogueRestController {

    private ProductRepo productRepo;

    public CatalogueRestController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

  @GetMapping(path = "/photoProduct/{id}" , produces = MediaType.IMAGE_PNG_VALUE)
  public  byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
         System.out.println( "*** id:"+id);
         Product product=productRepo.findById(id).get();
         System.out.println( "*** user.home"+System.getProperty("user.home"));
      return   Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/appEcom/"+product.getImage()));

  }

    @ExceptionHandler(java.util.NoSuchElementException.class)
    public ResponseEntity<ErrorMessages> noSuchElementException(Exception e)
    {
        ErrorMessages errorMessages = new ErrorMessages("ID doesn't exist", e.getMessage()," NOT_FOUND ");
        return   new ResponseEntity<ErrorMessages>(errorMessages, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(java.nio.file.NoSuchFileException.class)
    public ResponseEntity<ErrorMessages> NoSuchFileException(Exception e)
    {
        ErrorMessages errorMessages = new ErrorMessages("File  Not Found ", e.getMessage()," NOT_FOUND ");
        return   new ResponseEntity<ErrorMessages>(errorMessages, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


}
