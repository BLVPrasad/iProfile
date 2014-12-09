<%@page import="org.jboss.samples.rs.webservices.HelloWorldResource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.jboss.samples.rs.webservices.HelloWorldResource"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Out Put :: <%= out.println(HelloWorldResource.class.getName()) %>
</body>
</html>