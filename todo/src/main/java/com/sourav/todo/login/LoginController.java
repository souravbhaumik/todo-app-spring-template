package com.sourav.todo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes( "name" )
public class LoginController
{
    private Logger logger = LoggerFactory.getLogger( getClass() );

    private AuthenticationService authenticationService;
    // @RequestMapping( "/login" )
    // public String login( @RequestParam String name, ModelMap model )
    // {
    // model.put( "name", name );
    // logger.debug( "Request Param is {}.", name );
    // return "login";
    // }

    public LoginController( AuthenticationService authenticationService )
    {
        this.authenticationService = authenticationService;
    }

    @RequestMapping( value = "login", method = RequestMethod.GET )
    public String loginPage()
    {
        return "login";
    }

    @RequestMapping( value = "login", method = RequestMethod.POST )
    public String welcomePage( @RequestParam String name,
            @RequestParam String password, ModelMap model )
    {
        if( authenticationService.authenticate( name, password ) )
        {
            model.put( "name", name );
            model.put( "password", password );
            return "Welcome";
        }
        model.put( "errorMessage",
                "Invalid credentials, please enter correct paassword." );
        return "login";
    }
}
