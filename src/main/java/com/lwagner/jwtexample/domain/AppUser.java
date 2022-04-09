package com.lwagner.jwtexample.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}