/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author frederik
 */
public class Aftale {

    private String tidspunkt;
    private String lokation;
    private int id;
    private String navn;
    private String beskrivelse;
    private ArrayList<Bruger> ansvarlige;   

    public Aftale(){
    }
    public Aftale(int id, String navn, String beskrivelse, String tidspunkt, String lokation) {

        this.tidspunkt = tidspunkt;
        this.lokation = lokation;
        this.id = id;
        this.navn = navn;
        this.beskrivelse = beskrivelse;

    }

    public String getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public String getLokation() {
        return lokation;
    }

    public void setLokation(String lokation) {
        this.lokation = lokation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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