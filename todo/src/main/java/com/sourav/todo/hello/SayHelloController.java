package com.sourav.todo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController
{
    @RequestMapping( path = "/allendpoints" )
    public String allEndPoints()
    {
        return "allEndPoints";
    }

    // Say hello => "What are you learning today?"
    @RequestMapping( "/hello" )
    @ResponseBody
    public String sayHello()
    {
        return """
                Hello, What are you learning today?<br><a href="http://localhost:8090/">Home</a>""";
    }

    @RequestMapping( "/hello-html" )
    @ResponseBody
    public String sayHelloHtml()
    {
        StringBuffer sb = new StringBuffer(
                """
                        <!DOCTYPE html><html lang="en"><head><title>My first Html Page</title></head><body>My first Html Page with body.<br><a href="http://localhost:8090/">Home</a></body></html>
                        """ );
        return sb.toString();
    }

    @RequestMapping( path = "/hello-jsp" )
    public String sayHelloJsp()
    {
        return "sayHello";
    }
}
