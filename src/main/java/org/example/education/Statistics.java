package org.example.education;

import org.example.enums.StudyProfile;

public class Statistics {
    private StudyProfile mainProfile;
    private float avgExamScore;
    private int quantityStudentsByProfile;
    private int quantityUniversitiesByProfile;
    private String nameUniversity;

    public Statistics(){}

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getQuantityStudentsByProfile() {
        return quantityStudentsByProfile;
    }

    public void setQuantityStudentsByProfile(int quantityStudentsByProfile) {
        this.quantityStudentsByProfile = quantityStudentsByProfile;
    }

    public int getQuantityUniversitiesByProfile() {
        return quantityUniversitiesByProfile;
    }

    public void setQuantityUniversitiesByProfile(int quantityUniversitiesByProfile) {
        this.quantityUniversitiesByProfile = quantityUniversitiesByProfile;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }
}