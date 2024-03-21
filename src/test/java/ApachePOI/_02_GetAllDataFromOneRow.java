package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _02_GetAllDataFromOneRow {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\jdjun\\Downloads\\ApacheExcel2.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Row row2 = sheet.getRow(1);
        int numberOfCells = row2.getPhysicalNumberOfCells(); // Gives the number of cells in the row

        for (int i = 0; i < numberOfCells; i++) {
            Cell cell = row2.getCell(i);
            System.out.println("cell = " + cell);
        }
    }
}
