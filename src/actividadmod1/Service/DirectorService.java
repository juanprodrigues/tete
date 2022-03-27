/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;

import actividadmod1.Enum.TypeDocument;
import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.Exception.ExcepcionJDBC;
import actividadmod1.Persistence.AdministrativeDAO;
import actividadmod1.Persistence.DirectorDAO;
import actividadmod1.model.*;

import static actividadmod1.util.Validation.validacionesTipoDNI;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 *
 * @author JuanPC
 */
public class DirectorService extends EmployeeService {

    DirectorDAO directorDAO=new DirectorDAO();

    int idDirector = 1;

    public Director create() throws ExcepcionDocument, ParseException, ExcepcionJDBC {
        System.out.println("-----------------------------");
        System.out.println("CREANDO OBJETO DIRECTOR");
        System.out.println("-----------------------------");

        createDirector();

        Director director = new Director();

        director.setId(idDirector);
        director.setName(name);
        director.setLastName(lastName);
        director.setDocument(new Document(enumDocument, numberDocumet));

        director.setSueldo(sueldo);
        director.setDatePosition(datePosition);
        director.setDateOfBirth(dateOfBirth);

        director.setCareer(career);

        idDirector++;

        directorDAO.savedDirector(director);

        return director;

    }
    public Director update(int id) throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {

        Director updateDirector = directorDAO.update(id);

        System.out.println("-----------------------------");
        System.out.println("CREANDO OBJETO Director");
        System.out.println("-----------------------------");

        createDirector();


        updateDirector.setName(name);
        updateDirector.setCareer(career);
        updateDirector.setLastName(lastName);
        updateDirector.setDocument(new Document(enumDocument, numberDocumet));
        updateDirector.setDateOfBirth(dateOfBirth);
        updateDirector.setDatePosition(datePosition);

        directorDAO.guardarUpdateDirector(updateDirector);

        return updateDirector;
    }


    public void list() throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {


        System.out.println("-----------------------------");
        System.out.println("Listando OBJETO Director");
        System.out.println("-----------------------------");


        List<Director> director = directorDAO.listDirector();

        for (Director student : director) {
            System.out.println(student.toString());
        }

    }

    public void delete(int id) throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {


        System.out.println("-----------------------------");
        System.out.println("Eliminando OBJETO Director");
        System.out.println("-----------------------------");

        directorDAO.deleteDirector(id);

    }
}

