package com.nurdinaffandidev.springCore.repository;

import com.nurdinaffandidev.springCore.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    // Attributes
    private Map<Long, User> users = new HashMap<>();

    // Constructors
    public UserRepository(Map<Long, User> users) {
        this.users = users;
    }

    // Getter Setter
    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Long, User> users) {
        this.users = users;
    }

    //Methods
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void removeUser(User user) {
        users.remove(user.getId());
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}
