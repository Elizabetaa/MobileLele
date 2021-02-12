package com.example.mobiLelele.mobiLelele;

import com.example.mobiLelele.mobiLelele.repositoriy.BrandRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.ModelRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.OfferRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.UserRepository;
import com.example.mobiLelele.mobiLelele.service.UserRoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DBInit implements CommandLineRunner {

    private final UserRoleService userRoleService;

    public DBInit(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        initRoles();


    }

    private void initRoles() {
       this.userRoleService.initRoles();
    }

}
