package org.example;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFReader {
    private XSSFReader() throws IOException {}

    public static List<University> universitiesReader(String filePath) throws IOException {
        List<University> universities = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet sheet = workbook.getSheetAt(1);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();
            University university = new University();
            universities.add(university);
            university.setId(row.getCell(0).getStringCellValue());
            university.setFullName(row.getCell(1).getStringCellValue());
            university.setShortName(row.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int)row.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, row.getCell(4).getStringCellValue()));
        }
        return universities;
    }

    public static List<Student> studentsReader(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Student student = new Student();
            students.add(student);
            student.setUniversityId(row.getCell(0).getStringCellValue());
            student.setFullName(row.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int)row.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float)row.getCell(3).getNumericCellValue());
        }
        return  students;
    }
}