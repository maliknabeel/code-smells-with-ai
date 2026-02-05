package com.codesmells.bloaters.largeclass.bad;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;

/**
 * BAD EXAMPLE: Large Class Code Smell
 * 
 * <h2>What is Large Class?</h2>
 * A Large Class tries to do too much and has too many responsibilities.
 * It typically has numerous fields, methods, and lines of code.
 * 
 * <h2>Problems with this Code:</h2>
 * <ul>
 *   <li>This class handles user management, authentication, authorization, and notifications</li>
 *   <li>Over 30 methods covering different responsibilities</li>
 *   <li>Many instance variables for different purposes</li>
 *   <li>Violates Single Responsibility Principle severely</li>
 *   <li>Difficult to understand and maintain</li>
 *   <li>Hard to test - would require mocking many dependencies</li>
 *   <li>Changes to one feature might break unrelated features</li>
 * </ul>
 * 
 * <h2>Warning Signs:</h2>
 * <ul>
 *   <li>Class has more than 200-300 lines</li>
 *   <li>More than 10 fields</li>
 *   <li>More than 15-20 methods</li>
 *   <li>Difficult to name the class precisely</li>
 *   <li>Many unrelated methods</li>
 * </ul>
 * 
 * <h2>How to Refactor:</h2>
 * Use <b>Extract Class</b> refactoring to split this into multiple focused classes:
 * - UserRepository for data access
 * - AuthenticationService for login/logout
 * - AuthorizationService for permissions
 * - NotificationService for emails/SMS
 * 
 * @see com.codesmells.bloaters.largeclass.good package for refactored version
 */
@Service
public class UserManager {
    
    // Fields for user data management
    private Map<String, User> users = new HashMap<>();
    private Map<String, List<String>> userRoles = new HashMap<>();
    private Map<String, String> userPasswords = new HashMap<>();
    
    // Fields for authentication
    private Map<String, String> activeSessions = new HashMap<>();
    private Map<String, LocalDateTime> sessionExpirations = new HashMap<>();
    private int maxLoginAttempts = 3;
    private Map<String, Integer> loginAttempts = new HashMap<>();
    
    // Fields for notifications
    private String emailServer = "smtp.example.com";
    private String smsGateway = "sms.example.com";
    private List<String> adminEmails = new ArrayList<>();
    
    // User Management Methods
    public void createUser(String userId, String name, String email, String password) {
        User user = new User(userId, name, email);
        users.put(userId, user);
        userPasswords.put(userId, hashPassword(password));
        userRoles.put(userId, new ArrayList<>());
        sendWelcomeEmail(email);
    }
    
    public User getUser(String userId) {
        return users.get(userId);
    }
    
