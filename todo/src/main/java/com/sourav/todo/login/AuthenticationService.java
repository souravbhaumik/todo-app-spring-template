package com.sourav.todo.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService
{
    public boolean authenticate( String userName, String password )
    {
        boolean isValidUserName = userName.equalsIgnoreCase( "Sourav" );
        boolean isValidPassword = password.equalsIgnoreCase( "tinni" );
        return isValidUserName && isValidPassword;
    }
}
