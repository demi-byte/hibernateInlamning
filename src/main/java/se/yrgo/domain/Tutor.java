package se.yrgo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tutor {

    private String tutorId;
    private String name;
    private int salary;

    @OneToMany
    private List<Student> teachingGroup;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Tutor() {
    }

    public Tutor(String tutorId, String name, int salary) {
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
        teachingGroup = new ArrayList<>();
    }

    public void addStudentToTeachingGroup(Student student) {
        teachingGroup.add(student);
    }

    public List<Student> getTeachingGroup() {
        List<Student>unmodifiable= 
                Collections.unmodifiableList(teachingGroup);
        return unmodifiable;
    }

    public String getTutorId() {
        return tutorId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + tutorId
                + "\nNAME: " + name
                + "\nSALARY: " + salary;
    }

}
