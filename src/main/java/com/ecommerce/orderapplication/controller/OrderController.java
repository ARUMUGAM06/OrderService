package com.ecommerce.orderapplication.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    Logger logger= LogManager.getLogger(OrderController.class);
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        try {
            logger.info("hello world");
            return ResponseEntity.ok("hello world");
        }catch (Exception e){
            logger.error("error in hello world",e);
            return ResponseEntity.internalServerError().body("error in hello world");
        }
    }
}
