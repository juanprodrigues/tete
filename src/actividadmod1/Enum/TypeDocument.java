/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.Enum;

/**
 *
 * @author JuanPC
 */
public enum TypeDocument {
    
    DNI("Documento Nacional de Identidad"),
    CI("Cedula de Identidad"),
    LE("Libreta de Enrolamiento"),
    PASS("Pasaporte");
    String msg;
    //constructor
    TypeDocument(String msg) {
        this.msg = msg;
    }

    //instance methods
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
