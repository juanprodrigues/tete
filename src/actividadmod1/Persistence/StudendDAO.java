package actividadmod1.Persistence;

import actividadmod1.Exception.ExcepcionJDBC;
import actividadmod1.model.Document;
import actividadmod1.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class StudendDAO extends UtilDAO {

    public void guardarUsuario(Student studend) throws ExcepcionJDBC {
        try {

            // (1) guardar documento
            guardarDocumento(studend.getDocument());

            String sql = " INSERT INTO student (age, date_of_birth, ingreso, last_name, name, document_numero)"
                    + "VALUES('" + studend.getAge()
                    + "', '" + studend.getDateOfBirthString()
                    + "', '" + studend.getDatePositionString()
                    + "', '" + studend.getName()
                    + "', '" + studend.getLastName()
                    + "', '" + studend.getDocument().getNumber()
                    + "');";

            System.out.println(sql);
            insertarModificarEliminar(sql);

            int idStudend = obtenerUltimoID("student");
            // (2) cre curso y (3) tabla intermedia
            guardarCurso(idStudend, studend.getCourses(), "rel_student_course", "fk_student");

        } catch (ExcepcionJDBC e) {
            System.out.println(e.getMessage());
            throw new ExcepcionJDBC("ERROR AL GUARDAR ESTUDIANTE");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Student update(int studend) throws ExcepcionJDBC, SQLException {

        Student studentDB = new Student();
        Document document = new Document();

        String sql = "SELECT * FROM student " + "WHERE id=" + studend + ";";
        System.out.println(sql);
        consultarBase(sql);
        ResultSet resultadoStudend = resultado;
        // seteamos el resultado de la consulta en el objeto para actualizar
        while (resultadoStudend.next()) {
            studentDB.setId(Integer.parseInt(resultadoStudend.getString(1)));
            studentDB.setAge(Integer.parseInt(resultadoStudend.getString(2)));
            studentDB.setDateOfBirth(LocalDate.parse(resultadoStudend.getString(3)));
            studentDB.setDatePosition(LocalDate.parse(resultadoStudend.getString(4)));
            studentDB.setLastName(resultadoStudend.getString(5));
            studentDB.setName(resultadoStudend.getString(6));

            String sqlDocument = "SELECT * FROM document " + "WHERE numero=" + resultadoStudend.getString(7) + ";";
            consultarBase(sqlDocument);
            ResultSet resultadoDocument = resultado;

            while (resultadoDocument.next()) {
                document.setNumber(Long.valueOf(resultadoDocument.getString(1)));
                document.setType(resultadoDocument.getString(2));
            }

            studentDB.setDocument(document);

        }

        //Armamos las fk de cursos con la tabla intermedia
        String sqlCourse = "SELECT * FROM rel_student_course " + "WHERE fk_student=" + studentDB.getId() + ";";
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
        studentDB.setCourses(courseDB);

        return studentDB;
    }

    public void guardarUpdateStudent(Student student) throws ExcepcionJDBC {

        try {
            //si el id de documento NO se encuentra creado , salta una excepcion y el el catch se crea
            ejecurarUpdate(student);
        } catch (Exception e) {

            guardarDocumento(student.getDocument());
            ejecurarUpdate(student);

        }
    }

    public void ejecurarUpdate(Student student) throws ExcepcionJDBC {
        String sql = "UPDATE student"
                + " SET age=" + student.getAge()
                + ", date_of_birth='" + student.getDateOfBirthString()
                + "', ingreso='" + student.getDatePositionString()
                + "', last_name='" + student.getLastName()
                + "', name='" + student.getName()
                + "', document_numero=" + student.getDocument().getNumber()
                + " WHERE id=" + student.getId() + ";";
        System.out.println(sql);
        insertarModificarEliminar(sql);

    }



    public void deleteStudent(int idStudent) throws ExcepcionJDBC {

        String sql = "DELETE FROM student "
                + "WHERE id=" + idStudent + ";";

        System.out.println(sql);
        insertarModificarEliminar(sql);

    }


    public List<Student> listStudend() throws ExcepcionJDBC, SQLException {

        List<Student> studentList = new ArrayList<>();


        String sql = "SELECT * FROM student;";
        System.out.println(sql);
        consultarBase(sql);
        ResultSet resultadoStudend = resultado;

        // seteamos el resultado de la consulta en el objeto para actualizar
        while (resultadoStudend.next()) {

            Student studentDB = new Student();
            Document document = new Document();
            studentDB.setId(Integer.parseInt(resultadoStudend.getString(1)));
            studentDB.setAge(Integer.parseInt(resultadoStudend.getString(2)));
            studentDB.setDateOfBirth(LocalDate.parse(resultadoStudend.getString(3)));
            studentDB.setDatePosition(LocalDate.parse(resultadoStudend.getString(4)));
            studentDB.setLastName(resultadoStudend.getString(5));
            studentDB.setName(resultadoStudend.getString(6));

            String sqlDocument = "SELECT * FROM document " + "WHERE numero=" + resultadoStudend.getString(7) + ";";
            consultarBase(sqlDocument);
            ResultSet resultadoDocument = resultado;

            while (resultadoDocument.next()) {
                document.setNumber(Long.valueOf(resultadoDocument.getString(1)));
                document.setType(resultadoDocument.getString(2));
            }

            studentDB.setDocument(document);


            //Armamos las fk de cursos con la tabla intermedia
            String sqlCourse = "SELECT * FROM rel_student_course " + "WHERE fk_student=" + studentDB.getId() + ";";
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
            studentDB.setCourses(courseDB);

            studentList.add(studentDB);

        }


        return studentList;
    }


}
