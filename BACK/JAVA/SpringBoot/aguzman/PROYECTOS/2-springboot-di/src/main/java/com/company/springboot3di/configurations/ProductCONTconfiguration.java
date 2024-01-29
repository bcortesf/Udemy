package com.company.springboot3di.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.company.springboot3di.repositories.IProductRepository;
import com.company.springboot3di.repositories.ProductJSON1RepositoryImpl;
import com.company.springboot3di.repositories.ProductJSON2RepositoryImpl;
import com.company.springboot3di.repositories.ProductJSON3RepositoryImpl;


@PropertySource("classpath:invoice.properties")
@Configuration
public class ProductCONTconfiguration {

    @Bean
    IProductRepository productJSON1RepositoryImpl() {
        return new ProductJSON1RepositoryImpl();
    }
    //-----------------------------------------------

    //->   src\main\resources\json\product.json
    @Value(value = "#{'classpath:json/product.json'}")
    private Resource resource; //->Lectura de archivo JSON

    @Bean
    IProductRepository productJSON3RepositoryImpl() {
        return new ProductJSON3RepositoryImpl(resource);
    }

}




/*
@Primary
@Qualifier(value = "beanProductJSONRepositoryImpl")
@Bean(value = "beanProductJSONRepositoryImpl")
@Bean
IProductRepository productJSONRepositoryImpl() {
    return new ProductJSONRepositoryImpl();
}
 */