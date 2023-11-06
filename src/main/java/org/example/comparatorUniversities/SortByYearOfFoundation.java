package org.example.comparatorUniversities;

import org.example.in_stock.University;

import java.util.Comparator;

public class SortByYearOfFoundation implements Comparator<University> {
    @Override
    public int compare(University un1, University un2) {
        if (un1.getYearOfFoundation() == un2.getYearOfFoundation()) {
            return 0;
        } else if (un1.getYearOfFoundation() < un2.getYearOfFoundation()) {
            return -1;
        } else {
            return 1;
        }
    }
}