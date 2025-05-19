package com.nurdinaffandidev.springCore.repository;

import com.nurdinaffandidev.springCore.models.Account;
import com.nurdinaffandidev.springCore.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserAccountRepository {
    // Attributes
    Map<User, Account> userAccounts = new HashMap<>();

    // Constructors
    public UserAccountRepository(Map<User, Account> userAccounts) {
        this.userAccounts = userAccounts;
    }

    // Getter Setter
    public Map<User, Account> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(Map<User, Account> userAccounts) {
        this.userAccounts = userAccounts;
    }

    // Methods
    public void addUserAndAccount(User user, Account account) {
        userAccounts.put(user, account);
    }

    public void removeUser(User user) {
        userAccounts.remove(user);
    }

    public void removeAccount(Account account) {
        if (getUser(account).isPresent()) {
            userAccounts.remove(getUser(account).get());
        }
    }

    public Optional<User> getUser(Account account) {
        Optional<User> user = Optional.empty();
        if (userAccounts.containsValue(account)) {
            for (Map.Entry<User, Account> entry : userAccounts.entrySet()) {
                if (entry.getValue().equals(account)) {
                    user = Optional.ofNullable(entry.getKey());
                }
            }
        }
        return user;
    }

    @Override
    public String toString() {
        return "UserAccountRepository{" +
                "userAccounts=" + userAccounts +
                '}';
    }
}
