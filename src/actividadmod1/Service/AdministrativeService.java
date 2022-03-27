/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;

import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.Exception.ExcepcionJDBC;
import actividadmod1.Persistence.AdministrativeDAO;
import actividadmod1.Persistence.StudendDAO;
import actividadmod1.model.Administrative;
import actividadmod1.model.Director;
import actividadmod1.model.Document;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author JuanPC
 */
public class AdministrativeService extends EmployeeService {

    AdministrativeDAO administrativeDAO=new AdministrativeDAO();


    int idAdminstrative = 1;
    
    public Administrative create() throws ExcepcionDocument, ParseException, ExcepcionJDBC {
        System.out.println("-----------------------------");
        System.out.println("CREANDO OBJETO ADMINISTRATIVO");
        System.out.println("-----------------------------");

        createAdministrativo();
        
        Administrative administrative = new Administrative();
        
        administrative.setId(idAdminstrative);
        administrative.setName(name);
        administrative.setLastName(lastName);
        administrative.setDocument(new Document(enumDocument, numberDocumet));
        administrative.setAge(age);
        
        administrative.setSueldo(sueldo);
        administrative.setDatePosition(dateOfBirth);
        administrative.setDateOfBirth(datePosition);
        idAdminstrative++;

        administrativeDAO.savedAdministrative(administrative);
        return administrative;
        
    }
    public Administrative update(int id) throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {

        Administrative updateAdministrative = administrativeDAO.update(id);

        System.out.println("-----------------------------");
        System.out.println("CREANDO OBJETO Director");
        System.out.println("-----------------------------");

        createAdministrativo();


        updateAdministrative.setName(name);
        updateAdministrative.setLastName(lastName);
        updateAdministrative.setDocument(new Document(enumDocument, numberDocumet));
        updateAdministrative.setDateOfBirth(dateOfBirth);
        updateAdministrative.setDatePosition(datePosition);
        updateAdministrative.setSueldo(sueldo);
        administrativeDAO.guardarUpdateAdministrative(updateAdministrative);

        return updateAdministrative;
    }


    public void list() throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {


        System.out.println("-----------------------------");
        System.out.println("Listando OBJETO Director");
        System.out.println("-----------------------------");


        List<Administrative> administrativeList = administrativeDAO.listAdministrative();

        for (Administrative administrative : administrativeList) {
            System.out.println(administrative.toString());
        }

    }

    public void delete(int id) throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {


        System.out.println("-----------------------------");
        System.out.println("Eliminando OBJETO Director");
        System.out.println("-----------------------------");

        administrativeDAO.deleteAdministrative(id);

    }
}
