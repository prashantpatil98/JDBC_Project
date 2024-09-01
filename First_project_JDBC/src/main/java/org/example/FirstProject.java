package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstProject {

    public static String  LOAD_Driver = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/studentdb";
    public static String username = "root";
    public static String password = "Progress@2918";

    public static void main(String[] args) {

        try {
            //load driver
            Class.forName(LOAD_Driver);

            //making connection
            Connection connection = DriverManager.getConnection(URL,username,password);

            //create statement
            Statement statement = connection.createStatement();

            //create querry

            String querry = " select * from students";
            ResultSet resultSet =statement.executeQuery(querry);
            while(resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name = resultSet.getString("name");
                String course = resultSet.getString("Course");
                System.out.println("id :" + id);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
