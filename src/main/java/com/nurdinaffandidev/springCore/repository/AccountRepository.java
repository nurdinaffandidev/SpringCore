package com.nurdinaffandidev.springCore.repository;

import com.nurdinaffandidev.springCore.models.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {
    // Attributes
    private Map<Long, Account> accounts = new HashMap<>();

    // Constructor
    public AccountRepository(Map<Long, Account> accounts) {
        this.accounts = accounts;
    }

    // Getter Setter
    public Map<Long, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Long, Account> accounts) {
        this.accounts = accounts;
    }

    // Methods
    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account.getAccountNumber());
    }

    @Override
    public String toString() {
        return "AccountRepository{" +
                "accounts=" + accounts +
                '}';
    }
}
