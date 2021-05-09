package com.dw.dw.configuration;

import com.dw.dw.model.rural.InstitutieInvatamantRural;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
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
@EnableJpaRepositories(basePackages = "com.dw.dw.repository.rural",
//        repositoryBaseClass = InstitutieInvatamantRepository.class,
        entityManagerFactoryRef = "ruralEntityManagerFactory",
        transactionManagerRef= "ruralTransactionManager")
public class RuralConfig {
    @Bean
    @ConfigurationProperties(prefix="spring.db3.datasource")
    public DataSourceProperties ruralDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.db3.datasource.configuration")
    public DataSource ruralDataSource() {
        return ruralDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Bean(name = "ruralEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ruralEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ruralDataSource())
                .packages(InstitutieInvatamantRural.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager ruralTransactionManager(
            final @Qualifier("ruralEntityManagerFactory") LocalContainerEntityManagerFactoryBean ruralEntityManagerFactory) {
        return new JpaTransactionManager(ruralEntityManagerFactory.getObject());
    }


}
