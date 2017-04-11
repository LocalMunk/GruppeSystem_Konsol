/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppesystem;

import javax.xml.ws.Endpoint;

/**
 *
 * @author frederik
 */
public class Server {
    
    public static void main (String[] args) {
        
        
        IGruppeSys grp = new GruppeSysImpl();
        
        Endpoint.publish("http://ubuntu4.javabog.dk:9902/gruppesystem_osteholdet", grp);
           
	System.out.println("Galgelegtjeneste publiceret min ven.");
        
    }
    
    
}
