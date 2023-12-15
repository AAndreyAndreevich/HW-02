package model;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Студенты")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlElement(name = "universityId")
    @SerializedName("universityId")
    private String universityId;

    @XmlElement(name = "name")
    @SerializedName("name")
    private String fullName;

    @XmlElement(name = "course")
    @SerializedName("course")
    private int currentCourseNumber;

    @XmlElement(name = "avg")
    @SerializedName("avgScore")
    private float avgExamScore;

    public Student() {}

    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public String toString() {
        return "\nПолное имя студента: " + fullName +
                "\nНомер Университета студента: " + universityId +
                "\nКурс студента: " + currentCourseNumber +
                "\nСредний экзаменационный балл студента: " + avgExamScore + "\n";
    }
}