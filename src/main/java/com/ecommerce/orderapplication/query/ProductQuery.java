package com.ecommerce.orderapplication.query;

import org.springframework.stereotype.Component;

@Component
public class ProductQuery {
    public String getAllProducts() {
        StringBuilder sb = new StringBuilder();
        sb.append("select productname,metal,catid from product");
        return sb.toString();
    }

    public String saveProduct() {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into product(productname,metal,catid) \n");
        sb.append("values(:productname,:metal,:catid)");
        return sb.toString();
    }
}
