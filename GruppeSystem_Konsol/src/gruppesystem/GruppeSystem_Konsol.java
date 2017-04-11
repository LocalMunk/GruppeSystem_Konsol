/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppesystem;

import brugerautorisation.transport.soap.Brugeradmin;
import java.util.Scanner;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
public class GruppeSystem_Konsol {

    GruppeSysImpl grp = new GruppeSysImpl();
            
    public void start() throws MalformedURLException {
        
        ;
        Scanner scanner = new Scanner(System.in);
        int num;
        
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
        
        menu();
        num = scanner.nextInt();
        
        switch (num) {
            case 1:
                   System.out.println("Her er alle dine grupper: " + grp.toString()); 
        }
            
        
        
        
        
        
        
        
        
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

public void menu(){
    
    System.out.println("Velkommen GruppeSystem");
    System.out.println("1\t Se grupper");
    System.out.println("2\t Se aftaler/opgaver");
    System.out.println("3\t Log ud");
    System.out.print("Skriv 1-3: ");
    
    
    
}

}
    

