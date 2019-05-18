package com.example.jpamultipleatomikosdatasource.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryB"
        , basePackages = "com.example.jpamultipleatomikosdatasource.dao.b"
//        , transactionManagerRef = "transactionManager"
)
public class DataSourceBConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-b")
    public DataSource dataSourceB() {
        return new AtomikosDataSourceBean();
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryB(EntityManagerFactoryBuilder builder) {
//        return builder.dataSource(dataSourceB())
//                .persistenceUnit("datasource-a")
//                .jta(true)
//                .packages("com.example.jpamultipleatomikosdatasource.model.b")
//                .build();
//    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryB(JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJtaDataSource(dataSourceB());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("com.example.jpamultipleatomikosdatasource.model.b");
        return factoryBean;
    }


}
