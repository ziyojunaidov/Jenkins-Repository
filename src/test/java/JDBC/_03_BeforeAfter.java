package JDBC;

import Utilities.DBUtilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class _03_BeforeAfter extends DBUtilities {



    @Test
    public void Test1() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String language = rs.getString("name");
        System.out.println("language = " + language);


    }
    @Test
    public void Test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        rs.next();

        String language = rs.getString("name");
        System.out.println("language = " + language);

        rs.next();
        language = rs.getString("name");
        System.out.println("language = " + language);

        rs.previous(); // Moves one step backwards
        language = rs.getString("name");
        System.out.println("language = " + language);
    }
}
