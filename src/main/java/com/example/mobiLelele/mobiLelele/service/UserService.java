package com.example.mobiLelele.mobiLelele.service;

import com.example.mobiLelele.mobiLelele.model.service.UserRegisterServiceModel;

public interface UserService {

    boolean authenticate(String username, String password);
    void loginUser(String username);
    void logoutUser();
    void createUser(UserRegisterServiceModel userRegister);
}
