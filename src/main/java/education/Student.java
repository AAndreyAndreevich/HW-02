package education;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("universityId")
    private String universityId;
    @SerializedName("studentName")
    private String fullName;
    @SerializedName("course")
    private int currentCourseNumber;
    @SerializedName("avgScore")
    private float avgExamScore;

    public Student() {}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "\nПолное имя студента: " + fullName +
                "\nНомер Университета студента: " + universityId +
                "\nКурс студента: " + currentCourseNumber +
                "\nСредний экзаменационный балл студента: " + avgExamScore + "\n";
    }
}