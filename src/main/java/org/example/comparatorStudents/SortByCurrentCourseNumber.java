package org.example.comparatorStudents;

import org.example.data.Student;

public class SortByCurrentCourseNumber implements StudentComparator {
    @Override
    public int compare(Student st1, Student st2) {
        return Integer.compare(st1.getCurrentCourseNumber(), st2.getCurrentCourseNumber());
    }
}
