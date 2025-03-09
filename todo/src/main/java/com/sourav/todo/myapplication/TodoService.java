package com.sourav.todo.myapplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService
{
    private static List< Todo > todos = new ArrayList<>();;
    static
    {
        todos.add( new Todo( 1, "Sourav", "Learn AWS",
                LocalDate.now().plusYears( 1 ), false ) );
        todos.add( new Todo( 2, "Sourav", "Devops",
                LocalDate.now().plusYears( 2 ), false ) );
        todos.add( new Todo( 3, "Sourav", "Full stack development",
                LocalDate.now().plusYears( 3 ), false ) );
    }

    public List< Todo > findByuserName( String userName )
    {
        return todos;
    }
}
