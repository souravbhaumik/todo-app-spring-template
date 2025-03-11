package com.sourav.todo.myapplication;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo
{
    @Id
    @GeneratedValue
    private int id;

    @Column( name = "name" )
    private String userName;

    @Size( min = 5, message = "Enter at least 5 characters" )
    // @Size( max = 10, message = "Enter less than 13 characters" )
    private String Description;

    private LocalDate Date;

    private boolean done;

    public Todo()
    {
    }

    public Todo( int id, String userName, String description, LocalDate date,
            boolean done )
    {
        this.id = id;
        this.userName = userName;
        Description = description;
        Date = date;
        this.done = done;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName( String userName )
    {
        this.userName = userName;
    }

    public String getDescription()
    {
        return Description;
    }

    public void setDescription( String description )
    {
        Description = description;
    }

    public LocalDate getDate()
    {
        return Date;
    }

    public void setDate( LocalDate date )
    {
        Date = date;
    }

    public boolean isDone()
    {
        return done;
    }

    public void setDone( boolean done )
    {
        this.done = done;
    }

    @Override
    public String toString()
    {
        return "Todo [id=" + id + ", userName=" + userName + ", Description="
                + Description + ", Date=" + Date + ", done=" + done + "]";
    }
}
