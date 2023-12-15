package comparatorStudents;

import model.Student;

public class SortByAvgExamScore implements StudentComparator {
    @Override
    public int compare(Student st1, Student st2) {
        return Float.compare(st2.getAvgExamScore(), st1.getAvgExamScore());
    }
}
