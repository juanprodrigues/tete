/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;

import actividadmod1.Enum.TypeDocument;
import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.model.Document;
import static actividadmod1.util.Validation.validacionFecha;
import static actividadmod1.util.Validation.validacionesTipoDNI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JuanPC
 */
public class pruebaHerencia {

    protected static int contador = 0;

    protected String name;

    protected String lastName;

    protected String typeDocumet;

    protected Long numberDocumet;

    protected int age;

    protected String enumDocument;

     protected LocalDate dateOfBirth;
    
    //student
    protected List<String> listCourses = new ArrayList<>();

    protected String courses;

    //teacher
    protected Double sueldo;

    protected LocalDate datePosition;

    //director
    protected String career;

    Scanner entrada = new Scanner(System.in).useDelimiter("\n");

    public void createPerson() {

        System.out.println("Enter name: ");
        name = entrada.next();
        System.out.println("Enter Last Name: ");
        lastName = entrada.next();

        Document document = new Document();

        while (true) {
            try {
                System.out.println("Enter Type of Document: ");
                typeDocumet = entrada.next();

                enumDocument = validacionesTipoDNI(typeDocumet.toUpperCase());

                break;
            } catch (ExcepcionDocument e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println("Enter Number Document: ");
        numberDocumet = entrada.nextLong();

        document.setNumber(numberDocumet);

        System.out.println("Enter age: ");
        age = entrada.nextInt();

    }

    public void createStudent() {
        List<String> listCourses1 = new ArrayList<>();
        createPerson();

        System.out.println("Ingrese Fecha de ingreso: ");
        dateIngreso();

        //addCourse(listCourses1);

        //listCourses.clear();

    }

    public void createTeacher() {
        List<String> listCourses2 = new ArrayList<>();
        createPerson();

        //addCourse(listCourses2);

        SueldoAndDateIngreso();

    }

    public void createDirector() {

        createPerson();

        System.out.println("Ingrese Carrera: ");
        career = entrada.next();

    }

    public void createAdministrativo() {

        createPerson();

        SueldoAndDateIngreso();

    }

    public void SueldoAndDateIngreso() {

        System.out.println("Ingrese sueldo: ");
        sueldo = entrada.nextDouble();

        System.out.println("Ingrese Fecha de Cargo: ");
        dateIngreso();
    }

    public void dateIngreso() {
        //datePosition = validacionFecha();
    }

    public List<String> addCourse(List<String> listC) {
        while (true) {
            System.out.println("Enter name asignature or q to exit: ");
            courses = entrada.next();
            if (courses.equals("q")) {
                break;
            }
            listC.add(courses);
        }
        return listC;
    }

    private void incrementarContador() {
        contador++;
    }

    public int obtenerContador() {
        return contador;
    }

    public String higherAge(int age) {
        if (age >= 18) {
            return "If you are of age.";
        } else {
            return "He is not of age.";
        }
    }

}
