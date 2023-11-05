package org.example;

public enum StudyProfile {
    PHYSICS("Физический"), MEDICINE("Медицинский"), LINGUISTICS("Лингвистический"), MATHEMATICS("Математический");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}