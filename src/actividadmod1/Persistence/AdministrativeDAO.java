package actividadmod1.Persistence;

import actividadmod1.Exception.ExcepcionJDBC;
import actividadmod1.model.Administrative;
import actividadmod1.model.Director;
import actividadmod1.model.Document;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class AdministrativeDAO extends UtilDAO {

    public void savedAdministrative(Administrative administrative) throws ExcepcionJDBC {
        try {
            // (1) guardar documento
            guardarDocumento(administrative.getDocument());

            String sql = "INSERT INTO administrative (age, date_of_birth, ingreso_cargo, last_name, name, sueldo, document_numero)"
                    + "VALUES('" + administrative.getAge()
                    + "', '" + administrative.getDateOfBirthString()
                    + "', '" + administrative.getDatePositionString()
                    + "', '" + administrative.getLastName()
                    + "', '" + administrative.getName()
                    + "', '" + administrative.getSueldo()
                    + "', '" + administrative.getDocument().getNumber()
                    + "');";

            System.out.println(sql);
            insertarModificarEliminar(sql);

        } catch (ExcepcionJDBC e) {
            System.out.println(e.getMessage());
            throw new ExcepcionJDBC("ERROR AL GUARDAR ADMINISTRATIVO");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Administrative update(int idAdministrative) throws ExcepcionJDBC, SQLException {

        Administrative administrativeDB = new Administrative();
        Document document = new Document();

        String sql = "SELECT * FROM administrative " + "WHERE id=" + idAdministrative + ";";
        System.out.println(sql);
        consultarBase(sql);
        ResultSet resultadoAdministrative = resultado;
        // seteamos el resultado de la consulta en el objeto para actualizar
        while (resultadoAdministrative.next()) {
            administrativeDB.setId(Integer.parseInt(resultadoAdministrative.getString(1)));
            administrativeDB.setAge(Integer.parseInt(resultadoAdministrative.getString(2)));
            administrativeDB.setDateOfBirth(LocalDate.parse(resultadoAdministrative.getString(3)));
            administrativeDB.setDatePosition(LocalDate.parse(resultadoAdministrative.getString(4)));
            administrativeDB.setLastName(resultadoAdministrative.getString(5));
            administrativeDB.setName(resultadoAdministrative.getString(6));
            administrativeDB.setSueldo(Double.valueOf(resultadoAdministrative.getString(7)));

            String sqlDocument = "SELECT * FROM document " + "WHERE numero=" + resultadoAdministrative.getString(8) + ";";
            consultarBase(sqlDocument);
            ResultSet resultadoDocument = resultado;

            while (resultadoDocument.next()) {
                document.setNumber(Long.valueOf(resultadoDocument.getString(1)));
                document.setType(resultadoDocument.getString(2));
            }

            administrativeDB.setDocument(document);

        }

        return administrativeDB;
    }

    public void guardarUpdateAdministrative(Administrative administrative) throws ExcepcionJDBC {

        try {
            //si el id de documento NO se encuentra creado , salta una excepcion y el el catch se crea
            ejecurarUpdate(administrative);
        } catch (Exception e) {

            guardarDocumento(administrative.getDocument());
            ejecurarUpdate(administrative);

        }
    }

    public void ejecurarUpdate(Administrative student) throws ExcepcionJDBC {
        String sql = "UPDATE administrative"
                + " SET age=" + student.getAge()
                + ", date_of_birth='" + student.getDateOfBirthString()
                + "', ingreso_cargo='" + student.getDatePositionString()
                + "', last_name='" + student.getLastName()
                + "', name='" + student.getName()
                + "', sueldo=" + student.getSueldo()
                + ", document_numero=" + student.getDocument().getNumber()
                + " WHERE id=" + student.getId() + ";";
        System.out.println(sql);
        insertarModificarEliminar(sql);

    }



    public void deleteAdministrative(int idAdministrative) throws ExcepcionJDBC {

        String sql = "DELETE FROM administrative "
                + "WHERE id=" + idAdministrative + ";";

        System.out.println(sql);
        insertarModificarEliminar(sql);

    }


    public List<Administrative> listAdministrative() throws ExcepcionJDBC, SQLException {

        List<Administrative> administrativeList = new ArrayList<>();


        String sql = "SELECT * FROM administrative;";
        System.out.println(sql);
        consultarBase(sql);
        ResultSet resultadoAdministrative = resultado;

        // seteamos el resultado de la consulta en el objeto para actualizar
        while (resultadoAdministrative.next()) {

            Administrative administrativeDB = new Administrative();
            Document document = new Document();
            administrativeDB.setId(Integer.parseInt(resultadoAdministrative.getString(1)));
            administrativeDB.setAge(Integer.parseInt(resultadoAdministrative.getString(2)));
            administrativeDB.setDateOfBirth(LocalDate.parse(resultadoAdministrative.getString(3)));
            administrativeDB.setDatePosition(LocalDate.parse(resultadoAdministrative.getString(4)));
            administrativeDB.setLastName(resultadoAdministrative.getString(5));
            administrativeDB.setName(resultadoAdministrative.getString(6));
            administrativeDB.setSueldo(Double.valueOf(resultadoAdministrative.getString(7)));
            String sqlDocument = "SELECT * FROM document " + "WHERE numero=" + resultadoAdministrative.getString(8) + ";";
            consultarBase(sqlDocument);
            ResultSet resultadoDocument = resultado;

            while (resultadoDocument.next()) {
                document.setNumber(Long.valueOf(resultadoDocument.getString(1)));
                document.setType(resultadoDocument.getString(2));
            }

            administrativeDB.setDocument(document);

            administrativeList.add(administrativeDB);

        }

        return administrativeList;
    }


}
