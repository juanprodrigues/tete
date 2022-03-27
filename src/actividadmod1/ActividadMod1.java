/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1;

import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.Exception.ExcepcionJDBC;
import actividadmod1.Service.*;
import actividadmod1.model.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

/**
 * @author JuanPC
 */
public class ActividadMod1 {

    public static List<Person> listPersons = new ArrayList<>();

    public static void menuEntidaddes(String entidad) {
        System.out.println("----------" + entidad + "----------");
        System.out.println("Selecione que desea hacer");
        System.out.println("1) Crear");
        System.out.println("2) Actualizar");
        System.out.println("3) Eliminar");
        System.out.println("4) Listar");
        System.out.println("5) Salir-Menu Anterior");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExcepcionDocument, ParseException, ExcepcionJDBC, SQLException {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        Person person = new Person();
        PersonService personServce = new PersonService();
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        DirectorService directorService = new DirectorService();
        AdministrativeService administrativeService = new AdministrativeService();
        int ops;
        do {
            System.out.println("----------Menu----------");
            System.out.println("Selecione tipo de objeto que quiere manipular");
            System.out.println("1) Estudiante");
            System.out.println("2) Profesor");
            System.out.println("3) Director");
            System.out.println("4) Administra");
            System.out.println("5) Salir");


             ops = entrada.nextInt();
            int ops1;
            int id;
            switch (ops) {
                case 1:
                    do {
                        menuEntidaddes("estudiante");
                        ops1 = entrada.nextInt();
                        switch (ops1) {
                            case 1:
                                listPersons.add(studentService.create());
                                break;
                            case 2:
                                System.out.println("Ingrese id de Estudiante que quiere Actualizar");
                                id = entrada.nextInt();
                                listPersons.add(studentService.update(id));
                                break;
                            case 3:
                                System.out.println("Ingrese id de Estudiante que quiere eliminar");
                                id = entrada.nextInt();
                                studentService.delete(id);
                                break;
                            case 4:
                                studentService.list();
                                break;

                        }
                    }
                    while (ops1 != 5);


                case 2:
                    do {
                        menuEntidaddes("Profesor");
                        ops1 = entrada.nextInt();
                        switch (ops1) {
                            case 1:
                                listPersons.add(teacherService.create());
                                break;
                            case 2:
                                System.out.println("Ingrese id de Profesor que quiere Actualizar");
                                id = entrada.nextInt();
                                listPersons.add(teacherService.update(id));
                                break;
                            case 3:
                                System.out.println("Ingrese id de Profesor que quiere eliminar");
                                id = entrada.nextInt();
                                teacherService.delete(id);
                                break;
                            case 4:
                                teacherService.list();
                                break;
                        }
                    } while (ops1 != 5);



                case 3:
                    do {
                        menuEntidaddes("Director");
                        ops1 = entrada.nextInt();
                        switch (ops1) {
                            case 1:
                                listPersons.add(directorService.create());
                                break;
                            case 2:
                                System.out.println("Ingrese id de Director que quiere Actualizar");
                                id = entrada.nextInt();
                                listPersons.add(directorService.update(id));
                                break;
                            case 3:
                                System.out.println("Ingrese id de Director que quiere eliminar");
                                id = entrada.nextInt();
                                directorService.delete(id);
                                break;
                            case 4:
                                directorService.list();
                                break;
                        }
                    } while (ops1 != 5);
                case 4:
                    do {
                        menuEntidaddes("Administrativo");
                        ops1 = entrada.nextInt();
                        switch (ops1) {
                            case 1:
                                listPersons.add(administrativeService.create());
                                break;
                            case 2:
                                System.out.println("Ingrese id de Administrativo que quiere Actualizar");
                                id = entrada.nextInt();
                                listPersons.add(administrativeService.update(id));
                                break;
                            case 3:
                                System.out.println("Ingrese id de Administrativo que quiere eliminar");
                                id = entrada.nextInt();
                                administrativeService.delete(id);
                                break;
                            case 4:
                                administrativeService.list();
                                break;
                        }
                    } while (ops1 != 5);

            }


        } while (ops != 5);


//         CREACION DE ESTUDIANTE

        // StudentService studentService = new StudentService();

        //   Student student = studentService.create();
//        listPersons.add(student);

        // Student student = studentService.update(1);

        //listPersons.add(student);
//        studentService.list();
//        studentService.delete(1);
//        studentService.list();

//        Student student2 = studentService.create();
//        listPersons.add(student2);
//
//        Student student3 = studentService.create();
//        listPersons.add(student3);

//        Student student4 = studentService.create();
//        listPersons.add(student4);
//------------------------------------------------------------------------------------//

//         CREACION DE PROFESOR

//        TeacherService teacherService = new TeacherService();
//        Teacher teacher = teacherService.create();
//       listPersons.add(teacher);

//         CREACION DE Director

//        DirectorService directorService = new DirectorService();
//        Director director = directorService.create();
//        listPersons.add(director);

//         CREACION DE Administrative

//        AdministrativeService administrativeService = new AdministrativeService();
//        Administrative administrative = administrativeService.create();
//        listPersons.add(administrative);


        //        COMENTADO EL FOR EACH
//        listPersons.forEach((listPerson) -> {
//            System.out.println("Lista de personas: \n" + listPerson.toString());
//        });
        ordenar();

    }

    public static void ordenar() {

        Collections.sort(listPersons, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {

                String type1 = ((Person) o1).getDocument().getType().toString();
                String type2 = ((Person) o2).getDocument().getType().toString();
                int sComp = type1.compareTo(type2);

                if (sComp != 0) {
                    return sComp;
                } else {
                    String number1 = ((Person) o1).getDocument().getNumber().toString();
                    String number2 = ((Person) o2).getDocument().getNumber().toString();
                    return number1.compareTo(number2);
                }
            }
        });
//        COMENTADO EL FOR EACH
        System.out.println("Lista ordenada de personas: \n");
        listPersons.forEach((listPerson) -> {
            System.out.println(listPerson.toString());
        });
    }
}
