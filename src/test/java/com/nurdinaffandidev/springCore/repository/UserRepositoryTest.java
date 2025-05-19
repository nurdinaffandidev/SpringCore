package com.nurdinaffandidev.springCore.repository;

import com.nurdinaffandidev.springCore.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    // Test Variables
    UserRepository sut;
    User user1;
    User user2;

    @BeforeEach
    public void setup() {
        sut = new UserRepository(new HashMap<>());
        user1 = new User("user1", 1);
        user2 = new User("user2", 2);
    }

    @Test
    public void test_addUser() {
        // Arrange
        // Act
        sut.addUser(user1);
        // Assert
        assertEquals(1, sut.getUsers().size());
    }

    @Test
    public void test_removeUser() {
        // Arrange
        sut.addUser(user1);
        sut.addUser(user2);
        // Act
        sut.removeUser(user1);
        System.out.println(sut.getUsers());
        // Assert
        assertEquals(1, sut.getUsers().size());
        assertTrue(sut.getUsers().containsKey(user2.getId()));
        assertFalse(sut.getUsers().containsKey(user1.getId()));
    }
}
