/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;

import actividadmod1.model.Document;
import actividadmod1.model.Person;
import actividadmod1.model.Student;
import actividadmod1.model.Teacher;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanPC
 */
public class pruebaHija extends pruebaHerencia {

    public void we() {


        
       

        createStudent();
        Document document = new Document(enumDocument, numberDocumet);
       // Student asdasd=new Student(contador, addCourse(new ArrayList<>()), name, lastName, document, dateOfBirth);
         //System.out.println(asdasd.toString());
         
    
        createTeacher();
 
        //Teacher asdasd1=new Teacher(( addCourse(new ArrayList<>())), datePosition, datePosition, sueldo, name, lastName, new Document(enumDocument, numberDocumet));
        //( addCourse(new ArrayList<>()), datePosition, sueldo, name, lastName, new Document(enumDocument, numberDocumet), age);
//         System.out.println(asdasd1.toString());
//         System.out.println(asdasd.toString());
    }

}
