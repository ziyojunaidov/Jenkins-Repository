package JDBC;

import Utilities.DBUtilities;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_AbsoluteAndRelative extends DBUtilities {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");

        rs.absolute(20); // Takes us to the 20th row right away

        String title = rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(924);

         title = rs.getString("title"); // This takes us to the 924th row
        System.out.println("title = " + title);

        rs.absolute(3);

        title = rs.getString("title"); // This takes us to the 3rd row
        System.out.println("title = " + title);

        rs.relative(20); // Jumps 20 rows ahead. Takes us from 3rd to 23rd.

        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(17); // Jumps 17 rows ahead. Takes us from 23rd to 40th.

        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(-30); //Jumps 30 rows backwards. Takes us from 40th to 10th.

        title = rs.getString("title");
        System.out.println("title = " + title);
    }

}
