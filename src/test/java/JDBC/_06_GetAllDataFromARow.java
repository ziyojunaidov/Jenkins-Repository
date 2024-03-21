package JDBC;

import Utilities.DBUtilities;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _06_GetAllDataFromARow extends DBUtilities {

    @Test
    public void test() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData(); // Gives all information about the table
        // (Column names, columns types, number of columns etc...)
        int columnCount = rsmd.getColumnCount(); // Gives the number of the columns
        System.out.println("ColumnCount = " + columnCount);

        rs.last();
        int numberOfRows = rs.getRow();
        rs.first();

        for (int i = 1; i < numberOfRows; i++) {
            for (int j = 1; j <= columnCount; j++) {
                String columnType = rsmd.getColumnTypeName(j);// Gives the data type of the column
                System.out.println("columnType = " + columnType);

                String ColumnName = rsmd.getColumnName(j); // Gives the title of the column
                System.out.println("ColumnName = " + ColumnName);

                String value = rs.getString(j);
                System.out.println("value = " + value);
                System.out.println();
            }
            rs.next();
        }
    }
}
