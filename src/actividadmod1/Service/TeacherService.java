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
 * @author JuanPC
 */
public class TeacherService extends EmployeeService {
    int idTeacher = 1;

    public Teacher create() throws ExcepcionDocument {

        createTeacher();

        Teacher teacher = new Teacher();

        teacher.setListCourses(addCourse(new ArrayList<>()));
        teacher.setName(name);
        teacher.setLastName(lastName);
        teacher.setDocument(new Document(enumDocument, numberDocumet));
        teacher.setAge(age);
        teacher.setSueldo(sueldo);
        teacher.setDatePosition(datePosition);
        idTeacher++;
        return teacher;

    }

}
