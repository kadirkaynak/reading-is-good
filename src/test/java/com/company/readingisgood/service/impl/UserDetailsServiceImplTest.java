package com.company.readingisgood.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void Given_String_When_LoadUserByUsername_Then_ReturnUserDetails() {
        //
        // Given
        //
        when(passwordEncoder.encode("reading")).thenReturn("encoded");
        userDetailsService.init();
        //
        // When
        //
        UserDetails userDetails = userDetailsService.loadUserByUsername("isgood");
        //
        // Then
        //
        Assertions.assertNotNull(userDetails);
    }
}