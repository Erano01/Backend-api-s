package me.erano.backend.config;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import me.erano.backend.entity.Product;
import me.erano.backend.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {


	
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

        // disable HTTP methods for Product: PUT, POST, DELETE and PATCH
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        // disable HTTP methods for ProductCategory: PUT, POST, DELETE and PATCH
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
    
    
    //http://localhost:8080/api/product-category
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer(EntityManager entityManager) {
       return RepositoryRestConfigurer.withConfig(config -> {
          config.exposeIdsFor(entityManager.getMetamodel().getEntities()
                .stream().map(Type::getJavaType).toArray(Class[]::new));
       });
       //her bir entity model configurasyonu için jsonda id göster
    }
    
    
}