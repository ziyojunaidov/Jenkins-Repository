package JDBC;

import Utilities.DBUtilities;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_FirstAndLastGetRow extends DBUtilities {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select city_id, city, country_id from city");

        rs.last(); // Jumps to the last row of the results

        String city = rs.getString("city");
        System.out.println("city = " + city);

        int numberOfLastRow = rs.getRow(); // Gives the number of current row not Id of the row
        // Id doesn't give the number of the row because some rows might have been deleted
        System.out.println("numberOfLastRow = " + numberOfLastRow);

        int cityId = rs.getInt("city_id"); // We can get all values as a string
        // and then if we need them as number we can convert them. We can also get values as their original type
        System.out.println("cityId = " + cityId);

        String cityIdStr = rs.getString("city_id");
        System.out.println("cityIdStr = " + cityIdStr);

        rs.first(); // Takes us to the 1st row
        city = rs.getString("city");
        System.out.println("city = " + city);

    }
}
