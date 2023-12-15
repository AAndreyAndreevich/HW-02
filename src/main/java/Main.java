import comparatorStudents.StudentComparator;
import comparatorUniversities.UniversityComparator;
import model.*;
import enums.*;
import utils.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());
    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Отсутствует конфигурация " + e.getMessage());
        }
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

        ModelsLists modelLists = new ModelsLists()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList);
        JaxbUtil.writer(modelLists);

        logger.log(Level.INFO, "Работа с таблицами окончена");
    }
}