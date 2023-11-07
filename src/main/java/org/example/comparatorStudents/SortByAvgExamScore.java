package org.example.comparatorStudents;

import org.example.in_stock.Student;

public class SortByAvgExamScore implements StudentComparator {
    @Override
    public int compare(Student st1, Student st2) {
        return Float.compare(st1.getAvgExamScore(), st2.getAvgExamScore());
    }
}
