package com.codesmells.bloaters.largeclass.good;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;

/**
 * GOOD EXAMPLE: Extracted Authentication Service
 * 
 * <h2>Responsibility: User Authentication</h2>
 * This class handles login, logout, session management, and password verification.
 * 
 * <h2>Benefits:</h2>
 * <ul>
 *   <li>Focused on authentication concerns only</li>
 *   <li>Easy to test authentication logic in isolation</li>
 *   <li>Can be enhanced with more sophisticated authentication without affecting other services</li>
 *   <li>Security concerns are localized to this service</li>
 * </ul>
 */
@Service
public class AuthenticationService {
    
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    
    private Map<String, String> userPasswords = new HashMap<>();
    private Map<String, String> activeSessions = new HashMap<>();
    private Map<String, LocalDateTime> sessionExpirations = new HashMap<>();
    private Map<String, Integer> loginAttempts = new HashMap<>();
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    
    public AuthenticationService(UserRepository userRepository, 
                                NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }
    
    public void registerPassword(String userId, String password) {
        userPasswords.put(userId, hashPassword(password));
    }
    
    public String login(String userId, String password) {
        User user = userRepository.findById(userId);
        if (user == null) {
            return null;
        }
        
        if (isAccountLocked(userId)) {
            notificationService.sendAccountLockedEmail(user.getEmail());
            return null;
        }
        
        if (!verifyPassword(userId, password)) {
            handleFailedLogin(userId, user.getEmail());
            return null;
        }
        
        return handleSuccessfulLogin(userId, user.getEmail());
    }
    
    public void logout(String sessionId) {
        String userId = activeSessions.get(sessionId);
        if (userId != null) {
            User user = userRepository.findById(userId);
            activeSessions.remove(sessionId);
            sessionExpirations.remove(sessionId);
            if (user != null) {
                notificationService.sendLogoutNotification(user.getEmail());
            }
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
    
    public void removeUserSessions(String userId) {
        activeSessions.entrySet().removeIf(entry -> entry.getValue().equals(userId));
    }
    
    private boolean verifyPassword(String userId, String password) {
        String hashedPassword = hashPassword(password);
        return hashedPassword.equals(userPasswords.get(userId));
    }
    
    private String hashPassword(String password) {
        return "hashed_" + password; // Simplified for example
    }
    
    private void handleFailedLogin(String userId, String email) {
        incrementLoginAttempts(userId);
        if (loginAttempts.get(userId) >= MAX_LOGIN_ATTEMPTS) {
            notificationService.sendAccountLockedEmail(email);
        }
    }
    
    private String handleSuccessfulLogin(String userId, String email) {
        resetLoginAttempts(userId);
        String sessionId = generateSessionId();
        activeSessions.put(sessionId, userId);
        sessionExpirations.put(sessionId, LocalDateTime.now().plusHours(2));
        notificationService.sendLoginNotification(email);
        return sessionId;
    }
    
    private void incrementLoginAttempts(String userId) {
        loginAttempts.put(userId, loginAttempts.getOrDefault(userId, 0) + 1);
    }
    
    private void resetLoginAttempts(String userId) {
        loginAttempts.put(userId, 0);
    }
    
    private boolean isAccountLocked(String userId) {
        return loginAttempts.getOrDefault(userId, 0) >= MAX_LOGIN_ATTEMPTS;
    }
    
    private String generateSessionId() {
        return UUID.randomUUID().toString();
    }
}
