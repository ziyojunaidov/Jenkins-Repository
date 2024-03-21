package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInDifferentRow {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\jdjun\\OneDrive\\Write.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);//Creates a connection from file to our code

        Workbook workbook = WorkbookFactory.create(fileInputStream);//Opens a copy of the file in the temporary memory

        Sheet sheet = workbook.getSheet("Sheet1");

        int numberOfRows = sheet.getPhysicalNumberOfRows();

        Row row = sheet.createRow(numberOfRows);
        for (int i = 0; i < 10; i++) {
            Cell cell1 = row.getCell(i);
            cell1.setCellValue("Hello Batch 10");
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);//Creates a connection from our code  to the file
        workbook.write(fileOutputStream);//Writes in the file
        workbook.close();
        fileOutputStream.close();
    }
}
