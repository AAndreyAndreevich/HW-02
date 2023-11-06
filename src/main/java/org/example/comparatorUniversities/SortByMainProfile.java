package org.example.comparatorUniversities;

import org.example.University;

import java.util.Comparator;

public class SortByMainProfile implements Comparator<University> {
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