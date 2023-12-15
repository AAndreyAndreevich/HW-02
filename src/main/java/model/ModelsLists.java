package model;

import jakarta.xml.bind.annotation.*;

import java.util.Date;
import java.util.List;

@XmlRootElement(name = "Данные")
@XmlAccessorType(XmlAccessType.FIELD)
public class ModelsLists {
    @XmlElementWrapper(name = "studentList")
    @XmlElement(name = "studentList")
    private List<Student> studentList;
    @XmlElementWrapper(name = "universityList")
    @XmlElement(name = "universityList")
    private List<University> universityList;
    @XmlElementWrapper(name = "statisticsList")
    @XmlElement(name = "statisticsList")
    private List<Statistics> statisticsList;
    @XmlElement(name = "date")
    private Date date;

    public ModelsLists() {
    }

    public ModelsLists setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public ModelsLists setUniversityList(List<University> universityList) {
        this.universityList = universityList;
        return this;
    }

    public ModelsLists setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public ModelsLists setDate(Date date) {
        this.date = date;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }
}