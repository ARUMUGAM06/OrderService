package com.ecommerce.orderapplication.daoimpl;

import com.ecommerce.orderapplication.dao.ProductDao;
import com.ecommerce.orderapplication.query.ProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {
    private final ProductQuery productQuery;
    private final DataSource ecommerceDataSource;
    @Override
    public List<Map<String, Object>> getAllProducts() throws Exception {
        return new JdbcTemplate(ecommerceDataSource).queryForList(productQuery.getAllProducts());
    }

    @Override
    public void saveProduct(Map<String, Object> product) throws Exception {
        new NamedParameterJdbcTemplate(ecommerceDataSource)
                .batchUpdate(productQuery.saveProduct(), SqlParameterSourceUtils.createBatch(product));
    }
}
