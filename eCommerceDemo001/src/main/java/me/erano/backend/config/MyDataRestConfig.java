package me.erano.backend.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import me.erano.backend.entity.Country;
import me.erano.backend.entity.Product;
import me.erano.backend.entity.ProductCategory;
import me.erano.backend.entity.State;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

	
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

        // disable HTTP methods  PUT, POST, DELETE and PATCH
        disableHttpMethods(Product.class,config, theUnsupportedActions);
        
        disableHttpMethods(ProductCategory.class,config, theUnsupportedActions);
    
        disableHttpMethods(Country.class, config, theUnsupportedActions);
        
        disableHttpMethods(State.class, config, theUnsupportedActions);
        
        
        //call an internal helper method
        exposeIds(config);
    
    
    }


	private void disableHttpMethods(Class theClass,RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
		config.getExposureConfiguration()
                .forDomainType(theClass)
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
    
    private void exposeIds(RepositoryRestConfiguration config) {

        // expose entity ids
        //

        // - get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // - get the entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // - expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
    
    
    
}