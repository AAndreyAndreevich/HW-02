package org.example.utils;

import java.io.*;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.education.Statistics;

public class XLSWriter {
    private XLSWriter(){}

    public static void statisticsWriter(List<Statistics> statisticsList, String filePath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Статистика");
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight((short)12);
        style.setFont(font);
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Профиль обучения");
        row.getCell(0).setCellStyle(style);
        row.createCell(1).setCellValue("Средний балл");
        row.getCell(1).setCellStyle(style);
        row.createCell(2).setCellValue("Количество студентов");
        row.getCell(2).setCellStyle(style);
        row.createCell(3).setCellValue("Количество университетов");
        row.getCell(3).setCellStyle(style);
        row.createCell(4).setCellValue("Университеты");
        row.getCell(4).setCellStyle(style);
        for (Statistics statistics : statisticsList) {
            sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(statistics.getProfile().getProfileName());
            row.createCell(1).setCellValue(statistics.getAvgExamScore());
            row.createCell(2).setCellValue(statistics.getNumberOfStudents());
            row.createCell(3).setCellValue(statistics.getNumberOfUniversities());
            row.createCell(4).setCellValue(statistics.getUniversityName());
        }
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
        }
    }
}