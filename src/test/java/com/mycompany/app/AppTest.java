package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList; 
import java.util.Arrays;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testEqual()
    {
    	ArrayList<String> s1=new ArrayList<String>();
    	s1.add("abc");
    	s1.add("def");
    	s1.add("ghi");
    	ArrayList<String> s2=new ArrayList<String>();
    	s2.add("jkl");
    	s2.add("abc");
    	s2.add("mno");
    	assertTrue(new App().isEqual(s1,s2,0,1));
    }
    
    public void testNotEqual()
    {
    	ArrayList<String> s1=new ArrayList<String>();
    	s1.add("abc");
    	s1.add("def");
    	s1.add("ghi");
    	ArrayList<String> s2=new ArrayList<String>();
    	s2.add("abc");
    	s2.add("jkl");
    	s2.add("mno");
    	assertFalse(new App().isEqual(s1,s2,0,2));
    }
    
    public void testIndexOutOfBounds()
    {
    	ArrayList<String> s1=new ArrayList<String>();
    	s1.add("abc");
    	s1.add("def");
    	s1.add("ghi");
    	ArrayList<String> s2=new ArrayList<String>();
    	s2.add("abc");
    	s2.add("jkl");
    	s2.add("mno");
		assertFalse(new App().isEqual(s1,s2,4,2));
    }
    
    public void testEmptyList() 
    {
    	ArrayList<String> s1=new ArrayList<String>();
    	ArrayList<String> s2=new ArrayList<String>();
    	s2.add("abc");
		assertFalse(new App().isEqual(s1,s2,3,0));
	}
	
	public void testEqualOrContain()
	{
		ArrayList<String> s1=new ArrayList<String>();
    	s1.add("abcdef");
    	ArrayList<String> s2=new ArrayList<String>();
    	s2.add("abc");
    	assertFalse(new App().isEqual(s1,s2,0,0));
	}
}
