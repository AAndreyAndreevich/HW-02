package model;

import enums.StudyProfile;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Статистика")
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @XmlElement(name = "profile")
    private StudyProfile profile;

    @XmlElement(name = "avg")
    private float avgExamScore;

    @XmlElement(name = "numberOfStudents")
    private int numberOfStudents;

    @XmlElement(name = "numberOfUniversities")
    private int numberOfUniversities;

    @XmlElement(name = "universityName")
    private String universityName;

    public Statistics(){}

    public StudyProfile getProfile() {
        return profile;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public Statistics setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    public Statistics setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
        return this;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Statistics setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }
}