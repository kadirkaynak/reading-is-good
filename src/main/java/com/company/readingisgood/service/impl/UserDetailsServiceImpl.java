package com.company.readingisgood.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private Map<String, String> users = new HashMap<>();
    private final BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        users.put("isgood", passwordEncoder.encode("reading"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (users.containsKey(username)) {
            return new User(username, users.get(username), new ArrayList<>());
        }

        throw new UsernameNotFoundException(username);
    }
}