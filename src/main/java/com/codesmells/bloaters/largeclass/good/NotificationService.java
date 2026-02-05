package com.codesmells.bloaters.largeclass.good;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * GOOD EXAMPLE: Extracted Notification Service
 * 
 * <h2>Responsibility: User Notifications</h2>
 * This class handles all email and notification sending.
 * 
 * <h2>Benefits:</h2>
 * <ul>
 *   <li>Focused on notification logic only</li>
 *   <li>Easy to add new notification channels (SMS, push, etc.)</li>
 *   <li>Can be tested with mock email servers</li>
 *   <li>Notification changes don't affect core business logic</li>
 * </ul>
 */
@Service
public class NotificationService {
    
    private String emailServer = "smtp.example.com";
    private String smsGateway = "sms.example.com";
    private List<String> adminEmails = new ArrayList<>();
    
    public void sendWelcomeEmail(String email) {
        sendEmail(email, "Welcome!", "Welcome to our system");
    }
    
    public void sendLoginNotification(String email) {
        sendEmail(email, "Login Detected", "New login to your account");
    }
    
    public void sendLogoutNotification(String email) {
        sendEmail(email, "Logout", "You have been logged out");
    }
    
    public void sendProfileUpdateNotification(String email) {
        sendEmail(email, "Profile Updated", "Your profile has been updated");
    }
    
    public void sendAccountLockedEmail(String email) {
        sendEmail(email, "Account Locked", "Your account has been locked due to multiple failed login attempts");
    }
    
    public void sendRoleAssignmentNotification(String email, String role) {
        sendEmail(email, "Role Assigned", "You have been assigned the role: " + role);
    }
    
    public void sendRoleRemovalNotification(String email, String role) {
        sendEmail(email, "Role Removed", "The role has been removed: " + role);
    }
    
    public void notifyAdminsOfDeletion(String userId) {
        for (String adminEmail : adminEmails) {
            sendEmail(adminEmail, "User Deleted", "User " + userId + " has been deleted");
        }
    }
    
    private void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        // In a real application, this would use JavaMailSender or similar
    }
}
