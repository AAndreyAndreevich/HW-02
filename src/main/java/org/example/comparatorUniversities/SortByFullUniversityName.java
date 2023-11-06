package org.example.comparatorUniversities;

import org.apache.commons.lang3.StringUtils;
import org.example.University;

import java.util.Comparator;

public class SortByFullUniversityName implements Comparator<University> {
    @Override
    public int compare(University un1, University un2) {
        return StringUtils.compare(un1.getFullName(), un2.getFullName());
    }
}