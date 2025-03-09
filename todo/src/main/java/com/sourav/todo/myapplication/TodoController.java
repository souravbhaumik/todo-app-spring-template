package com.sourav.todo.myapplication;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@SessionAttributes( "name" )
public class TodoController
{
    private TodoService todoService;

    public TodoController( TodoService todoService )
    {
        this.todoService = todoService;
    }

    @RequestMapping( value = "list-todos", method = RequestMethod.GET )
    public String listAllTodos( ModelMap model )
    {
        List< Todo > todos = todoService.findByuserName( "Sourav" );
        model.addAttribute( "todos", todos );
        return "listTodos";
    }

    @RequestMapping( value = "add-todo", method = RequestMethod.GET )
    public String showNewTodoPage()
    {
        return "todo";
    }

    @PostMapping( "add-todo" )
    public String submitTodo()
    {
        return "redirect:list-todos";
    }
}
