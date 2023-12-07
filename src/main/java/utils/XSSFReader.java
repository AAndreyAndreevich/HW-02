package utils;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import enums.StudyProfile;
import education.Student;
import education.University;

public class XSSFReader {
    private static final Logger log = LogManager.getLogger(XSSFReader.class);
    private XSSFReader(){}

    public static List<Student> studentsReader(Path filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath.toFile()));
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

    public static List<University> universitiesReader(Path filePath) throws IOException {
        List<University> universities = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath.toFile()));
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
}