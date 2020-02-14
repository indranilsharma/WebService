package com.mypack.webservices;

import javax.jws.WebService;

@WebService(endpointInterface="com.mypack.webservice.HelloWorld")  
public class HelloWorldImpl implements HelloWorld{  
  
  public String helloWorld(String name) {  
  return "Hello world from "+name;  
 }  
  
}  

