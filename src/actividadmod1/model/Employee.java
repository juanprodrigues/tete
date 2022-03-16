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
public class Employee extends Person {
    private LocalDate datePosition;
 
    private Double sueldo;

    public Employee() {
    }

    public Employee(LocalDate datePosition, Double sueldo, String name, String lastName, Document document, int age) {
        super(name, lastName, document, age);
        this.datePosition = datePosition;
        this.sueldo = sueldo;
    }

    public LocalDate getDatePosition() {
        return datePosition;
    }

    public void setDatePosition(LocalDate datePosition) {
        this.datePosition = datePosition;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString()+ "Employee{" + "datePosition=" + datePosition + ", sueldo=" + sueldo + '}';
    }
    
}
