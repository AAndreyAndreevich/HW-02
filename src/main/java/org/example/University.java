package org.example;

import org.example.enums.StudyProfile;

public class University {
    String id, fullName, shortName;
    int yearOfFoundation;
    StudyProfile mainProfile;

    public University() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "\nНомер Университета: " + id +
                "\nПолное название Университета: " + fullName +
                "\nАббревиатура Университета: " + shortName +
                "\nГод основания Университета: " + yearOfFoundation +
                "\nПрофиль обучения Университета: " + mainProfile + "\n";
    }
}