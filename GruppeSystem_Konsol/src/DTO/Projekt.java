/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author elbosso
 */
public class Projekt implements  Serializable{

    private static final long serialVersionUID = 12345;
    private int id;
    private String navn;
    private String desc;
    private String gruppeNavn;
    private int adminid;
    private Kalender kalender;

    public Projekt(int id, String navn, String desc, String gruppeNavn, int adminid) {
        this.id = id;
        this.navn = navn;
        this.desc = desc;
        this.gruppeNavn = gruppeNavn;
        this.adminid = adminid;
    }
 public Projekt(){
     
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
    
    public String getDesc() {
    	return desc;
    }
    
    public void setDesc(String desc) {
    	this.desc = desc;
    }
    
    public String getGruppeNavn() {
    	return gruppeNavn;
    }
    
    public void setGruppeNavn(String gruppeNavn) {
    	this.gruppeNavn = gruppeNavn;
    }
    
    public int getAdminid() {
    	return adminid;
    }
    
    public void setAdminid(int adminid) {
    	this.adminid = adminid;
    }

    public Kalender getKalender() {
        return kalender;
    }

    public void setKalender(Kalender kalender) {
        this.kalender = kalender;
    }

}