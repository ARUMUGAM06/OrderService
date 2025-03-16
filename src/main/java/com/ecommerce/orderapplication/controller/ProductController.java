package com.ecommerce.orderapplication.controller;

import com.ecommerce.orderapplication.common.ApiResponse;
import com.ecommerce.orderapplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity<ApiResponse> getProduct() {
        try {
            List<Map<String, Object>> productList = productService.getAllProducts();
            return ResponseEntity.ok(new ApiResponse("Data Received Succesfully",
                    productList.isEmpty()?"No Products Found":productList));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse("Error in getting data", e.getMessage()));
        }
    }

    @PostMapping("save")
    public ResponseEntity<ApiResponse> saveProduct(@RequestBody Map<String, Object> product){
        try {
            productService.saveProduct(product);
            return ResponseEntity.ok(new ApiResponse("Product Saved Succesfully", ""));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse("Error in saving product", e.getMessage()));
        }
    }
}
