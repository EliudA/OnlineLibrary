package com.sda.bookstore.project.service.impl;

import com.sda.bookstore.project.model.User;
import com.sda.bookstore.project.repository.UserRepository;
import com.sda.bookstore.project.security.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PasswordService implements UserDetailsPasswordService {

    private final UserRepository userRepository;

    public PasswordService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        Optional<User> userCredentials =
                Optional.ofNullable(userRepository.findByUsername(user.getUsername()));
        if (userCredentials.isPresent()) {
            userCredentials.get().setPassword(newPassword);
        }
        return new MyUserDetails(userCredentials.get());
    }
}
