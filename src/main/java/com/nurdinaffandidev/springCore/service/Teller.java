package com.nurdinaffandidev.springCore.service;

import com.nurdinaffandidev.springCore.models.Account;
import com.nurdinaffandidev.springCore.models.User;
import com.nurdinaffandidev.springCore.repository.AccountRepository;
import com.nurdinaffandidev.springCore.repository.UserAccountRepository;
import com.nurdinaffandidev.springCore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Teller {
    // Attributes
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;

    // Constructor
    public Teller(AccountRepository accountRepository, UserRepository userRepository, UserAccountRepository userAccountRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.userAccountRepository = userAccountRepository;
    }

    // Methods
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void removeUser(User user) {
        userRepository.removeUser(user);
    }

    public void addAccount(Account account) {
        accountRepository.addAccount(account);
    }

    public void removeAccount(Account account) {
        accountRepository.removeAccount(account);
    }

    public void addUserAccount(User user, Account account) {
        userAccountRepository.addUserAndAccount(user, account);
        userRepository.addUser(user);
        accountRepository.addAccount(account);
    }

    public void removeUserAccount(User user, Account account) {
        userAccountRepository.removeUser(user);
        userAccountRepository.removeAccount(account);
        userRepository.removeUser(user);
        accountRepository.removeAccount(account);
    }

    @Override
    public String toString() {
        return "Teller{" +
                "accountRepository=" + accountRepository +
                ", userRepository=" + userRepository +
                ", userAccountRepository=" + userAccountRepository +
                '}';
    }
}
