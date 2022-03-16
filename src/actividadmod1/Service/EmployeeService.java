/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;

import actividadmod1.Enum.TypeDocument;
import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.model.Document;
import actividadmod1.model.Person;
import actividadmod1.util.Validation;

import static actividadmod1.util.Validation.*;
import java.time.LocalDate;

import java.util.*;

/**
 *
 * @author JuanPC
 */
public class EmployeeService {

    protected String name;

    protected String lastName;

    protected String typeDocumet;

    protected Long numberDocumet;

    protected int age;

    protected TypeDocument enumDocument;

    //student
    protected List<String> listCourses = new ArrayList<>();

    protected String courses;

    //teacher
    protected Double sueldo;

    protected LocalDate datePosition;

    protected LocalDate dateOfBirth;

    //director
    protected String career;

    Scanner entrada = new Scanner(System.in).useDelimiter("\n");

    public void createPerson() throws ExcepcionDocument {

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
                
                System.out.println("Enter Number Document: ");
                numberDocumet = entrada.nextLong();
                Validation.validacionInicoID(numberDocumet);
                document.setNumber(numberDocumet);
                break;
            } catch (ExcepcionDocument e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println("Information Date of Birday. ");
        dateOfBirth = dateIngreso("Cumpleanos");
    }

    public void createStudent() throws ExcepcionDocument {

        createPerson();

        System.out.println("Information de ingreso: ");
        datePosition = dateIngreso("ingreso");

        //muestra si es mayor de edad
        System.out.println(higherAge(age));
        //incrementa el contador


        //addCourse(listCourses1);
        //listCourses.clear();
    }

    public void createTeacher() throws ExcepcionDocument {
        List<String> listCourses2 = new ArrayList<>();
        createPerson();

        //addCourse(listCourses2);
        SueldoAndDateIngreso();

    }

    public void createDirector() throws ExcepcionDocument {

        createPerson();

        System.out.println("Ingrese Carrera: ");
        career = entrada.next();

    }

    public void createAdministrativo() throws ExcepcionDocument {

        createPerson();

        SueldoAndDateIngreso();

    }

    public void SueldoAndDateIngreso() {

        System.out.println("Ingrese sueldo: ");
        sueldo = entrada.nextDouble();

        System.out.println("Information de Fecha de Cargo: ");
        datePosition = dateIngreso("Cargo");
    }

    public LocalDate dateIngreso(String type) {
        return validacionFecha(type);
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


    public String higherAge(int age) {
        if (age >= 18) {
            return "If you are of age.";
        } else {
            return "He is not of age.";
        }
    }

    private void validacionInicoID(List<Person> listPersons, Long numberDocumet1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
