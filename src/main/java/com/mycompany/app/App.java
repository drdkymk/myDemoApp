package com.mycompany.app;

import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static boolean isEqual(ArrayList<String> s1, ArrayList<String> s2, int a, int b)
    {	
    	if(s1.size()==0 || s2.size()==0)
    			return false;
    	else if(s1.size()>a && s2.size()>b)
    	{
			if(s1.get(a).equals(s2.get(b)))
    		{
    			return true;
    		}
    		else
    			return false;
    	}
    	else
    		return false;
    }
}
