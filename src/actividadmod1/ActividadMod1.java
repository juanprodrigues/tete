/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1;

import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.Service.EmployeeService;
import actividadmod1.Service.PersonService;
import actividadmod1.model.Employee;
import actividadmod1.model.Person;
import actividadmod1.model.Student;
import actividadmod1.model.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanPC
 */
public class ActividadMod1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExcepcionDocument {
        // TODO code application logic here
        List<Person> listPersons=new ArrayList<>();
        
        Person person=new Person();
        PersonService personServce=new PersonService();
        
//        person=personServce.createPerson();
//        System.out.println(person.toString());
//        listPersons.add(person);
//      
//        
//        Student student=personServce.createdStudent();
//        System.out.println(student.toString());
//        System.out.println(personServce.higherAge(student.getAge()));
//        
//        personServce.obtenerContador();
        Employee employee =new Teacher();
         EmployeeService employeeService=new EmployeeService();
        employee=employeeService.createEmployee();
        System.out.println(employee.toString());
        System.out.println(employee.getClass().getName());
        listPersons.add(employee);
        
//        for (Person listPerson : listPersons) {
//            System.out.println("Lista de personas: "+listPerson.toString());
//        }
        
    }
    
}
