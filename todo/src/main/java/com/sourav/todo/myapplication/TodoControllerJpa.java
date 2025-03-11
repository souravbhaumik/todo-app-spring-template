package com.sourav.todo.myapplication;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TodoControllerJpa
{
    private TodoService todoService;

    private TodoRepository todoRepository;

    public TodoControllerJpa( TodoService todoService,
            TodoRepository todoRepository )
    {
        super();
        // this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping( value = "list-todos", method = RequestMethod.GET )
    public String listAllTodos( ModelMap model )
    {
        String userName = getLoggedInUsername( model );
        // List< Todo > todos = todoService.findByUserName( userName );
        List< Todo > todos = todoRepository.findByUserName( userName );
        model.addAttribute( "todos", todos );
        model.put( "name", userName );
        return "listTodos";
    }

    @RequestMapping( value = "add-todo", method = RequestMethod.GET )
    public String showNewTodoPage( ModelMap model )
    {
        String userName = getLoggedInUsername( model );
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
        String userName = getLoggedInUsername( model );
        todo.setUserName( userName );
        todoRepository.save( todo );
        // todoService.addTodo( userName, todo.getDescription(), todo.getDate(),
        // todo.isDone() );
        return "redirect:list-todos";
    }

    @RequestMapping( "delete-todo" )
    public String deleteTodo( @RequestParam int id )
    {
        // todoService.deleteById( id );
        todoRepository.deleteById( id );
        return "redirect:list-todos";
    }

    @GetMapping( "update-todo" )
    public String showUpdateTodoPage( @RequestParam int id, ModelMap model )
    {
        // Todo todo = todoService.findById( id );
        Todo todo = todoRepository.findById( id ).get();
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
        String userName = getLoggedInUsername( model );
        todo.setUserName( userName );
        // todoService.updateTodo( todo );
        todoRepository.save( todo );
        return "redirect:list-todos";
    }

    private String getLoggedInUsername( ModelMap model )
    {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        return authentication.getName();
    }
}
