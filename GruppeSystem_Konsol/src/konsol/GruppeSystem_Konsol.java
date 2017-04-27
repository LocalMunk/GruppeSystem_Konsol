/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsol;

import konsol.ServerInterface;
import DALException.DALException;
import DTO.Aftale;
import DTO.Opgave;
import DTO.Projekt;
import brugerautorisation.transport.soap.Brugeradmin;
import java.util.Scanner;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;

public class GruppeSystem_Konsol {

    private int num;
    private int studienummer;
    private boolean loggedIn, done = false;

    public void start() throws MalformedURLException, DALException {

        //Opdater links
        URL url = new URL("http://[::]:8080/server?wsdl");
        QName qname = new QName("http://server/", "ServerImplService");
        Service service = Service.create(url, qname);
        ServerInterface ISrv = service.getPort(ServerInterface.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("service: " + service.getServiceName());

        System.out.println("Du skal logge ind");
        while (!done) {
            while (!loggedIn) {
                System.out.println("Indtast dit brugernavn (studie-nr.)");
                String bruger = scanner.nextLine();

                System.out.println("Indtast dit password");
                String password = scanner.nextLine();

                try {
                    studienummer = Integer.parseInt(bruger.substring(1));
                    System.out.println("Bruger....: " + ISrv.login(studienummer, password));
                    if (ISrv.login(studienummer, password) != null) {
                        loggedIn = true;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            menu();
            num = scanner.nextInt();

            switch (num) {

                case 1:
                    List<Projekt> list = null;
                    System.out.println(studienummer);
                    try {
                        list = ISrv.getProjekter(studienummer);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        //TODO loop
                        System.out.println("Her er alle dine projekter: ");
                        for (Projekt p : list) {
                            System.out.print(p.getNavn() + ", ");
                        }
                        System.out.println("");
                    } catch (Exception e) {
                        //e.printStackTrace();
                        System.out.println("findes ingen projekter");
                    }

                    break;
                case 2:
                    System.out.println(studienummer);
                    System.out.println("Her er alle dine aftaler & opgaver");
                    List<Projekt> list2 = ISrv.getProjekter(studienummer);
                    for (Projekt p : list2) {
                        System.out.println("- " + p.getNavn() + ":");
                        //printer opgaver 
                        List<Opgave> listO = ISrv.getOpgaver(p.getId(), studienummer);
                        System.out.print("Opgaver: ");
                        for (Opgave o : listO) {
                            System.out.print(o.getNavn());
                        }
                        System.out.println("");
                        //printer aftaler
                        List<Aftale> listA = ISrv.getAftaler(p.getId(), studienummer);
                        System.out.print("Aftaler: ");
                        for (Aftale a : listA) {
                            System.out.print(a.getNavn());
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    loggedIn = false;
                    done = true;
            }
        }
    }

    public void menu() {
        System.out.println("");
        System.out.println("#################################################");
        System.out.println("Velkommen GruppeSystem");
        System.out.println("1 Se grupper");
        System.out.println("2 Se aftaler & opgaver");
        System.out.println("3 Log ud");
        System.out.print("Skriv 1-3: ");
    }

}