    public void updateUser(String userId, String name, String email) {
        User user = users.get(userId);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            sendProfileUpdateNotification(email);
        }
    }
    
    public void deleteUser(String userId) {
        users.remove(userId);
        userPasswords.remove(userId);
        userRoles.remove(userId);
        logoutUser(userId);
        notifyAdminsOfDeletion(userId);
    }
    
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
    
    // Authentication Methods
    public String login(String userId, String password) {
        if (!users.containsKey(userId)) {
            return null;
        }
        
        if (isAccountLocked(userId)) {
            sendAccountLockedEmail(users.get(userId).getEmail());
            return null;
        }
        
        if (!verifyPassword(userId, password)) {
            incrementLoginAttempts(userId);
            if (loginAttempts.get(userId) >= maxLoginAttempts) {
                lockAccount(userId);
                sendAccountLockedEmail(users.get(userId).getEmail());
            }
            return null;
        }
        
        resetLoginAttempts(userId);
        String sessionId = generateSessionId();
        activeSessions.put(sessionId, userId);
        sessionExpirations.put(sessionId, LocalDateTime.now().plusHours(2));
        sendLoginNotification(users.get(userId).getEmail());
        return sessionId;
    }
    
    public void logout(String sessionId) {
        String userId = activeSessions.get(sessionId);
        if (userId != null) {
            activeSessions.remove(sessionId);
            sessionExpirations.remove(sessionId);
            sendLogoutNotification(users.get(userId).getEmail());
        }
    }
    
    public boolean isSessionValid(String sessionId) {
        if (!activeSessions.containsKey(sessionId)) {
            return false;
        }
        LocalDateTime expiration = sessionExpirations.get(sessionId);
        if (LocalDateTime.now().isAfter(expiration)) {
            logout(sessionId);
            return false;
        }
        return true;
    }
    
    private boolean verifyPassword(String userId, String password) {
        String hashedPassword = hashPassword(password);
        return hashedPassword.equals(userPasswords.get(userId));
    }
    
    private String hashPassword(String password) {
        return "hashed_" + password; // Simplified for example
    }
    
    private void incrementLoginAttempts(String userId) {
        loginAttempts.put(userId, loginAttempts.getOrDefault(userId, 0) + 1);
    }
    
    private void resetLoginAttempts(String userId) {
        loginAttempts.put(userId, 0);
    }
    
    private boolean isAccountLocked(String userId) {
        return loginAttempts.getOrDefault(userId, 0) >= maxLoginAttempts;
    }
    
    private void lockAccount(String userId) {
        // Account locking logic
    }
    
    private String generateSessionId() {
        return UUID.randomUUID().toString();
    }
    
    // Authorization Methods
    public void assignRole(String userId, String role) {
        List<String> roles = userRoles.get(userId);
        if (roles != null && !roles.contains(role)) {
            roles.add(role);
            sendRoleAssignmentNotification(users.get(userId).getEmail(), role);
        }
    }
    
    public void removeRole(String userId, String role) {
        List<String> roles = userRoles.get(userId);
        if (roles != null) {
            roles.remove(role);
            sendRoleRemovalNotification(users.get(userId).getEmail(), role);
        }
    }
    
    public boolean hasRole(String userId, String role) {
        List<String> roles = userRoles.get(userId);
        return roles != null && roles.contains(role);
    }
    
    public boolean hasPermission(String userId, String permission) {
        List<String> roles = userRoles.get(userId);
        if (roles == null) return false;
        
        // Check if any of user's roles grant this permission
        for (String role : roles) {
            if (roleHasPermission(role, permission)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean roleHasPermission(String role, String permission) {
        // Simplified permission checking
        return true;
    }
    
    // Notification Methods
    public void sendWelcomeEmail(String email) {
        System.out.println("Sending welcome email to: " + email);
        // Email sending logic
    }
    
    public void sendLoginNotification(String email) {
        System.out.println("Sending login notification to: " + email);
        // Email sending logic
    }
    
    public void sendLogoutNotification(String email) {
        System.out.println("Sending logout notification to: " + email);
        // Email sending logic
    }
    
    public void sendProfileUpdateNotification(String email) {
        System.out.println("Sending profile update notification to: " + email);
        // Email sending logic
    }
    
    public void sendAccountLockedEmail(String email) {
        System.out.println("Sending account locked email to: " + email);
        // Email sending logic
    }
    
    public void sendRoleAssignmentNotification(String email, String role) {
        System.out.println("Sending role assignment notification to: " + email);
        // Email sending logic
    }
    
    public void sendRoleRemovalNotification(String email, String role) {
        System.out.println("Sending role removal notification to: " + email);
        // Email sending logic
    }
    
    public void notifyAdminsOfDeletion(String userId) {
        for (String adminEmail : adminEmails) {
            System.out.println("Notifying admin: " + adminEmail + " about user deletion: " + userId);
        }
    }
    
    private void logoutUser(String userId) {
        // Find and remove all sessions for this user
        activeSessions.entrySet().removeIf(entry -> entry.getValue().equals(userId));
    }
    
    // Inner class
    public static class User {
        private String userId;
        private String name;
        private String email;
        
        public User(String userId, String name, String email) {
            this.userId = userId;
            this.name = name;
            this.email = email;
        }
        
        public String getUserId() { return userId; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public void setName(String name) { this.name = name; }
        public void setEmail(String email) { this.email = email; }
    }
}
