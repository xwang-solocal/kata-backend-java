package com.solocal.dsp.kata.model.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Builder
@Entity(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique=true, nullable = false)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="pseudonym")
    private String pseudonym;

    @ManyToMany
    @JoinTable( name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
