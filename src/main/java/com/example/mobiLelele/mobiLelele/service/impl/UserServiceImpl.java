package com.example.mobiLelele.mobiLelele.service.impl;

import com.example.mobiLelele.mobiLelele.model.entities.User;
import com.example.mobiLelele.mobiLelele.model.entities.UserRole;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Roles;
import com.example.mobiLelele.mobiLelele.model.service.UserRegisterServiceModel;
import com.example.mobiLelele.mobiLelele.repositoriy.UserRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.UserRoleRepository;
import com.example.mobiLelele.mobiLelele.security.CurrentUser;
import com.example.mobiLelele.mobiLelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public boolean authenticate(String username, String password) {

        Optional<User> userEntityOptional = userRepository.findByUsername(username);
        if (userEntityOptional.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(password, userEntityOptional.get().getPassword());
        }
    }

    @Override
    public void loginUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();

        List<Roles> userRoles = user.getUserRoles().stream()
                .map(UserRole::getRole)
                .collect(Collectors.toList());


        currentUser
                .setAnonymous(false)
                .setName(user.getUsername())
                .setUserRoles(userRoles);
    }

    @Override
    public void logoutUser() {
        currentUser.setAnonymous(true);
    }

    @Override
    public void createUser(UserRegisterServiceModel userRegister) {

        User user = modelMapper.map(userRegister, User.class);

        List<UserRole> all = this.userRoleRepository.findAll();
        UserRole adminRole = all.get(0);
        UserRole userRole = all.get(1);
        if (userRegister.getUserRoles() == Roles.ADMIN){
          user.setUserRoles(List.of(userRole,adminRole));
        }else {
            user.setUserRoles(List.of(userRole));
        }

        user.setCreated(Instant.now()).setUpdated(Instant.now());
        this.userRepository.save(user);

    }

}
