package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _03_GetAllDataFromASheet {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\jdjun\\Downloads\\ApacheExcel2.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sheet1");

        int numberOfRows = sheet.getPhysicalNumberOfRows(); // Gives number of rows in a sheet

        for (int i = 0; i < numberOfRows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);
                System.out.println(cell+" ");
            }
            System.out.println();
        }
    }
}
