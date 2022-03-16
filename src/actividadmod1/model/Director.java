/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.model;

import java.time.LocalDate;

/**
 *
 * @author JuanPC
 */
public class Director extends Employee{
    private String career;

    public Director() {
    }

    public Director(String career, LocalDate datePosition, Double sueldo, String name, String lastName, Document document, int age) {
        super(datePosition, sueldo, name, lastName, document, age);
        this.career = career;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    @Override
    public String toString() {
        return super.toString()+ "Director{" + "career=" + career + '}';
    }
    
}
