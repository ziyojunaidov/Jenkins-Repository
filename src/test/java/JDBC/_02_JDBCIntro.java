package JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _02_JDBCIntro {
    @Test
    public void Test1() throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        // url contains name of the library we use to connect with database(jdbc), type of database(mysql)
        // address the host server(hostname=db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com
        // port number (3306), and name of the database (sakila)

        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z"; // '"-LhCB'.%k[4S]z

        Connection connection = DriverManager.getConnection(url,username,password); // Creates connection with database

        Statement statement = connection.createStatement(); // Creates a statement to execute our queries

        ResultSet resultSet = statement.executeQuery("select * from actor");
        //Executes the query and gets the results from the database
        // and stores the results in a ResultSet Object

        //When we first get the results arrow is on the titles row.
        //To get the results from the first row we need to move the arrow to the first row
        resultSet.next(); // moves the cursor to the next row

        String firstName = resultSet.getString(2); // Gets the value from the second column of the first row
        System.out.println("firstName = " + firstName);

        String lastname = resultSet.getString("last_name");
        System.out.println("lastname = " + lastname);

        resultSet.next(); // Now we are on second row

        firstName = resultSet.getString(2);
        System.out.println("firstName = " + firstName);

        lastname = resultSet.getString("last_name");
        System.out.println("lastname = " + lastname);

        connection.close(); // For security always close the connection when you are done
    }
}
