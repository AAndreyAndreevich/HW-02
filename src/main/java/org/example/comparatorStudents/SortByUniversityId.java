package org.example.comparatorStudents;

import org.example.in_stock.Student;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class SortByUniversityId implements Comparator<Student> {

    @Override
    public int compare(Student st1, Student st2) {
        return StringUtils.compare(st1.getUniversityId(), st2.getUniversityId());
    }
}
