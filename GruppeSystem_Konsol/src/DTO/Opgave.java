/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import brugerautorisation.data.Bruger;
import java.util.ArrayList;

/**
 *
 * @author frederik
 */
public class Opgave {

    private int prioritet;
    private String id;
    private String navn;
    private String beskrivelse;
    private ArrayList<Bruger> ansvarlige;

    public Opgave(int prioritet, String id, String navn, String beskrivelse, ArrayList<Bruger> ansvarlige) {
        this.prioritet = prioritet;
        this.id = id;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.ansvarlige = ansvarlige;
    }

    public int getPrioritet() {
        return prioritet;
    }

    public void setPrioritet(int prioritet) {
        this.prioritet = prioritet;
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

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public ArrayList<Bruger> getAnsvarlige() {
        return ansvarlige;
    }

    public void setAnsvarlige(ArrayList<Bruger> ansvarlige) {
        this.ansvarlige = ansvarlige;
    }

}
