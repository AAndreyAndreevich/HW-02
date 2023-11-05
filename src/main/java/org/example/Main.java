package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<University> universities =
                XSSFReader.universitiesReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        System.out.println("Университеты");
        for (University university : universities) {
            System.out.println(university);
        }

        List<Student> students =
                XSSFReader.studentsReader("D:\\an projects\\HW-02\\src\\main\\resources\\universityInfo.xlsx");
        System.out.println("Студенты");
        for(Student student : students) {
            System.out.println(student);
        }
    }
}