package actividadmod1.Persistence;

import actividadmod1.Exception.ExcepcionJDBC;
import actividadmod1.model.Director;
import actividadmod1.model.Document;
import actividadmod1.model.Student;
import actividadmod1.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DirectorDAO extends UtilDAO {

    public void savedDirector(Director director) throws ExcepcionJDBC {
        try {
            // (1) guardar documento

            guardarDocumento(director.getDocument());

            String sql = "INSERT INTO director (age, carrera, date_of_birth, ingreso_cargo, last_name, name, sueldo, document_numero)"
                    + "VALUES('"+director.getAge()
                    + "', '" + director.getCareer()
                    + "', '" + director.getDateOfBirthString()
                    + "', '" + director.getDatePositionString()
                    + "', '" + director.getLastName()
                    + "', '" + director.getName()
                    + "', '" + director.getSueldo()
                    + "', '" + director.getDocument().getNumber()
                    + "');";

            System.out.println(sql);
            insertarModificarEliminar(sql);



        } catch (ExcepcionJDBC e) {
            System.out.println(e.getMessage());
            throw new ExcepcionJDBC("ERROR AL GUARDAR DIRECTOR");
        } catch (Exception e) {
            e.getMessage();
        }
    }


    public Director update(int studend) throws ExcepcionJDBC, SQLException {

        Director directorDB = new Director();
        Document document = new Document();

        String sql = "SELECT * FROM director " + "WHERE id=" + studend + ";";
        System.out.println(sql);
        consultarBase(sql);
        ResultSet resultadoDirector = resultado;
        // seteamos el resultado de la consulta en el objeto para actualizar
        while (resultadoDirector.next()) {
            directorDB.setId(Integer.parseInt(resultadoDirector.getString(1)));
            directorDB.setAge(Integer.parseInt(resultadoDirector.getString(2)));
            directorDB.setCareer(resultadoDirector.getString(3));
            directorDB.setDateOfBirth(LocalDate.parse(resultadoDirector.getString(4)));
            directorDB.setDatePosition(LocalDate.parse(resultadoDirector.getString(5)));
            directorDB.setLastName(resultadoDirector.getString(6));
            directorDB.setName(resultadoDirector.getString(7));
            directorDB.setSueldo(Double.valueOf(resultadoDirector.getString(8)));

            String sqlDocument = "SELECT * FROM document " + "WHERE numero=" + resultadoDirector.getString(9) + ";";
            consultarBase(sqlDocument);
            ResultSet resultadoDocument = resultado;

            while (resultadoDocument.next()) {
                document.setNumber(Long.valueOf(resultadoDocument.getString(1)));
                document.setType(resultadoDocument.getString(2));
            }

            directorDB.setDocument(document);

        }

        return directorDB;
    }

    public void guardarUpdateDirector(Director director) throws ExcepcionJDBC {

        try {
            //si el id de documento NO se encuentra creado , salta una excepcion y el el catch se crea
            ejecurarUpdate(director);
        } catch (Exception e) {

            guardarDocumento(director.getDocument());
            ejecurarUpdate(director);

        }
    }

    public void ejecurarUpdate(Director director) throws ExcepcionJDBC {
        String sql = "UPDATE director"
                + " SET age=" + director.getAge()
                + ", carrera='" + director.getCareer()
                + "', date_of_birth='" + director.getDateOfBirthString()
                + "', ingreso_cargo='" + director.getDatePositionString()
                + "', last_name='" + director.getLastName()
                + "', name='" + director.getName()
                + "', sueldo=" + director.getSueldo()
                + ", document_numero=" + director.getDocument().getNumber()
                + " WHERE id=" + director.getId() + ";";
        System.out.println(sql);
        insertarModificarEliminar(sql);

    }



    public void deleteDirector(int idDirector) throws ExcepcionJDBC {

        String sql = "DELETE FROM director "
                + "WHERE id=" + idDirector + ";";

        System.out.println(sql);
        insertarModificarEliminar(sql);

    }


    public List<Director> listDirector() throws ExcepcionJDBC, SQLException {

        List<Director> directorList = new ArrayList<>();


        String sql = "SELECT * FROM director;";
        System.out.println(sql);
        consultarBase(sql);
        ResultSet resultadoDirector = resultado;

        // seteamos el resultado de la consulta en el objeto para actualizar
        while (resultadoDirector.next()) {

            Director directorDB = new Director();
            Document document = new Document();
            directorDB.setId(Integer.parseInt(resultadoDirector.getString(1)));
            directorDB.setAge(Integer.parseInt(resultadoDirector.getString(2)));
            directorDB.setCareer(resultadoDirector.getString(3));
            directorDB.setDateOfBirth(LocalDate.parse(resultadoDirector.getString(4)));
            directorDB.setDatePosition(LocalDate.parse(resultadoDirector.getString(5)));
            directorDB.setLastName(resultadoDirector.getString(6));
            directorDB.setName(resultadoDirector.getString(7));
            directorDB.setSueldo(Double.valueOf(resultadoDirector.getString(8)));
            String sqlDocument = "SELECT * FROM document " + "WHERE numero=" + resultadoDirector.getString(9) + ";";
            consultarBase(sqlDocument);
            ResultSet resultadoDocument = resultado;

            while (resultadoDocument.next()) {
                document.setNumber(Long.valueOf(resultadoDocument.getString(1)));
                document.setType(resultadoDocument.getString(2));
            }

            directorDB.setDocument(document);

            directorList.add(directorDB);

        }

        return directorList;
    }



}
