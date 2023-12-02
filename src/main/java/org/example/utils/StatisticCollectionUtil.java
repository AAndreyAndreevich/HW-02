package org.example.utils;

import org.apache.commons.lang3.StringUtils;
import org.example.education.Statistics;
import org.example.education.Student;
import org.example.education.University;
import org.example.enums.StudyProfile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticCollectionUtil {
    private StatisticCollectionUtil(){}

    public static List<Statistics> statisticsCollection(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();
        Set<StudyProfile> studyProfiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());
        studyProfiles.forEach(studyProfile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setMainProfile(studyProfile);

            List<String> quantityUniversityProfile = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setQuantityUniversitiesByProfile(quantityUniversityProfile.size());
            statistics.setNameUniversity(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> quantityUniversityProfile.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(universityName -> statistics.setNameUniversity(
                            statistics.getNameUniversity() + universityName + ";"));
            List<Student> studentsProfiles = students.stream()
                    .filter(student -> quantityUniversityProfile.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setQuantityStudentsByProfile(studentsProfiles.size());
            OptionalDouble avgExamScore = studentsProfiles.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()
            ));
        });
        return statisticsList;
    }
}
/***    Students
 *     @SerializedName("universityId")
 *     private String universityId;
 *     @SerializedName("studentName")
 *     private String fullName;
 *     @SerializedName("course")
 *     private int currentCourseNumber;
 *     @SerializedName("avgScore")
 *     private float avgExamScore;
 */
/***    Universities
 *     @SerializedName("universityId")
 *     private String id;
 *     @SerializedName("universityName")
 *     private String fullName;
 *     @SerializedName("universityShortName")
 *     private String shortName;
 *     @SerializedName("foundation")
 *     private int yearOfFoundation;
 *     @SerializedName("profile")
 *     private StudyProfile mainProfile;
 */