/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DALException.DALException;
import DTO.Aftale;
import DTO.Bruger;
import DTO.Opgave;
import connector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class OpgaveDAL {
    
    public Opgave getOpgave(int id) throws DALException{
        ResultSet rs = Connector.doQuery("SELECT * FROM opgave WHERE id = ?", id);
        try {
            if (!rs.first())
                throw new DALException("opgaven" + id + "findes ikke");
            
            return new Opgave(rs.getInt("id"), rs.getString("opgname"), 
                    rs.getString("opgdesc"));
	}catch (SQLException e){
            throw new DALException(e);
        }
        
           
        
        
    } 
     public List<Opgave> getOpgaveList(int projektid) throws DALException{
        List<Opgave> list = new ArrayList<Opgave>();
		ResultSet rs = Connector.doQuery("SELECT * FROM opgave WHERE projektid = ?", projektid);
                try{
                while (rs.next())   
			{
				list.add(new Opgave(rs.getInt("id"), rs.getString("opgname"), 
                    rs.getString("opgdesc")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
    }
        
    public void createOpgave(Opgave o, int projektid) throws DALException{
        {
		Connector.doUpdate
		("INSERT INTO opgave(id, opgname, opgdesc, projektid) VALUES (?,?,?,?)",
				o.getId(), o.getNavn(), o.getBeskrivelse(), projektid
				);
	}
        
    }
    
    public void updateOpgave(Opgave o, int projektid) throws DALException{
        
        {
		Connector.doUpdate("UPDATE opgave SET opgname = ?, opgdesc = ?",
				 o.getNavn(), o.getBeskrivelse()
				);
	} 
    

    }
    
    public void DeleteOpgave(Opgave a, int projektid) throws DALException{
        
        {
		Connector.doUpdate(
				"DELETE FROM opgave WHERE id = ?", a.getId()
				
				);
	} 
    }
}

