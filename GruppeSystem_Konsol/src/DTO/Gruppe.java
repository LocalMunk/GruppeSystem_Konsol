/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author frederik
 */
public class Gruppe {

    private String id;
    private String navn;
    private ArrayList<Bruger> brugere;
    private Projekt projekt;

    public Gruppe(String id, String navn, ArrayList<Bruger> brugere, Projekt projekt) {
        this.id = id;
        this.navn = navn;
        this.brugere = brugere;
        this.projekt = projekt;
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

    public ArrayList<Bruger> getBrugere() {
        return brugere;
    }

    public void setBrugere(ArrayList<Bruger> brugere) {
        this.brugere = brugere;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }

}