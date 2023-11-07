package org.example.comparatorUniversities;

import org.example.in_stock.University;

public class SortByYearOfFoundation implements UniversityComparator {
    @Override
    public int compare(University un1, University un2) {
        return Integer.compare(un1.getYearOfFoundation(), un2.getYearOfFoundation());
    }
}