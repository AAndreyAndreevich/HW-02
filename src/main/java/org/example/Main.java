package org.example;

import org.example.comparatorStudents.SortByAvgExamScore;
import org.example.comparatorStudents.SortByCurrentCourseNumber;
import org.example.comparatorStudents.SortByUniversityId;
import org.example.comparatorUniversities.SortById;
import org.example.comparatorUniversities.SortByMainProfile;
import org.example.comparatorUniversities.SortByShortName;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<University> universities =
                XSSFReader.universitiesReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        System.out.println("Университеты");
        Collections.sort(universities, new SortByMainProfile());
        for (University university : universities) {
            System.out.println(university.getMainProfile() + " | " + university.fullName);
        }

        List<Student> students =
                XSSFReader.studentsReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        System.out.println("Студенты");
        Collections.sort(students, new SortByCurrentCourseNumber());
        for(Student student : students) {
            System.out.println(student.getCurrentCourseNumber() + " | " + student.getFullName());
        }
    }
}