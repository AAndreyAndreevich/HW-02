package utils;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import enums.StudyProfile;
import model.Student;
import model.University;

public class XSSFReader {
    private static final Logger logger = Logger.getLogger(XSSFReader.class.getSimpleName());
    private XSSFReader(){}

    public static List<Student> studentsReader(Path filePath) {
        List<Student> students = new ArrayList<>();
        try {
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
            logger.info("Получен список Студентов");
            workbook.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка: {0} ", e.getMessage());
        }
        return students;
    }

    public static List<University> universitiesReader(Path filePath) {
        List<University> universities = new ArrayList<>();
        try {
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
            logger.info("Получен список Университетов");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка: {0} ", e.getMessage());
        }
        return universities;
    }
}