/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppesystem;

import DALException.DALException;
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
    private boolean loggedIn;

    public void start() throws MalformedURLException, DALException {

        //Opdater links
        URL url = new URL("http://ubuntu4.javabog.dk:54694");
        QName qname = new QName("http://Server/", "GruppeSysImplService");
        Service service = Service.create(url, qname);
        ServerInterface ISrv = service.getPort(ServerInterface.class);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Du skal logge ind");
        while (true) {
            while (!loggedIn) {
                System.out.println("Indtast dit brugernavn (studie-nr.)");
                String bruger = scanner.nextLine();

                System.out.println("Indtast dit password");
                String password = scanner.nextLine();

                if (validate(bruger, password)) {
                    studienummer = Integer.parseInt(bruger.substring(1));
                }
            }
            System.out.println("Du er inde nu");

            menu();
            num = scanner.nextInt();

            switch (num) {
                case 1:
                    System.out.println("Her er alle dine projekter: " + ISrv.getProjekter(studienummer));
                    break;
                case 2:
                    System.out.println("Her er alle dine aftaler & opgaver");
                    List<Projekt> list = ISrv.getProjekter(studienummer);
                    for (Projekt p : list) {
                        System.out.println(p.getNavn());
                        System.out.println("Opgaver: " + ISrv.getOpgaver(p.getId(), studienummer));
                        System.out.println("Aftaler: " + ISrv.getAftaler(p.getId(), studienummer));
                    }
                    break;
                case 3:
                    loggedIn = false;
            }
        }
    }

    public boolean validate(String studienummer, String kodeord) throws MalformedURLException {

        URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
        QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
        Service service = Service.create(url, qname);
        Brugeradmin ba = service.getPort(Brugeradmin.class);
        try {
            ba.hentBruger(studienummer, kodeord);
            loggedIn = true;
            return true;

        } catch (Exception e) {
            System.out.println("forkert brugernavn");

            e.printStackTrace();
        }

        return false;
    }

    public void menu() {

        System.out.println("Velkommen GruppeSystem");
        System.out.println("1 Se grupper");
        System.out.println("2 Se aftaler & opgaver");
        System.out.println("3 Log ud");
        System.out.print("Skriv 1-3: ");

    }

}
