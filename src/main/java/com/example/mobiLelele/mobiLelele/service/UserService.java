package com.example.mobiLelele.mobiLelele.service;

public interface UserService {

    boolean authenticate(String username, String password);
    void loginUser(String username);
    void logoutUser();
}
