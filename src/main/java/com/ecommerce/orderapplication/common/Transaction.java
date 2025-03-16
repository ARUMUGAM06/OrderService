package com.ecommerce.orderapplication.common;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class Transaction {
    private DataSourceTransactionManager dataSourceTransactionManager;
    private TransactionStatus transactionStatus;
    private DefaultTransactionDefinition defaultTransactionDefinition;
    public Transaction(DataSource dataSource) {
        dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        defaultTransactionDefinition = new DefaultTransactionDefinition();
        transactionStatus = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
    }

    public void commit() {
        dataSourceTransactionManager.commit(transactionStatus);
        transactionStatus = null;
        defaultTransactionDefinition = null;
        dataSourceTransactionManager = null;
    }

    public void rollback() {
        dataSourceTransactionManager.rollback(transactionStatus);
        transactionStatus = null;
        defaultTransactionDefinition = null;
        dataSourceTransactionManager = null;
    }
}
