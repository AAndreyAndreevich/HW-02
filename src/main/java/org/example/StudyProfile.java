package org.example;

public enum StudyProfile {
    DENTIST("Дантист"), SURGEON("Хирург"), PSYCHIATRIST("Психиатр");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}