/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author ADMIN
 */
import java.sql.*;
import java.util.*;


public class ConnectionManager {

static Connection con;
static String connectionURL;
static String url;

public static Connection getConnection()
{

try
{
Class.forName("com.mysql.jdbc.Driver");  
String url = "jdbc:mysql://localhost:3306/bank";
String username = "root";
String password = "";
try
{            	
con = DriverManager.getConnection(url, username, password); 
    System.out.println("Connected!");
// assuming your SQL Server's	username is "username"               
// and password is "password"
}

catch (SQLException ex)
{
ex.printStackTrace();
}
}

catch(ClassNotFoundException e)
{
System.out.println(e);
}

return con;
}
}
