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
import actividadmod1.model.Student;
import static actividadmod1.util.Validation.validacionesTipoDNI;
import java.util.Scanner;

/**
 *
 * @author JuanPC
 */
public class PersonService {
//
//    private static int contador = 0;
//    Scanner entrada = new Scanner(System.in).useDelimiter("\n");
//
//    public Person create() {
//        Person person = new Person();
//
//        System.out.println("Enter name: ");
//        String name = entrada.next();
//        System.out.println("Enter Last Name: ");
//        String lastName = entrada.next();
//
//        Document document = new Document();
//
//        boolean exit = true;
//        do {
//            try {
//                System.out.println("Enter Type of Document: ");
//                String typeDocumet = entrada.next();
//                TypeDocument enumDocument = validacionesTipoDNI(typeDocumet.toUpperCase());
//                document.setType(enumDocument);
//                exit = false;
//            } catch (ExcepcionDocument e) {
//                System.out.println(e.getMessage());
//            }
//
//        } while (exit);
//        System.out.println("Enter Number Document: ");
//        Long numberDocumet = entrada.nextLong();
//
//        document.setNumber(numberDocumet);
//
//        System.out.println("Enter age: ");
//        int age = entrada.nextInt();
//
//        person.setName(name);
//        person.setLastName(lastName);
//        person.setDocument(document);
//        person.setAge(age);
//        return person;
//
//    }
//
//    public Student createdStudent() {
//        Student student = new Student();
//
//        System.out.println("Enter name: ");
//        String name = entrada.next();
//        System.out.println("Enter Last Name: ");
//        String lastName = entrada.next();
//
//        Document document = new Document();
//
//        boolean exit = true;
//        do {
//            try {
//                System.out.println("Enter Type of Document: ");
//                String typeDocumet = entrada.next();
//                TypeDocument enumDocument = validacionesTipoDNI(typeDocumet.toUpperCase());
//                document.setType(enumDocument);
//                exit = false;
//            } catch (ExcepcionDocument e) {
//                System.out.println(e.getMessage());
//            }
//
//        } while (exit);
//        System.out.println("Enter Number Document: ");
//        Long numberDocumet = entrada.nextLong();
//
//        document.setNumber(numberDocumet);
//
//        System.out.println("Enter age: ");
//        int age = entrada.nextInt();
//
//        incrementarContador();
//        student.setName(name);
//        student.setLastName(lastName);
//        student.setDocument(document);
//        student.setAge(age);
//
//        return student;
//
//    }
//
//    private void incrementarContador() {
//        contador++;
//    }
//
//    public int obtenerContador() {
//        return contador;
//    }
//
//    public String higherAge(int age) {
//        if (age >= 18) {
//            return "If you are of age.";
//        } else {
//            return "He is not of age.";
//        }
//    }

}
