package org.example.comparatorUniversities;

import org.example.education.University;

public class SortByMainProfile implements UniversityComparator {
    @Override
    public int compare(University un1, University un2) {
        if (un1.getMainProfile() == un2.getMainProfile()) {
            return 0;
        } else if (un1.getMainProfile() != un2.getMainProfile()) {
            return -1;
        } else {
            return 1;
        }
    }
}