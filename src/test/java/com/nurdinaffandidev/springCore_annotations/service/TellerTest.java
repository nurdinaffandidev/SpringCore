package com.nurdinaffandidev.springCore_annotations.service;

import com.nurdinaffandidev.springCore_annotations.models.Account;
import com.nurdinaffandidev.springCore_annotations.models.User;
import com.nurdinaffandidev.springCore_annotations.repository.AccountRepository;
import com.nurdinaffandidev.springCore_annotations.repository.UserAccountRepository;
import com.nurdinaffandidev.springCore_annotations.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TellerTest {
    // Testing variables
    Teller sut;
    User user1;
    User user2;
    Account account1;
    Account account2;
    @Mock
    AccountRepository accountRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    UserAccountRepository userAccountRepository;

    @BeforeEach
    public void setup() {
        sut = new Teller(accountRepository, userRepository, userAccountRepository);
        user1 = new User("user1", 1);
        user2 = new User("user2", 2);
        account1 = new Account(new BigDecimal(100), 1);
        account2 = new Account(new BigDecimal(200), 2);
    }

    @Test
    public void test_addUser() {
        // Arrange
        // Act
        sut.addUser(user1);
        // Assert
        verify(userRepository, times(1)).addUser(any());
    }

    @Test
    public void test_removeUser() {
        // Arrange
        // Act
        sut.removeUser(user1);
        // Assert
        verify(userRepository, times(1)).removeUser(any());
    }

    @Test
    public void test_addAccount() {
        // Arrange
        // Act
        sut.addAccount(account1);
        // Assert
        verify(accountRepository, times(1)).addAccount(any());
    }

    @Test
    public void test_removeAccount() {
        // Arrange
        // Act
        sut.removeAccount(account1);
        // Assert
        verify(accountRepository, times(1)).removeAccount(any());
    }

    @Test
    public void test_addUserAccount() {
        // Arrange
        // Act
        sut.addUserAccount(user1, account1);
        // Assert
        verify(userAccountRepository, times(1)).addUserAndAccount(any(), any());
        verify(userRepository, times(1)).addUser(any());
        verify(accountRepository, times(1)).addAccount(any());
    }

    @Test
    public void test_removeUserAccount() {
        // Arrange
        // Act
        sut.removeUserAccount(user1, account1);
        // Assert
        verify(userAccountRepository, times(1)).removeUser(any());
        verify(userAccountRepository, times(1)).removeAccount(any());
        verify(userRepository, times(1)).removeUser(any());
        verify(accountRepository, times(1)).removeAccount(any());
    }
}
