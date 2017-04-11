/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/*
 * @author frederik
 */
public class Projekt {
    
    private String id;
    private String navn;
    private Kalender kalender;

    public Projekt(String id, String navn, Kalender kalender) {
        this.id = id;
        this.navn = navn;
        this.kalender = kalender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Kalender getKalender() {
        return kalender;
    }

    public void setKalender(Kalender kalender) {
        this.kalender = kalender;
    }
    
    
    
}
