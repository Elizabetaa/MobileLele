package com.example.mobiLelele.mobiLelele.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User extends BaseEntity {


    private String username;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageUrl;

    @ManyToMany
    private List<UserRole> userRoles;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public User setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public User setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public User setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", imageUrl='" + imageUrl + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
