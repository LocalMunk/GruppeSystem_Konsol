/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppesystem_konsol;

import brugerautorisation.transport.soap.Brugeradmin;
import java.util.Scanner;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
public class GruppeSystem_Konsol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Du skal logge ind før, at du kan spille Galgeleg");
        while (true) {
            System.out.println("Indtast dit brugernavn (studie-nr.)");
            String bruger = scanner.nextLine();

            System.out.println("Indtast dit password");
            String password = scanner.nextLine();

            if (validate(bruger, password)) {
                break;
            }
        }
        System.out.println("Du er inde nu");
        
        //mere konsol ting
        
        
    }
    
public static boolean validate(String studienummer, String kodeord) throws MalformedURLException {

        URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
        QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
        Service service = Service.create(url, qname);
        Brugeradmin ba = service.getPort(Brugeradmin.class);
        try {
            ba.hentBruger(studienummer, kodeord);
            return true;

        } catch (Exception e) {
            System.out.println("forkert brugernavn");

            e.printStackTrace();
        }

        return false;
    }
}
    

