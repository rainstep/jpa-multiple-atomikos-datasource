package com.example.jpamultipleatomikosdatasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryA"
        , basePackages = "com.example.jpamultipleatomikosdatasource.dao.a"
        , transactionManagerRef = "transactionManager"
)
public class DataSourceAConfig {


    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-a")
    public DataSource dataSourceA() {
        return new AtomikosDataSourceBean();
    }


//    @Primary
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryA(EntityManagerFactoryBuilder builder) {
//        return builder.dataSource(dataSourceA())
//                .persistenceUnit("datasource-a")
//                .jta(true)
//                .packages("com.example.jpamultipleatomikosdatasource.model.a")
//                .build();
//    }


    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryA(JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJtaDataSource(dataSourceA());
        factoryBean.setPackagesToScan("com.example.jpamultipleatomikosdatasource.model.a");
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        return factoryBean;
    }


}
