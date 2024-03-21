package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _04_GetASpecificData {
    /**
     * Write the code that gives a specific data that the user wants
     * E.g. When user types username print the username from the excel file
     */

    public static void main(String[] args) throws IOException {
        System.out.println("What do you want to search");
        Scanner scanner = new Scanner(System.in);
        String userResponse = scanner.nextLine();

        /**
         * Check the value in the first cell of each row
         * If that value matches with the user's response
         * Print all values on that row
         **/

        String path = "C:\\Users\\jdjun\\Downloads\\LoginData.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Login");

        StringBuilder returnValue = new StringBuilder();

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            if (row.getCell(0).toString().equalsIgnoreCase(userResponse)) {
                for (int j = 1; j < row.getPhysicalNumberOfCells(); j++) {
                    Cell cell = row.getCell(j);
                    returnValue.append(cell).append(" ");
                }
                break;
            }
        }
        System.out.println("returnValue = " + returnValue);
    }
}
