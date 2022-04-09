package com.lwagner.jwtexample.service;

import com.lwagner.jwtexample.domain.Role;
import com.lwagner.jwtexample.domain.AppUser;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser appUser);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUser(String username);

    List<AppUser> getUsers();
}
