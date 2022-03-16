/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Exception;

/**
 *
 * @author JuanPC
 */
public class ExcepcionDocument extends Exception {
    
    private String typeDocument;

    public ExcepcionDocument() {
    }
    
    public ExcepcionDocument(String message) {
       super();
       this.typeDocument=message;
    }
    
   @Override
   public String getMessage(){
       if (typeDocument==null){
       return "El dni ya existe";
       }
       return "Tipo de documento: "+typeDocument+" no es admitido";
   }
    
}
