package com.example.az.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ErrorMessages {
    private  String message ;
    private  String detaile;
    private  String status;
}
