package com.nurdinaffandidev.springCore.repository;

import com.nurdinaffandidev.springCore.models.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class AccountRepositoryTest {
    // Testing variables
    AccountRepository sut;
    Account account1;
    Account account2;

    @BeforeEach
    public void setup() {
        sut = new AccountRepository(new HashMap<>());
        account1 = new Account(new BigDecimal(100), 1);
        account2 = new Account(new BigDecimal(200), 2);
    }

    @Test
    public void test_addAccount() {
        // Arrange
        // Act
        sut.addAccount(account1);
        // Assert
        assertEquals(1, sut.getAccounts().size());
    }

    @Test
    public void test_removeAccount() {
        // Arrange
        sut.addAccount(account1);
        sut.addAccount(account2);
        // Act
        sut.removeAccount(account2);
        // Assert
        assertEquals(1, sut.getAccounts().size());
        assertFalse(sut.getAccounts().containsKey(account2));
    }
}
