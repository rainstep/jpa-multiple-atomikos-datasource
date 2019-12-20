package com.example.jpamultipleatomikosdatasource;


import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@SpringBootApplication
public class JpaMultipleAtomikosDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaMultipleAtomikosDatasourceApplication.class, args);
    }

    @Bean
    public JtaTransactionManager transactionManager() throws SystemException {
        UserTransaction userTransaction = new UserTransactionImp();
        userTransaction.setTransactionTimeout(300);
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(true);
        userTransactionManager.setTransactionTimeout(300);
        userTransactionManager.setStartupTransactionService(true);
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager(userTransaction, userTransactionManager);
        return jtaTransactionManager;
    }
}
