package actividadmod1.Persistence;

import actividadmod1.Exception.ExcepcionJDBC;
import actividadmod1.model.Document;
import actividadmod1.model.Student;
import actividadmod1.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TeacherDAO extends UtilDAO {

    public void savedTeacher(Teacher teacher) throws ExcepcionJDBC {
        try {
            // (1) guardar documento

            guardarDocumento(teacher.getDocument());

            String sql = " INSERT INTO teacher (age, date_of_birth, ingreso_cargo, last_name, name, sueldo, document_numero)"
                    + "VALUES('"+teacher.getAge()
                    + "', '" + teacher.getDateOfBirthString()
                    + "', '" + teacher.getDatePositionString()
                    + "', '" + teacher.getLastName()
                    + "', '" + teacher.getName()
                    + "', '" + teacher.getSueldo()
                    + "', '" + teacher.getDocument().getNumber()
                    + "');";

            System.out.println(sql);
            insertarModificarEliminar(sql);
            // SE MUESTRA LA CADENA RESULTANTE

            int idteacher =obtenerUltimoID("teacher");
            // (2) cre curso y tabla intermedia
            guardarCurso(idteacher,teacher.getListCourses(),"rel_techer_course","fk_teach");
            //(3) generar la tabla intermedia


        } catch (ExcepcionJDBC e) {
            System.out.println(e.getMessage());
            throw new ExcepcionJDBC("ERROR AL GUARDAR TEACHER");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Teacher update(int studend) throws ExcepcionJDBC, SQLException {

        Teacher teacherDB = new Teacher();
        Document document = new Document();

        String sql = "SELECT * FROM teacher " + "WHERE id=" + studend + ";";
        System.out.println(sql);
        consultarBase(sql);
        ResultSet resultadoTeacher = resultado;
        // seteamos el resultado de la consulta en el objeto para actualizar
        while (resultadoTeacher.next()) {
            teacherDB.setId(Integer.parseInt(resultadoTeacher.getString(1)));
            teacherDB.setAge(Integer.parseInt(resultadoTeacher.getString(2)));
            teacherDB.setDateOfBirth(LocalDate.parse(resultadoTeacher.getString(3)));
            teacherDB.setDatePosition(LocalDate.parse(resultadoTeacher.getString(4)));
            teacherDB.setLastName(resultadoTeacher.getString(5));
            teacherDB.setName(resultadoTeacher.getString(6));
            teacherDB.setSueldo(Double.valueOf(resultadoTeacher.getString(7)));

            String sqlDocument = "SELECT * FROM document " + "WHERE numero=" + resultadoTeacher.getString(8) + ";";
            consultarBase(sqlDocument);
            ResultSet resultadoDocument = resultado;

            while (resultadoDocument.next()) {
                document.setNumber(Long.valueOf(resultadoDocument.getString(1)));
                document.setType(resultadoDocument.getString(2));
            }

            teacherDB.setDocument(document);

        }

        //Armamos las fk de cursos con la tabla intermedia
        String sqlCourse = "SELECT * FROM rel_techer_course " + "WHERE fk_teach=" + teacherDB.getId() + ";";
        consultarBase(sqlCourse);
        ResultSet resultadoTableIntermediaCourse = resultado;
        //lista para guardar las fk de cursos

        List<Integer> fkCourse = new ArrayList<>();
        //guardamos las fk en la lista
        while (resultadoTableIntermediaCourse.next()) {
            fkCourse.add(Integer.valueOf(resultadoTableIntermediaCourse.getString(2)));
        }
        //hash para guardar para armar los cursos asociados a al id de estudiante
        HashMap<Integer, String> courseDB = new HashMap<>();

        //iteramos la lista de fk de curso y las buscamos en la tabla de course para extraer el id y el nombre de materia
        for (Integer idTableIntermedia : fkCourse) {
            String sqlTableCourse = "SELECT * FROM course " + "WHERE id=" + idTableIntermedia + ";";
            consultarBase(sqlTableCourse);
            ResultSet resultadoTableCourse = resultado;

            //añadimos al hash de courso
            while (resultadoTableCourse.next()) {
                courseDB.put(Integer.valueOf(resultadoTableCourse.getString(1)), resultadoTableCourse.getString(2));
            }
        }
        //setamos el curso reconstruido de la db al objeto de estudiante
        teacherDB.setListCourses(courseDB);

        return teacherDB;
    }

    public void guardarUpdateTeacher(Teacher teacher) throws ExcepcionJDBC {

        try {
            //si el id de documento NO se encuentra creado , salta una excepcion y el el catch se crea
            ejecurarUpdate(teacher);
        } catch (Exception e) {

            guardarDocumento(teacher.getDocument());
            ejecurarUpdate(teacher);

        }
    }

    public void ejecurarUpdate(Teacher teacher) throws ExcepcionJDBC {
        String sql = "UPDATE teacher"
                + " SET age=" + teacher.getAge()
                + ", date_of_birth='" + teacher.getDateOfBirthString()
                + "', ingreso_cargo='" + teacher.getDatePositionString()
                + "', last_name='" + teacher.getLastName()
                + "', name='" + teacher.getName()
                + "', sueldo=" + teacher.getSueldo()
                + ", document_numero=" + teacher.getDocument().getNumber()
                + " WHERE id=" + teacher.getId() + ";";
        System.out.println(sql);
        insertarModificarEliminar(sql);

    }



    public void deleteTeacher(int idteacher) throws ExcepcionJDBC {

        String sql = "DELETE FROM teacher "
                + "WHERE id=" + idteacher + ";";

        System.out.println(sql);
        insertarModificarEliminar(sql);

    }


    public List<Teacher> listTeacher() throws ExcepcionJDBC, SQLException {

        List<Teacher> teacherList = new ArrayList<>();


        String sql = "SELECT * FROM teacher;";
        System.out.println(sql);
        consultarBase(sql);
        ResultSet resultadoTeacher = resultado;

        // seteamos el resultado de la consulta en el objeto para actualizar
        while (resultadoTeacher.next()) {

            Teacher teacherDB = new Teacher();
            Document document = new Document();
            teacherDB.setId(Integer.parseInt(resultadoTeacher.getString(1)));
            teacherDB.setAge(Integer.parseInt(resultadoTeacher.getString(2)));
            teacherDB.setDateOfBirth(LocalDate.parse(resultadoTeacher.getString(3)));
            teacherDB.setDatePosition(LocalDate.parse(resultadoTeacher.getString(4)));
            teacherDB.setLastName(resultadoTeacher.getString(5));
            teacherDB.setName(resultadoTeacher.getString(6));
            teacherDB.setSueldo(Double.valueOf(resultadoTeacher.getString(7)));
            String sqlDocument = "SELECT * FROM document " + "WHERE numero=" + resultadoTeacher.getString(8) + ";";
            consultarBase(sqlDocument);
            ResultSet resultadoDocument = resultado;

            while (resultadoDocument.next()) {
                document.setNumber(Long.valueOf(resultadoDocument.getString(1)));
                document.setType(resultadoDocument.getString(2));
            }

            teacherDB.setDocument(document);


            //Armamos las fk de cursos con la tabla intermedia
            String sqlCourse = "SELECT * FROM rel_techer_course " + "WHERE fk_teach="  + teacherDB.getId() + ";";
            consultarBase(sqlCourse);
            ResultSet resultadoTableIntermediaCourse = resultado;
            //lista para guardar las fk de cursos

            List<Integer> fkCourse = new ArrayList<>();
            //guardamos las fk en la lista
            while (resultadoTableIntermediaCourse.next()) {
                fkCourse.add(Integer.valueOf(resultadoTableIntermediaCourse.getString(2)));
            }
            //hash para guardar para armar los cursos asociados a al id de estudiante
            HashMap<Integer, String> courseDB = new HashMap<>();

            //iteramos la lista de fk de curso y las buscamos en la tabla de course para extraer el id y el nombre de materia
            for (Integer idTableIntermedia : fkCourse) {
                String sqlTableCourse = "SELECT * FROM course " + "WHERE id=" + idTableIntermedia + ";";
                consultarBase(sqlTableCourse);
                ResultSet resultadoTableCourse = resultado;

                //añadimos al hash de courso
                while (resultadoTableCourse.next()) {
                    courseDB.put(Integer.valueOf(resultadoTableCourse.getString(1)), resultadoTableCourse.getString(2));
                }
            }
            //setamos el curso reconstruido de la db al objeto de estudiante
            teacherDB.setListCourses(courseDB);

            teacherList.add(teacherDB);

        }
        return teacherList;
    }

}
