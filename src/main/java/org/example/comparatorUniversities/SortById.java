package org.example.comparatorUniversities;

import org.apache.commons.lang3.StringUtils;
import org.example.in_stock.University;

import java.util.Comparator;

public class SortById implements Comparator<University> {
    @Override
    public int compare(University un1, University un2) {
        return StringUtils.compare(un1.getId(), un2.getId());
    }
}