package com.nurdinaffandidev.springCore;

import com.nurdinaffandidev.springCore.models.Account;
import com.nurdinaffandidev.springCore.models.User;
import com.nurdinaffandidev.springCore.repository.AccountRepository;
import com.nurdinaffandidev.springCore.repository.UserAccountRepository;
import com.nurdinaffandidev.springCore.repository.UserRepository;
import com.nurdinaffandidev.springCore.service.Teller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class TellerApp {
    private static void printUsers(User... users) {
        System.out.println("\nUsers:\n=======================================");
        Arrays.stream(users).sequential().forEach(System.out::println);
    }

    private static void printAccounts(Account... accounts) {
        System.out.println("\nsAccounts:\n=======================================");
        Arrays.stream(accounts).sequential().forEach(System.out::println);
    }

    public static void main( String[] args ) {
        // Application Context
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // Beans Mapping
        UserRepository userRepository = context.getBean(UserRepository.class);
        AccountRepository accountRepository = context.getBean(AccountRepository.class);
        UserAccountRepository userAccountRepository = context.getBean(UserAccountRepository.class);
        Teller teller = context.getBean(Teller.class, accountRepository, accountRepository, userAccountRepository);

        User user1 = context.getBean(User.class, "user1", 1);
        User user2 = context.getBean(User.class, "user2", 2);
        User user3 = context.getBean(User.class, "user3", 3);

        Account account1 = context.getBean(Account.class, new BigDecimal(1000), 99991001);
        Account account2 = context.getBean(Account.class, new BigDecimal(2000), 99992001);
        Account account3 = context.getBean(Account.class, new BigDecimal(3000), 99993001);

        // Check Beans Mapping
//        printUsers(user1, user2, user3);
//        printAccounts(account1, account2, account3, account4);
//        System.out.println("\nUser Repository: " + userRepository);
//        System.out.println("Account Repository: " + accountRepository);
//        System.out.println("UserAccount Repository: " + userAccountRepository);
//        System.out.println("Teller: " + teller);

        // Add objects to Repositories
        teller.addAccount(account1);
        teller.addUser(user1);
        teller.addUserAccount(user2, account2);
        teller.addUserAccount(user3, account3);

        // Check add methods
//        System.out.println("\nUser Repository: " + userRepository);
//        System.out.println("Account Repository: " + accountRepository);
//        System.out.println("UserAccount Repository: " + userAccountRepository);

        // Remove objects from Repositories
        teller.removeUser(user1);
        teller.removeAccount(account1);
        teller.removeUserAccount(user2, account2);

        // Check remove methods
//        System.out.println("\nUser Repository: " + userRepository);
//        System.out.println("Account Repository: " + accountRepository);
//        System.out.println("UserAccount Repository: " + userAccountRepository);
    }
}
