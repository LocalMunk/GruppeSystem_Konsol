/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DALException.DALException;
import DTO.Aftale;
import DTO.Bruger;
import connector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elbosso
 */
public class AftaleDAL {
    public Aftale getAftale(int id) throws DALException{
        ResultSet rs = Connector.doQuery("SELECT * FROM aftale WHERE id = ?", id);
        try {
            if (!rs.first())
                throw new DALException("aftalen" + id + "findes ikke");
            
            return new Aftale(rs.getInt("id"), rs.getString("aftalename"), rs.getString("aftaledesc"), rs.getDate("tidspunkt"), rs.getString("lokation"));
	}catch (SQLException e){
            throw new DALException(e);
        }
    }
    
    public List<Aftale> getAftaleList(int projektid) throws DALException{
        List<Aftale> list = new ArrayList<Aftale>();
		ResultSet rs = Connector.doQuery("SELECT * FROM aftale WHERE projektid = ?", projektid);
                try{
                while (rs.next())   
			{
				list.add(new Aftale(rs.getInt("id"), rs.getString("aftalename"), rs.getString("aftaledesc"), rs.getDate("tidspunkt"), rs.getString("lokation")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
    }
    
    public void createAftale(Aftale a, int projektid) throws DALException{
        {
		Connector.doUpdate
		(
			"INSERT INTO aftale(id, projektid, aftalename, aftaledesc, tidspunkt, lokation) VALUES (?,?,?,?,?,?)",
				a.getId(), projektid, a.getNavn(), a.getBeskrivelse(), a.getTidspunkt(), a.getLokation()
				);
	}
        
    }
    
    public void updateAftale(Aftale a, int projektid) throws DALException{
        
        {
		Connector.doUpdate(
				"UPDATE aftale SET projektid = ?,  aftalename = ?, aftaledesc = ?, tidspunkt = ?, lokation = ? WHERE id = ?",
				projektid, a.getNavn(), a.getBeskrivelse(), a.getTidspunkt(), a.getLokation(), a.getId()
				);
	} 
    }
    
    public void DeleteAftale(Aftale a, int projektid) throws DALException{
        
        {
		Connector.doUpdate(
				"DELETE FROM aftale WHERE id = ?", a.getId()
				
				);
	} 
    }
}
