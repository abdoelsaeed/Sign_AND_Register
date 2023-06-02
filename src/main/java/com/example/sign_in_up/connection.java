package com.example.sign_in_up;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    static String user="root";
    static String password="";
    static String host="jdbc:mysql://localhost/sign";
    static Connection connectionobj;
    public static Connection getconnection(){
        try {
            connectionobj = DriverManager.getConnection(host, user, password);
            System.out.println("Connection with jdbcc Database Done ## "); }
        catch (SQLException ex){
            ex.printStackTrace();
        }

        return connectionobj;
    }
}
