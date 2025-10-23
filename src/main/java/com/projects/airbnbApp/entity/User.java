package com.projects.airbnbApp.entity;

import com.projects.airbnbApp.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;  // encode

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)  // this creates a separate table for this app_user_roles
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

}
