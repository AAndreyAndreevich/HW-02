package org.example.comparatorStudents;

import org.example.Student;

import java.util.Comparator;

public class SortByCurrentCourseNumber implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        if (st1.getCurrentCourseNumber() == st2.getCurrentCourseNumber()) {
            return 0;
        } else if (st1.getCurrentCourseNumber() < st2.getCurrentCourseNumber()) {
            return -1;
        } else {
            return 1;
        }
    }
}
