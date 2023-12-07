package comparatorStudents;

import education.Student;
import org.apache.commons.lang3.StringUtils;

public class SortByUniversityId implements StudentComparator {

    @Override
    public int compare(Student st1, Student st2) {
        return StringUtils.compare(st1.getUniversityId(), st2.getUniversityId());
    }
}
