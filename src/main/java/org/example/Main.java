package org.example;

import org.example.comparatorStudents.*;
import org.example.comparatorUniversities.*;
import org.example.enums.*;
import org.example.data.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<University> universities =
                XSSFReader.universitiesReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        UniversityComparator universityComparator =
                SwitchComparator.universityComparator(EnumComparatorUniversities.SORT_BY_ID);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students =
                XSSFReader.studentsReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        StudentComparator studentComparator =
                SwitchComparator.studentComparator(EnumComparatorStudents.SORT_BY_AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}