package com.example.mobiLelele.mobiLelele.service.impl;

import com.example.mobiLelele.mobiLelele.model.entities.User;
import com.example.mobiLelele.mobiLelele.repositoriy.UserRepository;
import com.example.mobiLelele.mobiLelele.security.CurrentUser;
import com.example.mobiLelele.mobiLelele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String username, String password) {

        Optional<User> userEntityOptional = userRepository.findByUsername(username);
        if (userEntityOptional.isEmpty()){
            return false;
        }else {
            return passwordEncoder.matches(password, userEntityOptional.get().getPassword());
        }
    }

    @Override
    public void loginUser(String username) {
        currentUser.setAnonymous(false);
        currentUser.setName(username);
    }

    @Override
    public void logoutUser() {
        currentUser.setAnonymous(true);
    }

}