package org.example.Registration.service;

import org.example.Registration.entity.User;
import org.example.Registration.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserName_UserFound() {
        User mockUser = new User(1, "Alice");
        when(userRepository.findById(1)).thenReturn(mockUser);

        String result = userService.getUserName(1);

        assertEquals("Alice", result);

        verify(userRepository).findById(1);
    }

    @Test
    void testGetUserName_UserNotFound() {
        // Arrange
        when(userRepository.findById(1)).thenReturn(null);

        String result = userService.getUserName(1);

        assertEquals("User not found", result);
        verify(userRepository).findById(1);
    }

    @Test
    void testSaveUser() {
        User newUser = new User(2, "Bob");

        userService.saveUser(newUser);

        verify(userRepository).save(newUser);
    }
}