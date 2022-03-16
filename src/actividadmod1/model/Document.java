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
    private Enum type;
    private Long number;

    public Document() {
    }

    public Document(Enum type, Long number) {
        this.type = type;
        this.number = number;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
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
        return "Document{" + "type=" + type + ", number=" + number + '}';
    }


           
    
}
