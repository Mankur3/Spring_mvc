package dbtest;

import java.sql.*;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class MysqlCon{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
String host="jdbc:mysql://localhost:3306/ankur?autoReconnect=true&useSSL=false";
String usname="root";
String pass="test123";
Connection con=DriverManager.getConnection(  
host,usname,pass);  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from emp");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  
}catch(Exception e){  
	System.out.println("exception is");
	System.out.println(e);}  
}  
}  