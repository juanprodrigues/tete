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
public class Person {

    private int id=0;

    private String name;
    private String lastName;
    private Document document;
    private int age;
    private LocalDate dateOfBirth;

    public Person() {

    }

    public Person(String name, String lastName, Document document, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String name, String lastName, Document document, int age, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public int getAge() {
        return age;

    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;

        LocalDate today = LocalDate.now();

        if (dateOfBirth.getMonthValue() >= today.getMonthValue()) {
            this.age = today.getYear() - dateOfBirth.getYear() - 1;
        } else {
            this.age = today.getYear() - dateOfBirth.getYear();
        }

    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", document=" + document + ", age=" + age + ", dateOfBirth=" + dateOfBirth + '}';
    }

}
