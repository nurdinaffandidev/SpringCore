package com.nurdinaffandidev.springCore;

import com.nurdinaffandidev.springCore.models.Address;
import com.nurdinaffandidev.springCore.models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
    public static void main(String[] args) {
        //start Spring container
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class); //pass Spring Configuration class in param

        Address address2 = context.getBean(Address.class);
        Address address3 = context.getBean(Address.class, "Lion City", "Singapore");

        User user1 = context.getBean(User.class);
        User user2 = context.getBean(User.class, "user2", 22, address2);
        User user3 = context.getBean(User.class, "user3", 33, address3);

        // Check mapping
        System.out.println(address2);
        System.out.println(address3);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        //close container after using
        ((AbstractApplicationContext) context).close();
    }
}
