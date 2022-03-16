/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.util;

import actividadmod1.Enum.TypeDocument;
import actividadmod1.Exception.ExcepcionDocument;

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
        
        
}
