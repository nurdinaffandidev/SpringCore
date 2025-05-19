package com.nurdinaffandidev.springCore.repository;

import com.nurdinaffandidev.springCore.models.Account;
import com.nurdinaffandidev.springCore.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAccountRepositoryTest {
    // Testing Variables
    UserAccountRepository sut;
    User user1;
    User user2;
    Account account1;
    Account account2;

    @BeforeEach
    public void setup() {
        sut = new UserAccountRepository(new HashMap<>());
        user1 = new User("user1", 1);
        user2 = new User("user2", 2);
        account1 = new Account(new BigDecimal(100), 1);
        account2 = new Account(new BigDecimal(200), 2);
    }

    @Test
    public void test_addUserAndAccount() {
        // Arrange
        // Act
        sut.addUserAndAccount(user1, account1);
        // Assert
        assertEquals(1, sut.getUserAccounts().size());
    }

    @Test
    public void test_removeUserAndAccount() {
        // Arrange
        sut.addUserAndAccount(user1, account1);
        sut.addUserAndAccount(user2, account2);
        // Act
        sut.removeUser(user1);
        sut.removeAccount(account2);
        // Assert
        assertEquals(0, sut.getUserAccounts().size());
    }
}
