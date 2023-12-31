package utils;

import org.apache.commons.lang3.StringUtils;
import model.Statistics;
import model.Student;
import model.University;
import enums.StudyProfile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatisticCollectionUtil {
    private static final Logger logger = Logger.getLogger(StatisticCollectionUtil.class.getSimpleName());
    private StatisticCollectionUtil(){}

    public static List<Statistics> statisticsCollection(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();
        try {
            Set<StudyProfile> profiles = universities.stream()
                    .map(University::getMainProfile)
                    .collect(Collectors.toSet());
            profiles.forEach(profile -> {
                Statistics statistics = new Statistics();
                statisticsList.add(statistics);
                statistics.setProfile(profile);
                List<String> profileUniversityIds = universities.stream()
                        .filter(university -> university.getMainProfile().equals(profile))
                        .map(University::getId)
                        .collect(Collectors.toList());
                statistics.setNumberOfUniversities(profileUniversityIds.size());
                statistics.setUniversityName(StringUtils.EMPTY);
                universities.stream()
                        .filter(university -> profileUniversityIds.contains(university.getId()))
                        .map(University::getFullName)
                        .forEach(fullNameUniversity -> statistics.setUniversityName(
                                statistics.getUniversityName() + fullNameUniversity + ";"));
                List<Student> profileStudents = students.stream()
                        .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                        .collect(Collectors.toList());
                statistics.setNumberOfStudents(profileStudents.size());
                OptionalDouble avgExamScore = profileStudents.stream()
                        .mapToDouble(Student::getAvgExamScore)
                        .average();
                statistics.setAvgExamScore(0);
                avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                        (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
            });
            logger.info("Собрана статистика Университетов");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Ошибка {0}", e.getMessage());
        }
        return statisticsList;
    }
}