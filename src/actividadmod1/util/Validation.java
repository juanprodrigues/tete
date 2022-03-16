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
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author JuanPC
 */
public class Validation {

    public static TypeDocument validacionesTipoDNI(String typeDocument) throws ExcepcionDocument {

        for (TypeDocument listTypeDocument : TypeDocument.values()) {
            if (listTypeDocument.toString().equals(typeDocument)) {
                return listTypeDocument;
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
                System.out.println("Enter age de "+type+": ");
                int ageEnter = entrada.nextInt();

                System.out.println("Enter day de "+type+": ");
                int dayEnter = entrada.nextInt();
                System.out.println("Enter month de "+type+": ");
                int monthEnter = entrada.nextInt();
                return LocalDate.of(ageEnter, Month.of(monthEnter), dayEnter);

            } catch (DateTimeException e) {
                System.out.println("Error al ingresar la fecha.");
                System.out.println("Detalles: " + e.getMessage());
            }

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
