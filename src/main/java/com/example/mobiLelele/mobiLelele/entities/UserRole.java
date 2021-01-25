package com.example.mobiLelele.mobiLelele.entities;


import com.example.mobiLelele.mobiLelele.entities.enums.Roles;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Roles role;



    public Long getId() {
        return id;
    }

    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public Roles getRole() {
        return role;
    }

    public UserRole setRole(Roles role) {
        this.role = role;
        return this;
    }
}
