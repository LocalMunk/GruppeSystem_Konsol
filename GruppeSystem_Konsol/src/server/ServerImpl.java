/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import konsol.ServerInterface;
import DTO.Aftale;
import DTO.Opgave;
import DTO.Projekt;
import DAO.AftaleDAL;
import DAO.BrugerDAL;
import DAO.OpgaveDAL;
import DAO.ProjektDAL;
import java.util.List;
import DALException.DALException;

import brugerautorisation.transport.soap.Brugeradmin;
import brugerautorisation.data.BrugerJa;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import javax.jws.WebService;
import javax.xml.namespace.QName;

/**
 *
 * @author elbosso
 */
@WebService(endpointInterface = "konsol.ServerInterface")

public class ServerImpl implements ServerInterface{
    
    AftaleDAL aftDal;
    BrugerDAL bruDal;
    OpgaveDAL opgDal;
    ProjektDAL proDal;
    
    public ServerImpl(){
        aftDal = new AftaleDAL();
        bruDal = new BrugerDAL();
        opgDal = new OpgaveDAL();
        proDal = new ProjektDAL();
    }

    @Override
    public BrugerJa login(int studienummer, String password) throws MalformedURLException{
        URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
        QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
        Service service = Service.create(url, qname);
        Brugeradmin ba = service.getPort(Brugeradmin.class);
        try {
            brugerautorisation.data.BrugerJa b = ba.hentBruger("s" + studienummer, password);
            return b;

        } catch (Exception e) {
            System.out.println("forkert brugernavn");

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Projekt> getProjekter(int studienummer) throws DALException{
        return proDal.getProjektList(studienummer);
    }

    @Override
    public List<Opgave> getOpgaver(int projektnummer, int studienummer) throws DALException{
        return opgDal.getOpgaveList(projektnummer);
    }

    @Override
    public List<Aftale> getAftaler(int projektnummer, int studienummer) throws DALException{
        return aftDal.getAftaleList(projektnummer);
    }

    @Override
    public boolean CreateAftale(Aftale a, int studienummer, int projektnummer)throws DALException {
        aftDal.createAftale(a, projektnummer);
        return true;
    }

    @Override
    public boolean CreateOpgave(Opgave a, int studienummer, int projektnummer) throws DALException{
        opgDal.createOpgave(a, projektnummer);
        return true;
    }

    @Override
    public boolean CreateProjekt(Projekt a, int studienummer) throws DALException{
        proDal.createProjekt(a, studienummer);
        return true;
    }
    
    @Override
    public boolean DeleteAftale(Aftale a, int studienummer, int projektnummer)throws DALException {
        aftDal.DeleteAftale(a, projektnummer);
        return true;
    }

    @Override
    public boolean DeleteOpgave(Opgave a, int studienummer, int projektnummer) throws DALException{
        opgDal.DeleteOpgave(a, projektnummer);
        return true;
    }

    @Override
    public boolean DeleteProjekt(Projekt a, int studienummer) throws DALException{
        proDal.DeleteProjekt(a, studienummer);
        return true;
    }

    @Override
    public String fedtManSpa() {
       return "Spa";
    }
}