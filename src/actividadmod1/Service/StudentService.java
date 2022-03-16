/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;

import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.model.Document;
import actividadmod1.model.Person;
import actividadmod1.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanPC
 */
public class StudentService extends EmployeeService {
    int idStudent=1;
    public Student create() throws ExcepcionDocument {

        Student student = new Student();

        createStudent();
        student.setId(idStudent);

        student.setCourses(addCourse(new ArrayList<>()));
        student.setName(name);
        student.setLastName(lastName);
        student.setDocument(new Document(enumDocument, numberDocumet));
        student.setDateOfBirth(dateOfBirth);

        //student.setAge(age);

        idStudent++;
        return student;

    }

}
