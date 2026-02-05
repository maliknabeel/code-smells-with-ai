package com.codesmells.bloaters.largeclass.good;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * GOOD EXAMPLE: Extracted Authorization Service
 * 
 * <h2>Responsibility: User Authorization and Permissions</h2>
 * This class handles role management and permission checking.
 * 
 * <h2>Benefits:</h2>
 * <ul>
 *   <li>Focused on authorization logic only</li>
 *   <li>Easy to extend with more complex permission systems</li>
 *   <li>Can be tested independently from authentication</li>
 *   <li>Role and permission changes don't affect other services</li>
 * </ul>
 */
@Service
public class AuthorizationService {
    
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    
    private Map<String, List<String>> userRoles = new HashMap<>();
    
    public AuthorizationService(UserRepository userRepository, 
                               NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }
    
    public void initializeUserRoles(String userId) {
        userRoles.put(userId, new ArrayList<>());
    }
    
    public void assignRole(String userId, String role) {
        List<String> roles = userRoles.get(userId);
        if (roles != null && !roles.contains(role)) {
            roles.add(role);
            User user = userRepository.findById(userId);
            if (user != null) {
                notificationService.sendRoleAssignmentNotification(user.getEmail(), role);
            }
        }
    }
    
    public void removeRole(String userId, String role) {
        List<String> roles = userRoles.get(userId);
        if (roles != null) {
            roles.remove(role);
            User user = userRepository.findById(userId);
            if (user != null) {
                notificationService.sendRoleRemovalNotification(user.getEmail(), role);
            }
        }
    }
    
    public boolean hasRole(String userId, String role) {
        List<String> roles = userRoles.get(userId);
        return roles != null && roles.contains(role);
    }
    
    public boolean hasPermission(String userId, String permission) {
        List<String> roles = userRoles.get(userId);
        if (roles == null) return false;
        
        for (String role : roles) {
            if (roleHasPermission(role, permission)) {
                return true;
            }
        }
        return false;
    }
    
    public void removeUserRoles(String userId) {
        userRoles.remove(userId);
    }
    
    private boolean roleHasPermission(String role, String permission) {
        // Simplified permission checking
        // In a real system, this would check a role-permission mapping
        return true;
    }
}
