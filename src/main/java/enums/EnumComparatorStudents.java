package enums;

public enum EnumComparatorStudents {
    SORT_BY_AVG_EXAM_SCORE("Сортировка по среднему баллу"),
    SORT_BY_CURRENT_COURSE_NUMBER("Сортировка по номеру курса"),
    SORT_BY_FULL_NAME("Сортировка по полному имени"),
    SORT_BY_UNIVERSITY_ID("Сортировка по уникальному номеру Университета");

    private final String currentComparator;

    EnumComparatorStudents(String currentComparator) {
        this.currentComparator = currentComparator;
    }

    public String getCurrentComparatorStudents() {
        return this.currentComparator;
    }
}