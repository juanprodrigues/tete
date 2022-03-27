/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;

import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.Exception.ExcepcionJDBC;
import actividadmod1.Persistence.StudendDAO;
import actividadmod1.model.Document;
import actividadmod1.model.Person;
import actividadmod1.model.Student;

import java.sql.SQLException;
import java.text.ParseException;

import java.util.*;
import java.util.List;

/**
 * @author JuanPC
 */
public class StudentService extends EmployeeService {
    StudendDAO studendDAO = new StudendDAO();
    int idStudent = 1;

    public Student create() throws ExcepcionDocument, ParseException, ExcepcionJDBC {

        Student student = new Student();
        System.out.println("-----------------------------");
        System.out.println("CREANDO OBJERO ESTUDIANTE");
        System.out.println("-----------------------------");

        createStudent();
        student.setId(idStudent);

        student.setCourses(addCourse(new HashMap<>()));
        student.setName(name);
        student.setLastName(lastName);
        student.setDocument(new Document(enumDocument, numberDocumet));
        student.setDateOfBirth(dateOfBirth);
        student.setDatePosition(datePosition);
        //student.setAge(age);

        idStudent++;
        studendDAO.guardarUsuario(student);
        return student;

    }

    public Student update(int id) throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {

        Student updateStudent = studendDAO.update(id);

        System.out.println("-----------------------------");
        System.out.println("CREANDO OBJERO ESTUDIANTE");
        System.out.println("-----------------------------");

        createStudent();


        updateStudent.setCourses(addCourse(new HashMap<>()));
        updateStudent.setName(name);
        updateStudent.setLastName(lastName);
        updateStudent.setDocument(new Document(enumDocument, numberDocumet));
        updateStudent.setDateOfBirth(dateOfBirth);
        updateStudent.setDatePosition(datePosition);

        studendDAO.guardarUpdateStudent(updateStudent);

        return null;
    }


    public void list() throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {


        System.out.println("-----------------------------");
        System.out.println("Listando OBJERO ESTUDIANTE");
        System.out.println("-----------------------------");


        List<Student> usuarios = studendDAO.listStudend();

        for (Student student : usuarios) {
            System.out.println(student.toString());
        }

    }

    public void delete(int id) throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {


        System.out.println("-----------------------------");
        System.out.println("Eliminando OBJERO ESTUDIANTE");
        System.out.println("-----------------------------");

        studendDAO.deleteStudent(id);

    }
}
