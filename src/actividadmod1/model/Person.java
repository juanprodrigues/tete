/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.model;

/**
 *
 * @author JuanPC
 */
public class Person {
    private String name;
    private String lastName;
    private Document document;
    private int age;

    public Person() {
    }
  public Person(String name, String lastName, Document document) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.age = 12;
    }

    public Person(String name, String lastName, Document document, int age) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", lastName=" + lastName + ", document=" + document + ", age=" + age + '}';
    }

}
