package org.perscholas.Ketotastic.OrderingApp.security;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.Ketotastic.OrderingApp.dao.RoleRepo;
import org.perscholas.Ketotastic.OrderingApp.dao.UserRepo;
import org.perscholas.Ketotastic.OrderingApp.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class  AppUserDetailsService implements UserDetailsService {

    UserRepo userRepo;
    RoleRepo roleRepo;

    public AppUserDetailsService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user with that username");
        }
        return new AppUserPrincipal(user);
    }
}
