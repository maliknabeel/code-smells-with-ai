package com.codesmells.dispensables.duplicatecode.good;

import org.springframework.stereotype.Service;

/**
 * GOOD EXAMPLE: Refactored to Eliminate Duplication
 * 
 * <h2>Refactoring Applied: Extract Method</h2>
 * Extracted the duplicated validation logic into separate, reusable methods.
 * 
 * <h2>Benefits of this Refactoring:</h2>
 * <ul>
 *   <li>Validation logic is in one place</li>
 *   <li>Changes only need to be made once</li>
 *   <li>Consistent validation everywhere</li>
 *   <li>Easier to test - can test validation independently</li>
 *   <li>Follows DRY principle</li>
 * </ul>
 * 
 * <h2>Key Improvements:</h2>
 * <ul>
 *   <li>Single source of truth for validation rules</li>
 *   <li>Methods are small and focused</li>
 *   <li>Can reuse validation in new methods</li>
 * </ul>
 */
@Service
public class UserService {
    
    /**
     * GOOD: Uses extracted validation method
     */
    public void createUser(String username, String email, String password) {
        validateUserInput(username, email, password);
        System.out.println("Creating user: " + username);
    }
    
    /**
     * GOOD: Uses the same extracted validation method
     */
    public void updateUser(String username, String email, String password) {
        validateUserInput(username, email, password);
        System.out.println("Updating user: " + username);
    }
    
    /**
     * GOOD: Centralized validation method
     */
    public void validateUserInput(String username, String email, String password) {
        validateUsername(username);
        validateEmail(email);
        validatePassword(password);
    }
    
    /**
     * Validates username according to business rules
     */
    private void validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (username.length() < 3 || username.length() > 20) {
            throw new IllegalArgumentException("Username must be between 3 and 20 characters");
        }
    }
    
    /**
     * Validates email according to business rules
     */
    private void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
    
    /**
     * Validates password according to business rules
     */
    private void validatePassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
    }
}
