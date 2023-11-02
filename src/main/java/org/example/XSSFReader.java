package org.example;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFReader extends XSSFWorkbook {
    private XSSFReader () {

    }
    public void studentReader() {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.printf("%.0f", cell.getNumericCellValue());
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                    }
                }
                System.out.println();
            }
            file.close();
        } catch (Exception e) {
            System.out.println(":(");
        }
    }
    public void universityReader() {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(1);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.printf("%.0f", cell.getNumericCellValue());
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                    }
                }
                System.out.println();
            }
            file.close();
        } catch (Exception e) {
            System.out.println(":(");
        }
    }
}