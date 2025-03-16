package com.ecommerce.orderapplication.dao;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    List<Map<String, Object>> getAllProducts() throws Exception;

    void saveProduct(Map<String, Object> product) throws Exception;
}
