import comparatorStudents.StudentComparator;
import comparatorUniversities.UniversityComparator;
import education.*;
import enums.*;
import utils.*;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Path universityInfoPath = Path.of("src\\main\\resources\\universityInfo.xlsx");
        Path statisticsPath = Path.of("src\\main\\resources\\statistics.xlsx");
        List<University> universities =
                XSSFReader.universitiesReader(universityInfoPath);
        UniversityComparator universityComparator =
                SwitchComparator.universityComparator(EnumComparatorUniversities.SORT_BY_ID);
        universities.sort(universityComparator);

        List<Student> students =
                XSSFReader.studentsReader(universityInfoPath);
        StudentComparator studentComparator =
                SwitchComparator.studentComparator(EnumComparatorStudents.SORT_BY_UNIVERSITY_ID);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticCollectionUtil.statisticsCollection(students, universities);
        XLSWriter.statisticsWriter(statisticsList, statisticsPath);
    }
}