package org.example;

import org.example.comparatorStudents.SortByAvgExamScore;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Student> students =
                XSSFReader.studentsReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        Collections.sort(students, new SortByAvgExamScore());
        for (Student student : students) {
            System.out.println(student.getAvgExamScore());
        }
    }
}