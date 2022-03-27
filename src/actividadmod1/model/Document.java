/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadmod1.model;

/**
 *
 * @author JuanPC
 */
public final class Document {
    private String type;
    private Long number;

    public Document() {
    }

    public Document(String type, Long number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Document{"+ type + ", number=" + number + '}';
    }


           
    
}
