/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataklasser;

import brugerautorisation.data.Bruger;
import java.util.ArrayList;

/**
 *
 * @author frederik
 */
public abstract class Event {
    
    private String id;
    private String navn;
    private String beskrivelse;
    private ArrayList<Bruger> ansvarlige;
    
}
