/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author elbozo
 */
public class Opgave {


    private int id;
    private String navn;
    private String beskrivelse;
    private ArrayList<Bruger> ansvarlige;

    public Opgave(int id, String navn, String beskrivelse) {
        this.id = id;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
       }
    public Opgave(){
        
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