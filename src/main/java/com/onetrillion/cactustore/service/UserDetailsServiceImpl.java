package com.onetrillion.cactustore.service;

import com.onetrillion.cactustore.model.ApplicationUser;
import com.onetrillion.cactustore.model.User;
import com.onetrillion.cactustore.repository.UserRepository;
import com.onetrillion.cactustore.security.ApplicationUserRole;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
/*
        String userRole = String.valueOf(user.stream()
                .map(User::getRoles)
                .findFirst());

 */
        String userRole = user.map(User::getRoles).get();

        var permission = userRole.equalsIgnoreCase("ADMIN") ?
                ApplicationUserRole.ADMIN : ApplicationUserRole.CUSTOMER;

        ApplicationUser applicationUser = user.map(userinfo -> new ApplicationUser(
                userinfo.getPassword(),
                userinfo.getUsername(),
                permission.getGrantedAuthorities(),
                userinfo.isAccountNonExpired(),
                userinfo.isAccountNonLocked(),
                userinfo.isCredentialsNonExpired(),
                userinfo.isEnabled()))
                .get();

        return applicationUser;
    }
}
