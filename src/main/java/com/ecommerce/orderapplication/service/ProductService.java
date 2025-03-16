package com.ecommerce.orderapplication.service;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Map<String, Object>> getAllProducts() throws Exception;

    void saveProduct(Map<String, Object> product) throws Exception;
}
