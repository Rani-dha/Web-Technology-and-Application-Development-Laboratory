<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "registration";
String userid = "root";
String password = "Ranidha_27";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table{
                background-color: hsl(240, 47%, 20%); 
                Color: whitesmoke;;
                margin: 200px;
            }
            table, th, td {
              border: 2px solid black;
              border-collapse: collapse;
            }
            th, td {
              padding: 15px;
            }
            </style>
    </head>
<body >
<center>
<table border="1">
<tr>
<th>Name</th>
<th>Register Number</th>
<th>Department</th>
<th>Mobile Number</th>
<th>Email ID</th>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement = connection.createStatement();
String r = request.getParameter("rollNo");
String sql ="select * from regform where rollNo='"+r+"'";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("rollNo") %></td>
<td><%=resultSet.getString("department") %></td>
<td><%=resultSet.getString("mobileNo") %></td>
<td><%=resultSet.getString("emailId") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</center>
</table>
</body>
</html>