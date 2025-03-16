package com.ecommerce.orderapplication.serviceimpl;

import com.ecommerce.orderapplication.dao.ProductDao;
import com.ecommerce.orderapplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final Logger log= LogManager.getLogger(ProductServiceImpl.class);
    @Override
    public List<Map<String, Object>> getAllProducts() throws Exception {
        try{
            return productDao.getAllProducts();
        }catch(Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void saveProduct(Map<String, Object> product) throws Exception {
        try{
            productDao.saveProduct(product);
        }catch(Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }
}
