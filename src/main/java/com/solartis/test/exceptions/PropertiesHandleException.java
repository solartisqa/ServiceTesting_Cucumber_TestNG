package com.solartis.test.exceptions;

public class PropertiesHandleException extends Exception
{
	private static final long serialVersionUID = 1L;
    
	public PropertiesHandleException(String message)
	{
		super (message);
	}

    public PropertiesHandleException(Exception e) 
    {
        super(e);
    }

    public PropertiesHandleException(String message, Exception e) 
    {
        super(message, e);
    }
}
