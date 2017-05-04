/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import brugerautorisation.data.BrugerJa;
import DTO.Projekt;
import DTO.Opgave;
import DTO.Aftale;
import java.net.MalformedURLException;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import DALException.DALException;
import java.io.IOException;

/**
 *
 * @author elbosso
 */
@WebService
public interface ServerInterface {
   
   @WebMethod public BrugerJa login(int studienummer, String password)  throws MalformedURLException;
   @WebMethod public List<Projekt> getProjekter(int studienummer) throws DALException;
   @WebMethod public List<Opgave> getOpgaver(int projektnummer, int studienummer)throws DALException;
   @WebMethod public List<Aftale> getAftaler(int projektnummer, int studienummer)throws DALException;
   @WebMethod public boolean CreateAftale(Aftale a, int studienummer, int projektnummer)throws DALException;
   @WebMethod public boolean CreateOpgave(Opgave a, int studienummer, int projektnummer)throws DALException;
   @WebMethod public boolean CreateProjekt(Projekt a, int studienummer)throws DALException;
   @WebMethod public boolean DeleteAftale(int aftaleId, int studienummer, int projektnummer)throws DALException;
   @WebMethod public boolean DeleteOpgave(int opgaveId, int studienummer, int projektnummer)throws DALException;
   @WebMethod public boolean DeleteProjekt(int projektId)throws DALException;
   @WebMethod public String fedtManSpa();
   @WebMethod public void AddMedlem(int studienummer, int projektid) throws DALException;
   @WebMethod public void DeleteMedlem(int studienummer, int projektid) throws DALException;
}
