package com.example.mobiLelele.mobiLelele.security;

import com.example.mobiLelele.mobiLelele.model.entities.enums.Roles;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {
    private static final String ANONYMOUS_NAME = "anonymous";

    private String name = ANONYMOUS_NAME;
    private boolean isAnonymous = true;
    private List<Roles> userRoles = new ArrayList<>();

    public boolean isAdmin(){
        boolean is =  userRoles.contains(Roles.ADMIN);
        return is;
    }


    public CurrentUser setUserRoles(List<Roles> newUserRoles){
        userRoles.clear();
        userRoles.addAll(newUserRoles);
        return this;
    }

    public static String getANONYMOUS() {
        return ANONYMOUS_NAME;
    }

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }
    public boolean isLoggedIn() {
        return !isAnonymous;
    }

    public CurrentUser setAnonymous(boolean anonymous) {
        if (anonymous){
            this.name = ANONYMOUS_NAME;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
        return this;
    }
}
