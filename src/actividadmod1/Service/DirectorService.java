/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;

import actividadmod1.Enum.TypeDocument;
import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.model.Director;
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
public class DirectorService extends EmployeeService {

    int idDirector = 1;

    public Director create() throws ExcepcionDocument {

        createDirector();

        Director director = new Director();

        director.setName(name);
        director.setLastName(lastName);
        director.setDocument(new Document(enumDocument, numberDocumet));
        director.setAge(age);
        director.setSueldo(sueldo);
        director.setDatePosition(datePosition);
        director.setCareer(career);
        idDirector++;
        return director;

    }
}
