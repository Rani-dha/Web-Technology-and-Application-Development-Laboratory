<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>


<%
String n=request.getParameter("name");  
String r=request.getParameter("rollNo");  
String d=request.getParameter("department");  
String m=request.getParameter("mobileNo");  
String e=request.getParameter("emailId");  
          
try{  
Class.forName("com.mysql.jdbc.Driver");   
Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/registration","root","Ranidha_27");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into regform values(?,?,?,?,?)");   
ps.setString(1,n);  
ps.setString(2,r);  
ps.setString(3,d);
ps.setString(4,m); 
ps.setString(5,e);            
int i=ps.executeUpdate(); 
if(i>0) 
out.print("   Student info was successfully registered     ");    
          
}catch (Exception e2) {System.out.println(e2);} 
%>