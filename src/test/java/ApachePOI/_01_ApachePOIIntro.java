package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _01_ApachePOIIntro {

    //What is Apache POI
    // A Java library. We use it to get data from an excel file and to write data to an excel file
    // We create a FileInputStream to read data and FileOutputStream to write data
    public static void main(String[] args) throws IOException {

//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//
//            int randomNumber = (int) Math.random() * 100;
//            list.add(randomNumber);
//            System.out.println(list);
//        }

//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            List<Integer> innerList = new ArrayList<>();
//            for (int j = 0; j < 5; j++) {
//                int randomNumber = (int) (Math.random() * 101);
//                innerList.add(randomNumber);
//            }
//            list.add(innerList);
//        }
//        System.out.println(list);

        String path = "C:\\Users\\jdjun\\Downloads\\ApacheExcel2.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path); // a one way road from the file to our code

        Workbook workbook = WorkbookFactory.create(fileInputStream); //Open the file in the memory

        Sheet sheet = workbook.getSheet("Sheet1");

        Row row1 = sheet.getRow(0);//Select the row we want to use
        Cell cell = row1.getCell(0);//Cell from the row
        System.out.println("cell = " + cell);

        Row row2 = sheet.getRow(1);
        Cell cell3 = row2.getCell(2);
        System.out.println("cell3 = " + cell3);

        Row row6 = sheet.getRow(5);
        Cell cell2 = row6.getCell(1);
        System.out.println("cell2 = " + cell2);
    }
}
