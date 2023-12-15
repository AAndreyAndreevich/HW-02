package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Университеты")
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @XmlElement(name = "id")
    @SerializedName("id")
    private String id;

    @XmlElement(name = "name")
    @SerializedName("name")
    private String fullName;

    @XmlElement(name = "shortName")
    @SerializedName("shortName")
    private String shortName;

    @XmlElement(name = "yearOfFoundation")
    @SerializedName("yearOfFoundation")
    private int yearOfFoundation;

    @XmlElement(name = "profile")
    @SerializedName("profile")
    private StudyProfile mainProfile;

    public University() {}

    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
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