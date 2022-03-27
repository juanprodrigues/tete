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
public class Student extends Employee{
    
    private HashMap<Integer, String> courses ;

    public Student() {
    }

    public Student(HashMap<Integer, String> courses, LocalDate datePosition, String name, String lastName, Document document, LocalDate dateOfBirth) {
        super(datePosition, name, lastName, document, dateOfBirth);
        this.courses = courses;
    }

    public HashMap<Integer, String> getCourses() {
        return courses;
    }

    public void setCourses(HashMap<Integer, String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" + "courses=" + courses + '}'+" "+toStringStudent();
    }


    
    
}
