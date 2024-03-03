package com.university.library.action;

import com.university.library.model.users.User;
import com.university.library.model.users.UserRole;
import com.university.library.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserRegistrationTest {

    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = UserRepository.getInstance(); 
    }

    @Test
    public void testAddUser1() {
        User user1 = new User("Mike Smith", "mike.smith@example.com", "password123", "1122334455", "789 Pine St", "03-03-1990", "Male", UserRole.ADMIN);
        assertTrue(userRepository.addUser(user1));

        // User with same email ID.
        User user2 = new User("Smith Mike", "mike.smith@example.com", "PPSSPP123123", "1234567890", "123 Yes St", "07-09-2000", "Male", UserRole.STUDENT);
        assertFalse(userRepository.addUser(user2));
    }

    @Test
    public void testAddUser2() {
        User user = new User("Pradheep", "pradheep.shankar@example.com", "PPSSPP123123", "1234567890", "123 Yes St", "07-09-2000", "Male", UserRole.STUDENT);
        assertTrue(userRepository.addUser(user));
    }

}
