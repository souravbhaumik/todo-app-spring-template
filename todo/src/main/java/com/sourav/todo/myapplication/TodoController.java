package com.sourav.todo.myapplication;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String showNewTodoPage( ModelMap model )
    {
        String userName = (String)model.get( "name" );
        Todo todo = new Todo( 0, userName, "", LocalDate.now().plusDays( 33 ),
                false );
        model.put( "todo", todo );
        return "todo";
    }

    @PostMapping( "add-todo" )
    public String addNewTodo( ModelMap model, @Valid Todo todo,
            BindingResult result )
    {
        if( result.hasErrors() )
        {
            return "todo";
        }
        String userName = (String)model.get( "name" );
        todoService.addTodo( userName, todo.getDescription(), todo.getDate(),
                false );
        return "redirect:list-todos";
    }

    @RequestMapping( "delete-todo" )
    public String deleteTodo( @RequestParam int id )
    {
        todoService.deleteById( id );
        return "redirect:list-todos";
    }

    @GetMapping( "update-todo" )
    public String showUpdateTodoPage( @RequestParam int id, ModelMap model )
    {
        Todo todo = todoService.findById( id );
        model.addAttribute( "todo", todo );
        return "todo";
    }

    @PostMapping( "update-todo" )
    public String updateTodo( ModelMap model, @Valid Todo todo,
            BindingResult result )
    {
        if( result.hasErrors() )
        {
            return "todo";
        }
        String userName = (String)model.get( "name" );
        todoService.updateTodo( todo );
        return "redirect:list-todos";
    }
}
