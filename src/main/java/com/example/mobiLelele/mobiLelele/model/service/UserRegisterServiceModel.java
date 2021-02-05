package com.example.mobiLelele.mobiLelele.model.service;

import com.example.mobiLelele.mobiLelele.model.entities.enums.Roles;

import javax.validation.constraints.Size;

public class UserRegisterServiceModel {

    @Size(min = 2)
    private String firstName;
    @Size(min = 2)
    private String lastName;
    @Size(min = 3)
    private String username;
    @Size(min = 6)
    private String password;

    private Roles userRoles;

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public Roles getUserRoles() {
        return userRoles;
    }

    public UserRegisterServiceModel setUserRoles(Roles userRoles) {
        this.userRoles = userRoles;
        return this;
    }
}
