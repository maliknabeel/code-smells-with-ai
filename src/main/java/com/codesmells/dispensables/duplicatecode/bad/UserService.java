package com.codesmells.dispensables.duplicatecode.bad;

import org.springframework.stereotype.Service;
import java.util.List;

/**
 * BAD EXAMPLE: Duplicate Code Smell
 * 
 * <h2>What is Duplicate Code?</h2>
 * The same or very similar code appearing in multiple places.
 * This is one of the most common and harmful code smells.
 * 
 * <h2>Problems with this Code:</h2>
 * <ul>
 *   <li>Validation logic is duplicated 3 times</li>
 *   <li>If we need to change validation, must update 3 places</li>
 *   <li>Risk of inconsistencies - easy to update one and forget others</li>
 *   <li>More code to maintain and test</li>
 *   <li>Violates DRY (Don't Repeat Yourself) principle</li>
 * </ul>
 * 
 * <h2>How to Refactor:</h2>
 * Use <b>Extract Method</b> to pull out the duplicated code into a shared method.
 * 
 * @see com.codesmells.dispensables.duplicatecode.good for refactored version
 */
@Service
public class UserService {
    
    /**
     * BAD: Duplicated validation code
     */
    public void createUser(String username, String email, String password) {
        // Duplicate validation #1
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (username.length() < 3 || username.length() > 20) {
            throw new IllegalArgumentException("Username must be between 3 and 20 characters");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
        
        System.out.println("Creating user: " + username);
    }
    
    /**
     * BAD: Same validation code duplicated again
     */
    public void updateUser(String username, String email, String password) {
        // Duplicate validation #2
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (username.length() < 3 || username.length() > 20) {
            throw new IllegalArgumentException("Username must be between 3 and 20 characters");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
        
        System.out.println("Updating user: " + username);
    }
    
    /**
     * BAD: Same validation code duplicated yet again
     */
    public void validateUserInput(String username, String email, String password) {
        // Duplicate validation #3
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (username.length() < 3 || username.length() > 20) {
            throw new IllegalArgumentException("Username must be between 3 and 20 characters");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
    }
}
