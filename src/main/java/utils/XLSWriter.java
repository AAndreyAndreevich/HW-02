package utils;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import education.Statistics;

public class XLSWriter {
    private static final Logger log = LogManager.getLogger(XLSWriter.class);
    private XLSWriter(){}

    public static void statisticsWriter(List<Statistics> statisticsList, Path filePath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Статистика");
        CellStyle headStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight((short)11);
        font.setFontName("Arial");
        headStyle.setFont(font);
        int rowNum = 0;
        Row headRow = sheet.createRow(rowNum++);
        headRow.createCell(0).setCellValue("Профиль обучения");
        headRow.getCell(0).setCellStyle(headStyle);
        headRow.createCell(1).setCellValue("Средний балл");
        headRow.getCell(1).setCellStyle(headStyle);
        headRow.createCell(2).setCellValue("Количество студентов");
        headRow.getCell(2).setCellStyle(headStyle);
        headRow.createCell(3).setCellValue("Количество университетов");
        headRow.getCell(3).setCellStyle(headStyle);
        headRow.createCell(4).setCellValue("Названия университетов");
        headRow.getCell(4).setCellStyle(headStyle);

        for (Statistics statistics : statisticsList) {
            Row dataRow = sheet.createRow(rowNum++);
            dataRow.createCell(0).setCellValue(statistics.getProfile().getProfileName());
            dataRow.createCell(1).setCellValue(statistics.getAvgExamScore());
            dataRow.createCell(2).setCellValue(statistics.getNumberOfStudents());
            dataRow.createCell(3).setCellValue(statistics.getNumberOfUniversities());
            dataRow.createCell(4).setCellValue(statistics.getUniversityName());
        }
        try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
            workbook.write(fos);
            workbook.close();
        }
    }
}