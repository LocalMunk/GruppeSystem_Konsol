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
public class Gruppe {
    
    private String id;
    private String navn;
    private ArrayList <Bruger> brugere;
    private Projekt projekt;
 
    public Gruppe(String navn) {
    
        this.navn = navn;
        
    }
    
    public ArrayList<Gruppe> hentGrupper(Bruger b) {
        
        
        
        return null;
    }
    
    
    
}
