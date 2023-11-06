package org.example.comparatorStudents;

import org.example.Student;

import java.util.Comparator;

public class SortByAvgExamScore implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        if (st1.getAvgExamScore() == st2.getAvgExamScore()) {
            return 0;
        } else if (st1.getAvgExamScore() > st2.getAvgExamScore()) {
            return -1;
        } else {
            return 1;
        }
    }
}
