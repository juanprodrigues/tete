/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author JuanPC
 */
public class Employee extends Person {

    private LocalDate datePosition;

    private Double sueldo;

    public Employee() {
    }

    public Employee(LocalDate datePosition, String name, String lastName, Document document, LocalDate dateOfBirth) {
        super(name, lastName, document, dateOfBirth);
        this.datePosition = datePosition;
    }

    public Employee(LocalDate datePosition, Double sueldo, String name, String lastName, Document document, LocalDate dateOfBirth) {
        super(name, lastName, document, dateOfBirth);
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

    public String getDatePositionString() {
        return stringToLOcalDate(this.datePosition, true);
    }

    @Override
    public String toString() {
        return "Employee{" + "datePosition=" + stringToLOcalDate(this.datePosition, false) + ", sueldo=" + sueldo + '}' + super.toString();
    }


    public String toStringStudent() {
        return "Employee{" + "dateIngreso=" + stringToLOcalDate(this.datePosition, false) + '}' + " " + super.toString();
    }

}
