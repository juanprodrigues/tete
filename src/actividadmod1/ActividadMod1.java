/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1;

import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.Service.PersonService;
import actividadmod1.Service.StudentService;
import actividadmod1.Service.TeacherService;
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

    public static List<Person> listPersons = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExcepcionDocument {
        // TODO code application logic here

        Person person = new Person();
        PersonService personServce = new PersonService();

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
//        Employee employee =new Teacher();
//         EmployeeService employeeService=new EmployeeService();
//        employee=employeeService.createEmployee();
//        System.out.println(employee.toString());
//        System.out.println(employee.getClass().getName());
//        listPersons.add(employee);
//        for (Person listPerson : listPersons) {
//            System.out.println("Lista de personas: "+listPerson.toString());
//        }
        StudentService studentService = new StudentService();
        
        Student student = studentService.create();
        listPersons.add(student);
        
        Student student2 = studentService.create();
        listPersons.add(student2);

//        TeacherService teacherService = new TeacherService();
//        Teacher teacher = teacherService.create();
//        listPersons.add(teacher);

//        DirectorService directorService = new DirectorService();
//        Director director = directorService.create();
//        listPersons.add(director);
//
//        AdministrativeService administrativeService = new AdministrativeService();
//        Administrative administrative = administrativeService.create();
//        listPersons.add(administrative);
        for (Person listPerson : listPersons) {
            System.out.println("Lista de personas: \n" + listPerson.toString());
        }

    }

}
