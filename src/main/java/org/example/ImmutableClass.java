package org.example;

import org.example.comparatorStudents.*;
import org.example.comparatorUniversities.*;
import org.example.enums.EnumComparatorStudents;
import org.example.enums.EnumComparatorUniversities;

public class ImmutableClass {

    private ImmutableClass () {}

    public static StudentComparator studentComparator (EnumComparatorStudents enumComparatorStudents) {
        switch (enumComparatorStudents) {
            case SORT_BY_AVG_EXAM_SCORE:
                return (StudentComparator) new SortByAvgExamScore();
            case SORT_BY_CURRENT_COURSE_NUMBER:
                return (StudentComparator) new SortByCurrentCourseNumber();
            case SORT_BY_UNIVERSITY_ID:
                return (StudentComparator) new SortByUniversityId();
            default:
                return (StudentComparator) new SortByFullStudentName();
        }
    }
    public static UniversityComparator universityComparator (EnumComparatorUniversities enumComparatorUniversities) {
        switch (enumComparatorUniversities) {
            case SORT_BY_ID:
                return (UniversityComparator) new SortById();
            case SORT_BY_MAIN_PROFILE:
                return (UniversityComparator) new SortByMainProfile();
            case SORT_BY_SHORT_NAME:
                return (UniversityComparator) new SortByShortName();
            case SORT_BY_YEAR_OF_FOUNDATION:
                return (UniversityComparator) new SortByYearOfFoundation();
            default:
                return (UniversityComparator) new SortByFullUniversityName();
        }
    }
}