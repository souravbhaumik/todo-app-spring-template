package com.sourav.todo.security;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration
{
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {
        UserDetails userDetails1 = createNewUser( "Sourav", "tinni" );
        UserDetails userDetails2 = createNewUser( "Tinni", "sourav" );
        return new InMemoryUserDetailsManager( userDetails1, userDetails2 );
    }

    private UserDetails createNewUser( String username, String password )
    {
        Function< String, String > passwordEncoder = input -> passwordEncoder()
                .encode( input );
        UserDetails userDetails = User.builder()
                .passwordEncoder( passwordEncoder ).username( username )
                .password( password ).roles( "USER", "ADMIN" ).build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain( HttpSecurity security )
            throws Exception
    {
        security.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated() );
        security.formLogin( withDefaults() );
        security.csrf().disable();
        security.headers().frameOptions().disable();
        return security.build();
    }
}
