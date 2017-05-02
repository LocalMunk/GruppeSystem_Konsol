/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsol;

import transport.ServerInterface;
import DALException.DALException;
import DTO.Aftale;
import DTO.Opgave;
import DTO.Projekt;
import drive.DriveTest;
import brugerautorisation.transport.soap.Brugeradmin;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;

public class GruppeSystem_Konsol {

    private int num;
    private int studienummer;
    private boolean loggedIn, bool = false;
    private DriveTest drive;

    public void start() throws MalformedURLException, DALException, IOException {

        drive = new DriveTest();
        //Opdater links
        URL url = new URL("http://ubuntu4.javabog.dk:42072/server?wsdl");
        QName qname = new QName("http://server/", "ServerImplService");
        Service service = Service.create(url, qname);
        ServerInterface ISrv = service.getPort(ServerInterface.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("service: " + service.getServiceName());

        System.out.println("Du skal logge ind");

        while (true) {
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
            try{
            num = scanner.nextInt();

            switch (num) {
                case 1:
                    List<Projekt> list = null;
                    try {
                        list = ISrv.getProjekter(studienummer);

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
                            System.out.print(o.getNavn() + ", ");
                        }
                        System.out.println("");
                        //printer aftaler
                        List<Aftale> listA = ISrv.getAftaler(p.getId(), studienummer);
                        System.out.print("Aftaler: ");
                        for (Aftale a : listA) {
                            System.out.print(a.getNavn() + ", ");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.print("Søg på drive: ");
                    String search = scanner2.nextLine();
                    List<String> results = drive.driveMain(search);
                    if (results.isEmpty()) {
                        System.out.println("Findes ikke");
                    } else {
                        for (String a : results) {
                            System.out.println(a + ", ");
                        }
                    }
                    break;
                case 4:
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Ugyldigt");
            }
            }catch(Exception e){
                System.out.println("HEY KUN TAL TAK");
                scanner.next();
                
            }
        }
    }

    public void menu() {
        System.out.println("");
        System.out.println("#################################################");
        System.out.println("Velkommen GruppeSystem");
        System.out.println("1 Se grupper");
        System.out.println("2 Se aftaler & opgaver");
        System.out.println("3 Brug drive");
        System.out.println("4 Exit");
        System.out.print("Skriv 1-4: ");
    }

}
