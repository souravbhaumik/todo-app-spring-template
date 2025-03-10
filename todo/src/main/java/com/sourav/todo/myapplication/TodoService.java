package com.sourav.todo.myapplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService
{
    private static List< Todo > todos = new ArrayList<>();

    private static int todosCount = 0;
    static
    {
        todos.add( new Todo( ++todosCount, "Sourav", "Learn AWS",
                LocalDate.now().plusYears( 1 ), false ) );
        todos.add( new Todo( ++todosCount, "Sourav", "Devops",
                LocalDate.now().plusYears( 2 ), false ) );
        todos.add( new Todo( ++todosCount, "Sourav", "Full stack development",
                LocalDate.now().plusYears( 3 ), false ) );
    }

    public List< Todo > findByuserName( String userName )
    {
        return todos;
    }

    public void addTodo( String userName, String description, LocalDate date,
            boolean isDone )
    {
        Todo todo = new Todo( ++todosCount, userName, description, date,
                isDone );
        todos.add( todo );
    }

    public void deleteById( int id )
    {
        Predicate< ? super Todo > predicate = todo -> todo.getId() == id;
        todos.removeIf( predicate );
    }

    public Todo findById( int id )
    {
        Predicate< ? super Todo > predicate = todo -> todo.getId() == id;
        return todos.stream().filter( predicate ).findFirst().get();
    }

    public void updateTodo( Todo todo )
    {
        deleteById( todo.getId() );
        todos.add( todo );
    }
}
