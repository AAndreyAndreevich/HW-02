package org.example;

import org.example.comparatorStudents.*;
import org.example.comparatorUniversities.*;
import org.example.enums.*;
import org.example.education.*;
import org.example.utils.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<University> universities =
                XSSFReader.universitiesReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        UniversityComparator universityComparator =
                SwitchComparator.universityComparator(EnumComparatorUniversities.SORT_BY_ID);
        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.universityListToJson(universities);
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        List<Student> students =
                XSSFReader.studentsReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        StudentComparator studentComparator =
                SwitchComparator.studentComparator(EnumComparatorStudents.SORT_BY_UNIVERSITY_ID);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });
    }
}