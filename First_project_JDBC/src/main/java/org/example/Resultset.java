package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Resultset {

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
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
            );

            //create querry

            String querry = " select * from students";
            ResultSet resultSet =statement.executeQuery(querry);

            resultSet.last();
            System.out.println("Fetching last row");
            System.out.println("id : "+ resultSet.getInt("id"));
            System.out.println("Name : "+ resultSet.getString("name"));

//            resultSet.first();
//            System.out.println("Fetching first row");
//            System.out.println("id : "+ resultSet.getInt("id"));
//            System.out.println("Name : "+ resultSet.getString("name"));


            resultSet.updateString("name", "Ramesh");
            resultSet.updateRow();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
