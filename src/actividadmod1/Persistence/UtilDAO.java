package actividadmod1.Persistence;

import actividadmod1.Exception.ExcepcionJDBC;
import actividadmod1.model.Document;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilDAO extends DAO {
    //recolecta id para tanto de cursos creados y a crear para generar la tabla intermedia
    List<Integer> idCourseTableIntermedia = new ArrayList<>();

    public boolean searchCourse(HashMap<Integer, String> courses, String nameCourse) {

        // Recorrer las dos partes del mapa
        for (Map.Entry<Integer, String> entry : courses.entrySet()) {
            //pregunta si entry que corresponde a un valor del hashmap con el nombre de curso que esta ingresando
            if (entry.getValue().equals(nameCourse)) {
                //si encuentra, añadir la key del curso a la lista.!
                idCourseTableIntermedia.add(entry.getKey());
                System.out.println("El nombre "+nameCourse +" ya existe como curso en la db.");
                return true;
            }

        }
        return false;
    }
    //idModel puede ser tando un id del teacher como de estudiante
    public void guardarCurso(int idModel, HashMap<Integer, String> coursesIngresantes,String tableIntermedia,String fkTableIntermedia) throws ExcepcionJDBC, SQLException, Exception {
        try {

            //obtengo los id con los nombres de cursos de la base de datos
            HashMap<Integer, String> coursesDB = obtenerTablaCurso();
            // id autoincrementable para simular y actializar el courseDB y no volver a preguntar por QUERY
            int idcurso = coursesDB.size() + 1;
            // Recorro el hash de cursos que ingresa
            for (Map.Entry<Integer, String> entry : coursesIngresantes.entrySet()) {

                //pregunto si el curso existe en la db
                if (searchCourse(coursesDB, entry.getValue())) {

                    System.out.println("GuardarCurso Error materia ya existente.");

                } else {

                    //inserto el valor que no se encuentra en la bd en el hasd de la db para tenerlo actualizado
                    coursesDB.put(idcurso, entry.getValue());

                    //en caso que no exista inserto el nombre del curso en la db
                    String sql1 = "INSERT INTO course (name) VALUES ('" + entry.getValue() + "');";

                    // en forma paralela añado el nuevo curso a la lista de id's para construir la la tabla intermedia
                    idCourseTableIntermedia.add(idcurso);

                    System.out.println(sql1);
                    insertarModificarEliminar(sql1);

                    idcurso++;
                }

            }
            //armar la informacion de la tabla intermedia

            // Recorro la tabla intermedia con un for-each
            for (Integer idCourseTable : idCourseTableIntermedia) {
                System.out.println("id de materia para la tabla intermedia: " + idCourseTable);

                String sqlTabelIntermedia = "INSERT INTO "+tableIntermedia+"("+fkTableIntermedia+",fk_course)"
                        + "VALUES('" + idModel
                        + "', '" + idCourseTable
                        + "');";

                System.out.println(sqlTabelIntermedia);
                insertarModificarEliminar(sqlTabelIntermedia);
            }

        } catch (ExcepcionJDBC e) {
            System.out.println(e.getMessage());
            throw new ExcepcionJDBC("ERROR AL GUARDAR La tabla intermedia");
        }
    }

    public HashMap<Integer, String> obtenerTablaCurso() throws Exception {

        try {
            //creo un hash para devolver como respuesta
            HashMap<Integer, String> course = new HashMap<>();

            // Se crea la sentencia SQL
            String sql = "SELECT id,name FROM course;";
            System.out.println(sql);
            consultarBase(sql);



            // Me aseguro que halla obtenido resultados de mi consulta
            while (resultado.next()) {

                int idCurso = Integer.parseInt(resultado.getString(1));
                String name = resultado.getString(2);

                //añado estos datos al hashmap
                course.put(idCurso, name);
            }

            System.out.println("TAMAÑO DE LA TABLA DE CURSO: " + course.size());

            // Retorno mi hashmap de Cursos con la información que me proporciono mi base de datos
            return course;

        } catch (ExcepcionJDBC | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener TablaCurso");
        }
    }

    public int obtenerUltimoID(String tabla) throws Exception {
        try {
            int ultimoID;
            // Se crea la sentencia SQL
            String sql = "SELECT id FROM " + tabla + " order by id DESC limit 1;";
            System.out.println(sql);
            consultarBase(sql);

            while (resultado.next()) {
                // Se recupera la información de mi base de datos alojándola en mi lista de usuarios
                System.out.println("resultado: " + resultado.getString(1));
                ultimoID = Integer.parseInt(resultado.getString(1));
                return ultimoID;
            }

        } catch (ExcepcionJDBC | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener obtenerUltimoID");
        }
        return 0;

    }

    public void guardarDocumento(Document document) throws ExcepcionJDBC{

        String sql = "INSERT INTO document (numero, tipo)"
                + "VALUES('" + document.getNumber()
                + "', '" + document.getType()
                + "');";
        System.out.println(sql);
        insertarModificarEliminar(sql);
        System.out.println("Se inserto el documento con exito");

    }


}
