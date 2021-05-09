package com.dw.dw.configuration;

import com.dw.dw.model.urban.InstitutieInvatamantUrban;
import com.dw.dw.repository.centralizat.InstitutieInvatamantRepository;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.dw.dw.repository.urban",
//        repositoryBaseClass = InstitutieInvatamantRepository.class,
        entityManagerFactoryRef = "urbanEntityManagerFactory",
        transactionManagerRef= "urbanTransactionManager")
public class UrbanConfig {
    @Bean
    @ConfigurationProperties(prefix="spring.db2.datasource")
    public DataSourceProperties urbanDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.db2.datasource.configuration")
    public DataSource urbanDataSource() {
        return urbanDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Bean(name = "urbanEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean urbanEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(urbanDataSource())
                .packages(InstitutieInvatamantUrban.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager urbanTransactionManager(
            final @Qualifier("urbanEntityManagerFactory") LocalContainerEntityManagerFactoryBean urbanEntityManagerFactory) {
        return new JpaTransactionManager(urbanEntityManagerFactory.getObject());
    }


}
