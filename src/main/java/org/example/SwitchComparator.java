package org.example;

import org.example.comparatorStudents.*;
import org.example.comparatorUniversities.*;
import org.example.enums.EnumComparatorStudents;
import org.example.enums.EnumComparatorUniversities;

public class SwitchComparator {

    private SwitchComparator() {}

    public static StudentComparator studentComparator (EnumComparatorStudents enumComparatorStudents) {
        return switch (enumComparatorStudents) {
            case SORT_BY_FULL_NAME -> new SortByFullStudentName();
            case SORT_BY_AVG_EXAM_SCORE -> new SortByAvgExamScore();
            case SORT_BY_CURRENT_COURSE_NUMBER -> new SortByCurrentCourseNumber();
            case SORT_BY_UNIVERSITY_ID -> new SortByUniversityId();
            default -> null;
        };
    }
    public static UniversityComparator universityComparator (EnumComparatorUniversities enumComparatorUniversities) {
        return switch (enumComparatorUniversities) {
            case SORT_BY_FULL_NAME -> new SortByFullUniversityName();
            case SORT_BY_ID -> new SortById();
            case SORT_BY_MAIN_PROFILE -> new SortByMainProfile();
            case SORT_BY_SHORT_NAME -> new SortByShortName();
            case SORT_BY_YEAR_OF_FOUNDATION -> new SortByYearOfFoundation();
            default -> null;
        };
    }
}