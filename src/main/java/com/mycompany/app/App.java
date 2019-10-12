package com.mycompany.app;

import java.util.ArrayList;

import static spark.Spark.get; 
import static spark.Spark.port; 
import static spark.Spark.post;

import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    port(getHerokuAssignedPort());
    get("/", (req, res) -> "Hello, World");
    post("/compute", (req, res) -> {
    //System.out.println(req.queryParams("input1"));
    //System.out.println(req.queryParams("input2"));
    String input1 = req.queryParams("input1");
    java.util.Scanner sc1 = new java.util.Scanner(input1);
    sc1.useDelimiter("[;\r\n]+");
    java.util.ArrayList<String> inputList1 = new java.util.ArrayList<>();
    while (sc1.hasNext())
    {
    String input = sc1.next().replaceAll("\\s","");
    inputList1.add(input);
    }
    System.out.println(inputList1);
    
    String input2 = req.queryParams("input2");
    java.util.Scanner sc2 = new java.util.Scanner(input2);
    sc2.useDelimiter("[;\r\n]+");
    java.util.ArrayList<String> inputList2 = new java.util.ArrayList<>();
    while (sc2.hasNext())
    {
    String input_2 = sc2.next().replaceAll("\\s","");
    inputList2.add(input_2);
    }
    System.out.println(inputList2);

    String input3 = req.queryParams("input3").replaceAll("\\s","");
    int input3int = Integer.parseInt(input3);
    
    String input4 = req.queryParams("input4").replaceAll("\\s","");
    int input4int = Integer.parseInt(input4);

    boolean result = App.isEqual(inputList1, inputList2, input3int, input4int);
    Map map = new HashMap();
    map.put("result", result);
    return new ModelAndView(map, "compute.mustache");
    }, new MustacheTemplateEngine());
    get("/compute",
    (rq, rs) -> {
    Map map = new HashMap();
    map.put("result", "not computed yet!");
    return new ModelAndView(map, "compute.mustache");
    },
    new MustacheTemplateEngine());
    }

	public static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder(); 
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT")); }
		return 4567; //return default port if heroku-port isn't set (i.e. on localhost) 
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
