/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author JuanPC
 */
public class Teacher extends Employee {

    private HashMap<Integer, String> listCourses;

    public Teacher() {
    }

    public Teacher(HashMap<Integer, String> listCourses, LocalDate datePosition, Double sueldo, String name, String lastName, Document document, LocalDate dateOfBirth) {
        super(datePosition, sueldo, name, lastName, document, dateOfBirth);
        this.listCourses = listCourses;
    }

    public HashMap<Integer, String> getListCourses() {
        return listCourses;
    }

    public void setListCourses(HashMap<Integer, String> listCourses) {
        this.listCourses = listCourses;
    }

    @Override
    public String toString() {
        return "Teacher{" + "listCourses=" + listCourses + '}' + " " + super.toString();
    }

}
