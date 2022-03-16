/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.model;

import java.util.*;


/**
 *
 * @author JuanPC
 */
public class Student extends Person{
    
    private int id;
    private List<String> courses ;

    public Student() {
    }

    public Student(int id, List<String> courses, String name, String lastName, Document document, int age) {
        super(name, lastName, document, age);
        this.id = id;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Student{" + "id=" + id + ", courses=" + courses + '}'+" "+super.toString();
    }
    
    
}
