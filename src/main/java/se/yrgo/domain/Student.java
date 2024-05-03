package se.yrgo.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String enrollmentID;
    private String name;
    
    @Column (name="NUM_COURSES")
    private Integer numberOfCourses;


    public Student() {}

    public Student(String name)
    {
    	this.name = name;
        this.numberOfCourses = 10;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Student name: " + name + "\nNumber of courses: " + numberOfCourses;
    }

}
