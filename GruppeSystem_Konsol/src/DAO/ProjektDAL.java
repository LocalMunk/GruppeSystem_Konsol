/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Projekt;
import DALException.DALException;
import DTO.Aftale;
import connector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elbosso
 */
public class ProjektDAL {

    public Projekt getProjekt(int id) throws DALException {
        ResultSet rs = Connector.doQuery("SELECT * FROM projekt WHERE id = ?", id);
        try {
            if (!rs.first()) {
                throw new DALException("projektet" + id + "findes ikke");
            }

            return new Projekt(rs.getInt("id"), rs.getString("projectname"), rs.getString("projectdesc"), rs.getString("groupname"), rs.getInt("adminid"));
        } catch (SQLException e) {
            throw new DALException(e);
        }
    }

    public List<Projekt> getProjektList(int personid) throws DALException {
        List<Projekt> list = new ArrayList<Projekt>();
        ResultSet rs = Connector.doQuery("SELECT * FROM projekt LEFT JOIN medlemmer ON medlemmer.groupid = projekt.id AND medlemmer.brugid = ? WHERE medlemmer.id IS NOT NULL", personid);
        try {
            while (rs.next()) {
                list.add(new Projekt(rs.getInt("id"), rs.getString("projectname"), rs.getString("projectdesc"), rs.getString("groupname"), rs.getInt("adminid")));
            }
        } catch (SQLException e) {
            throw new DALException(e);
        }
        return list;
    }

    public void createProjekt(Projekt a, int personid) throws DALException {
        {
            Connector.doUpdate(
                    "INSERT INTO projekt(id, projectname, projectdesc, groupname, adminid) VALUES (?,?,?,?,?)",
                    a.getId(), a.getNavn(), a.getDesc(), a.getGruppeNavn(), a.getAdminid()
            );
        }

    }

    public void updateProjekt(Projekt a, int personid) throws DALException {

        {
            Connector.doUpdate(
                    "UPDATE projekt SET projectname = ?,  projectdesc = ?, groupname = ?, adminid = ? WHERE id = ?",
                    a.getNavn(), a.getDesc(), a.getGruppeNavn(), a.getAdminid(), a.getId()
            );
        }
    }

    public void DeleteProjekt(Projekt a, int personid) throws DALException {

        {
            Connector.doUpdate(
                    "DELETE FROM projekt WHERE id = ?", a.getId()
            );
        }
    }

}
