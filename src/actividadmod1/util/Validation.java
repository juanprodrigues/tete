/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.util;

import actividadmod1.ActividadMod1;
import actividadmod1.Enum.TypeDocument;
import actividadmod1.Exception.ExcepcionDocument;
import actividadmod1.model.Person;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author JuanPC
 */
public class Validation {

    public static String validacionesTipoDNI(String typeDocument) throws ExcepcionDocument {

        for (TypeDocument listTypeDocument : TypeDocument.values()) {
            if (listTypeDocument.toString().equals(typeDocument)) {

                return listTypeDocument.toString() + " = " + listTypeDocument.getMsg();
            }
        }

        if (true) {
            throw new ExcepcionDocument(typeDocument);
        }
        return null;
    }

    public static LocalDate validacionFecha(String type) {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            try {

                //dia/mes/año
                System.out.println("Enter age de " + type + ": ");
                int ageEnter = entrada.nextInt();

                System.out.println("Enter day de " + type + ": ");
                int dayEnter = entrada.nextInt();
                System.out.println("Enter month de " + type + ": ");
                int monthEnter = entrada.nextInt();
                return LocalDate.of(ageEnter, Month.of(monthEnter), dayEnter);

            } catch (DateTimeException e) {
                System.out.println("Error al ingresar la fecha.");
                System.out.println("Detalles: " + e.getMessage());
                System.out.println("Detalles: " + e);
            }

        }

    }

    public static LocalDate validacionFechaString(String type) throws ParseException {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            try {

                //dia/mes/año
                System.out.println("Enter date de " + type + ": (Example: 14/02/2020)");
                String ageEnter = entrada.next();
    

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = formato.parse(ageEnter);
                
                Instant instant = fecha.toInstant();
                ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
                LocalDate date = zdt.toLocalDate();
                verificacionFecha(ageEnter,date);
                return date;

            } catch (ParseException e) {
                System.out.println("Error al ingresar el formato de la fecha.");
                System.out.println("Detalles: " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Detalles: " + e.getMessage());

            }

        }

    }
    
    private static void verificacionFecha(String dateString , LocalDate date) throws Exception{
        
      
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formar= FOMATTER.format(date);
//         System.out.println("format 1: "+dateString);
//        System.out.println("format: "+formar);
//        System.out.println("estado: "+dateString.equals(formar));
        if (!dateString.equals(formar)){
        throw new Exception("Fecha ingresada incorrecta.Verificar que el dia exista en el mes");
        }
    }

    public static void validacionInicoID(Long dni) throws ExcepcionDocument {
        List<Person> listaPersons = ActividadMod1.listPersons;
        for (Person listPerson : listaPersons) {
            if (Objects.equals(dni, listPerson.getDocument().getNumber())) {
                throw new ExcepcionDocument();
            }
        }

    }

}
