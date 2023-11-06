package org.example;

import org.example.comparatorStudents.SortByAvgExamScore;
import org.example.comparatorStudents.StudentComparator;
import org.example.comparatorUniversities.UniversityComparator;
import org.example.enums.EnumComparatorStudents;
import org.example.enums.EnumComparatorUniversities;
import org.example.in_stock.Student;
import org.example.in_stock.University;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<University> universities =
                XSSFReader.universitiesReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        UniversityComparator universityComparator =
                ImmutableClass.universityComparator(EnumComparatorUniversities.SORT_BY_ID);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students =
                XSSFReader.studentsReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        StudentComparator studentComparator =
                ImmutableClass.studentComparator(EnumComparatorStudents.SORT_BY_AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}