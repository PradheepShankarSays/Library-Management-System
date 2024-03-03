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
        userRepository.clearUsers();
    }

    @Test
    public void testAddingUsers() {
        // Adding a new user
        User user1 = new User("Mike Smith", "mike.smith@example.com", "password123", "1122334455", "789 Pine St", "03-03-1990", "Male", UserRole.ADMIN);
        assertTrue("User1 should be added successfully", userRepository.addUser(user1));

        // Attempting to add a user with the same email ID should fail
        User user2 = new User("Smith Mike", "mike.smith@example.com", "PPSSPP123123", "1234567890", "123 Yes St", "07-09-2000", "Male", UserRole.STUDENT);
        assertFalse("User2 with an existing email should not be added", userRepository.addUser(user2));

        // Adding another new user with a unique email
        User user3 = new User("Sam Wilson", "sam.wilson@gmail.com", "sam123", "1122334455", "789 Pine St", "1993-03-03", "Other", UserRole.LIBRARIAN);
        assertTrue("User3 should be added successfully", userRepository.addUser(user3));
    }
}
