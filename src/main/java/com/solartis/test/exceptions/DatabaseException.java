package com.solartis.test.exceptions;

public class DatabaseException extends Exception 
{
    private static final long serialVersionUID = 1L;
    
    public DatabaseException(String message)
	{
    	super (message);
	}
    
    public DatabaseException(Exception e) 
    {
        super(e);
    }

    public DatabaseException(String message, Exception e) 
    {
        super(message, e);
    }
}
