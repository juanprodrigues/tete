/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;


import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.Exception.ExcepcionJDBC;
import actividadmod1.Persistence.StudendDAO;
import actividadmod1.Persistence.TeacherDAO;
import actividadmod1.model.Document;

import actividadmod1.model.Student;
import actividadmod1.model.Teacher;

import java.sql.SQLException;
import java.text.ParseException;




import java.util.*;

/**
 * @author JuanPC
 */
public class TeacherService extends EmployeeService {

    TeacherDAO teacherDAO=new TeacherDAO();

    int idTeacher = 1;

    public Teacher create() throws ExcepcionDocument, ParseException, ExcepcionJDBC {
        System.out.println("-----------------------------");
        System.out.println("CREANDO OBJETO PROFESOR");
        System.out.println("-----------------------------");
        createTeacher();

        Teacher teacher = new Teacher();

        teacher.setId(idTeacher);
        teacher.setListCourses(addCourse(new HashMap<>()));
        teacher.setName(name);
        teacher.setLastName(lastName);
        teacher.setDocument(new Document(enumDocument, numberDocumet));
        teacher.setAge(age);
        teacher.setSueldo(sueldo);
        teacher.setDateOfBirth(dateOfBirth);
        teacher.setDatePosition(datePosition);
        idTeacher++;

        teacherDAO.savedTeacher(teacher);

        return teacher;

    }
    public Teacher update(int id) throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {

        Teacher updateTeacher = teacherDAO.update(id);

        System.out.println("-----------------------------");
        System.out.println("Update OBJETO Teacher");
        System.out.println("-----------------------------");

        createTeacher();


        updateTeacher.setListCourses(addCourse(new HashMap<>()));
        updateTeacher.setName(name);
        updateTeacher.setSueldo(sueldo);
        updateTeacher.setLastName(lastName);
        updateTeacher.setDocument(new Document(enumDocument, numberDocumet));
        updateTeacher.setDateOfBirth(dateOfBirth);
        updateTeacher.setDatePosition(datePosition);

        teacherDAO.guardarUpdateTeacher(updateTeacher);

        return updateTeacher;
    }


    public void list() throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {


        System.out.println("-----------------------------");
        System.out.println("Listando OBJETO Teacher");
        System.out.println("-----------------------------");


        List<Teacher> teacherList = teacherDAO.listTeacher();

        for (Teacher teacher : teacherList) {
            System.out.println(teacher.toString());
        }

    }

    public void delete(int id) throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {


        System.out.println("-----------------------------");
        System.out.println("Eliminando OBJETO Teacher");
        System.out.println("-----------------------------");

        teacherDAO.deleteTeacher(id);

    }

}
