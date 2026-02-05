package com.codesmells.bloaters.largeclass.good;

import org.springframework.stereotype.Repository;
import java.util.*;

/**
 * GOOD EXAMPLE: Extracted User Repository
 * 
 * <h2>Responsibility: User Data Management</h2>
 * This class is focused solely on storing and retrieving user data.
 * It follows the Repository pattern and Single Responsibility Principle.
 * 
 * <h2>Benefits:</h2>
 * <ul>
 *   <li>Single, clear purpose: manage user data persistence</li>
 *   <li>Easy to test with mock data</li>
 *   <li>Can be easily replaced with a database implementation</li>
 *   <li>Changes to data storage don't affect other features</li>
 * </ul>
 */
@Repository
public class UserRepository {
    private Map<String, User> users = new HashMap<>();
    
    public void save(User user) {
        users.put(user.getUserId(), user);
    }
    
    public User findById(String userId) {
        return users.get(userId);
    }
    
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
    
    public void delete(String userId) {
        users.remove(userId);
    }
    
    public boolean exists(String userId) {
        return users.containsKey(userId);
    }
}
