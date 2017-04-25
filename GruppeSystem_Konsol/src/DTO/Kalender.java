/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author elbosso
 */
public class Kalender {
    
    private String id;
    private ArrayList<Aftale> aftaler;
    private ArrayList<Opgave> opgaver;

    public Kalender(String id, ArrayList<Aftale> aftaler, ArrayList<Opgave> opgaver) {
        this.id = id;
        this.aftaler = aftaler;
        this.opgaver = opgaver;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Aftale> getAftaler() {
        return aftaler;
    }

    public void setAftaler(ArrayList<Aftale> aftaler) {
        this.aftaler = aftaler;
    }

    public ArrayList<Opgave> getOpgaver() {
        return opgaver;
    }

    public void setOpgaver(ArrayList<Opgave> opgaver) {
        this.opgaver = opgaver;
    }
    
    
}