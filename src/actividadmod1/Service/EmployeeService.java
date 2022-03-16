/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;

import actividadmod1.Enum.TypeDocument;
import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.model.Document;
import actividadmod1.model.Employee;
import actividadmod1.model.Teacher;
import static actividadmod1.util.Validation.validacionesTipoDNI;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 *
 * @author JuanPC
 */
public class EmployeeService {

    Scanner entrada = new Scanner(System.in).useDelimiter("\n");

    public Teacher createEmployee() throws ExcepcionDocument {

        List<String> listCourses = new ArrayList<>();
        listCourses.add("Matemarica");
        listCourses.add("Biologia");

        //Employee employee = new Teacher();
        System.out.println("Enter Salary: ");
        Double salary = entrada.nextDouble();

        System.out.println("Enter name: ");
        String name = entrada.next();
        System.out.println("Enter Last Name: ");
        String lastName = entrada.next();

        Document document = new Document();

        boolean exit = true;
        do {
            try {
                System.out.println("Enter Type of Document: ");
                String typeDocumet = entrada.next();
                TypeDocument enumDocument = validacionesTipoDNI(typeDocumet.toUpperCase());
                document.setType(enumDocument);
                exit = false;
            } catch (ExcepcionDocument e) {
                System.out.println(e.getMessage());
            }

        } while (exit);

        System.out.println("Enter Number Document: ");
        Long numberDocumet = entrada.nextLong();

        document.setNumber(numberDocumet);

        System.out.println("Enter age: ");
        int age = entrada.nextInt();

        LocalDate dayINgreso = null;

        do {
            try {
                System.out.println("Enter age de ingreso: ");
                int ageEnter = entrada.nextInt();

                System.out.println("Enter day de ingreso: ");
                int dayEnter = entrada.nextInt();
                System.out.println("Enter month de ingreso: ");
                int monthEnter = entrada.nextInt();
                dayINgreso = LocalDate.of(ageEnter, Month.of(monthEnter), dayEnter);
            } catch (DateTimeException e) {
                System.out.println("Error al ingresar la feche.");
                System.out.println("Detalles: " + e.getMessage());
            }
        } while (dayINgreso == null);

        return new Teacher(listCourses, dayINgreso, salary, name, lastName, document, age);

    }


}
