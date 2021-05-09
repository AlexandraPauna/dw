package com.dw.dw.configuration;

import com.dw.dw.model.centralizat.InstitutieInvatamant;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.dw.dw.repository.centralizat",
        entityManagerFactoryRef = "centralizatEntityManagerFactory",
        transactionManagerRef= "centralizatTransactionManager"
)
public class CentralizatConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSourceProperties memberDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.configuration")
    public DataSource memberDataSource() {
        return memberDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "centralizatEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean centralizatEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(memberDataSource())
                .packages(InstitutieInvatamant.class)
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager centralizatTransactionManager(
            final @Qualifier("centralizatEntityManagerFactory") LocalContainerEntityManagerFactoryBean centralizatEntityManagerFactory) {
        return new JpaTransactionManager(centralizatEntityManagerFactory.getObject());
    }
}
