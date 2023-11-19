package org.example.enums;

public enum EnumComparatorUniversities {
    SORT_BY_FULL_NAME("Сортировка по названию"),
    SORT_BY_ID("Сортировка по уникальному номеру"),
    SORT_BY_MAIN_PROFILE("Сортировка по обучаемой специальности"),
    SORT_BY_SHORT_NAME("Сортировка по аббревиатуре"),
    SORT_BY_YEAR_OF_FOUNDATION("Сортировка по году основания");

    private final String currentComparator;

    EnumComparatorUniversities(String currentComparator) {
        this.currentComparator = currentComparator;
    }

    public String getCurrentComparatorUniversities() {
        return this.currentComparator;
    }
}