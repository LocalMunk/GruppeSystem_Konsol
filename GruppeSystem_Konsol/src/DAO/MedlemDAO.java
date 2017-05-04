/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DALException.DALException;
import connector.Connector;

/**
 *
 * @author elbosso
 */
public class MedlemDAO {
    public void createMedlem(int studienummer, int projektnummer) throws DALException{
        {
		Connector.doUpdate
		("INSERT INTO medlemmer(groupid, brugid) VALUES (?,?)",
				projektnummer, studienummer
				);
	}
    }
    
    public void deleteMedlem(int studienummer, int projektnummer) throws DALException{
        {
		Connector.doUpdate(
				"DELETE FROM medlemmer WHERE brugid = ? && groupid = ?", studienummer, projektnummer
				
				);
	} 
    }
}
