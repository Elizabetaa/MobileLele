package com.example.mobiLelele.mobiLelele.service.impl;

import com.example.mobiLelele.mobiLelele.model.entities.UserRole;
import com.example.mobiLelele.mobiLelele.model.entities.enums.Roles;
import com.example.mobiLelele.mobiLelele.repositoriy.UserRoleRepository;
import com.example.mobiLelele.mobiLelele.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initRoles() {
        UserRole user = new UserRole().setRole(Roles.USER);
        UserRole admin = new UserRole().setRole(Roles.ADMIN);
        this.userRoleRepository.save(user);
        this.userRoleRepository.save(admin);
    }

}
