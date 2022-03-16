/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.model;

import java.time.LocalDate;
import java.util.*;


/**
 *
 * @author JuanPC
 */
public class Student extends Person{
    
    private List<String> courses ;

    public Student() {
        incrementarContador();
    }

    public Student(List<String> courses, String name, String lastName, Document document, LocalDate dateOfBirth) {
        super(name, lastName, document, dateOfBirth);
        this.courses = courses;
    }


    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void addCourse(String course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Student{" + "courses=" + courses + '}'+super.toString();
    }


    
    
}
