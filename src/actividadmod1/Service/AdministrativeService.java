/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Service;


import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.model.Administrative;
import actividadmod1.model.Document;


/**
 *
 * @author JuanPC
 */
public class AdministrativeService extends EmployeeService {

    int idAdminstrative = 1;

    public Administrative create() throws ExcepcionDocument {

        createAdministrativo();

        Administrative administrative = new Administrative();

        administrative.setName(name);
        administrative.setLastName(lastName);
        administrative.setDocument(new Document(enumDocument, numberDocumet));
        administrative.setAge(age);

        administrative.setSueldo(sueldo);
        administrative.setDatePosition(datePosition);
        idAdminstrative++;
        
        return administrative;

    }
}
