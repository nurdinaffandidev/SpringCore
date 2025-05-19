package com.nurdinaffandidev.springCore;

import com.nurdinaffandidev.springCore.models.Address;
import com.nurdinaffandidev.springCore.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class SpringConfiguration {
    // Mappings
    @Bean // w/o @Bean annotation, Spring will throw an exception as it's not able to identify class to instantiate
    @Scope("prototype")
    public User userBean() {
        return new User();
    }

    @Bean
    @Scope("prototype")
    public User userBean(String name, int age, Address address) {
        return new User(name, age, address);
    }

    @Bean
    @Scope("prototype")
    public Address addressBean() {
        return new Address();
    }

    @Bean
    @Scope("prototype")
    public Address addressBean(String city, String country) {
        return new Address(city, country);
    }

    /*
    - simpler way to instantiate multiple objects of different class is to annotate class with @Compnonent annotation
	- see com.nurdinaffandidev.springCore_annotations
	- ensure SpringConfig scans every other class using @ComponentScan annotation with base package in param

	- do take note defining @Bean in config class is commonly done if creating a class that you imported from external framework/classes,
	  as you cannot amend imported external classes as it is read-only
	- Eg. Persistence class in JPA
     */

    //Sample Beans when working with JPA:
//	@Bean
//	public EntityManagerFactory entityManagerFactory() {
//		return Persistence.createEntityManagerFactory("myPersistence.xml");
//	}
//
//	@Bean
//	public EntityManager entityManger(EntityManagerFactory emf) {
//		return emf.createEntityManager();
//	}


}
