package org.example.comparatorUniversities;

import org.apache.commons.lang3.StringUtils;
import org.example.data.University;

public class SortByShortName implements UniversityComparator {
    @Override
    public int compare(University un1, University un2) {
        return StringUtils.compare(un1.getShortName(), un2.getShortName());
    }
}