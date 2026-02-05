package com.codesmells.bloaters.largeclass.good;

import org.springframework.stereotype.Service;

/**
 * GOOD EXAMPLE: Refactored User Management Service
 * 
 * <h2>Refactoring Applied: Extract Class</h2>
 * The original large UserManager class has been split into multiple focused classes:
 * - UserRepository: Data access and persistence
 * - AuthenticationService: Login, logout, session management
 * - AuthorizationService: Roles and permissions
 * - NotificationService: Email and notifications
 * - UserManagementService: High-level user operations (this class)
 * 
 * <h2>Benefits of this Refactoring:</h2>
 * <ul>
 *   <li>Each class has a single, clear responsibility</li>
 *   <li>Easier to understand - each class can be read independently</li>
 *   <li>Easier to test - mock only the dependencies you need</li>
 *   <li>Easier to maintain - changes are localized</li>
 *   <li>Better reusability - services can be used independently</li>
 *   <li>Follows SOLID principles, especially Single Responsibility</li>
 * </ul>
 * 
 * <h2>Key Improvements:</h2>
 * <ul>
 *   <li>Separation of concerns</li>
 *   <li>Dependency injection for better testability</li>
 *   <li>Each service is focused and cohesive</li>
 *   <li>Changes to one service don't affect others</li>
 * </ul>
 * 
 * <h2>Teaching Points:</h2>
 * <ul>
 *   <li>Look for groups of related methods and fields</li>
 *   <li>Extract them into separate classes</li>
 *   <li>Use dependency injection to wire them together</li>
 *   <li>Each class should do one thing well</li>
 * </ul>
 */
@Service
public class UserManagementService {
    
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    
    public UserManagementService(UserRepository userRepository,
                                AuthenticationService authenticationService,
                                AuthorizationService authorizationService,
                                NotificationService notificationService) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
    }
    
    /**
     * Creates a new user in the system
     * Orchestrates calls to multiple services
     */
    public void createUser(String userId, String name, String email, String password) {
        User user = new User(userId, name, email);
        userRepository.save(user);
        authenticationService.registerPassword(userId, password);
        authorizationService.initializeUserRoles(userId);
        notificationService.sendWelcomeEmail(email);
    }
    
    /**
     * Retrieves a user by ID
     */
    public User getUser(String userId) {
        return userRepository.findById(userId);
    }
    
    /**
     * Updates user profile information
     */
    public void updateUser(String userId, String name, String email) {
        User user = userRepository.findById(userId);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            userRepository.save(user);
            notificationService.sendProfileUpdateNotification(email);
        }
    }
    
    /**
     * Deletes a user from the system
     * Ensures cleanup across all services
     */
    public void deleteUser(String userId) {
        userRepository.delete(userId);
        authenticationService.removeUserSessions(userId);
        authorizationService.removeUserRoles(userId);
        notificationService.notifyAdminsOfDeletion(userId);
    }
}
