/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import DTO.Projekt;
import static java.lang.System.in;
import java.rmi.Naming;
import java.rmi.Remote;
import java.util.Scanner;
import javax.xml.ws.Endpoint;
import brugerautorisation.transport.soap.BrugeradminImpl;
import brugerautorisation.server.Brugerdatabase;
import connector.Connector;
import server.ServerImpl;
import konsol.ServerInterface;
import java.sql.SQLException;


/**
 *
 * @author TheGeek
 */
public class Server {
    
   public static void main(String [] args)throws Exception{
      try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
       
       ServerInterface serv = new ServerImpl();


		
    // Ipv6-addressen [::] svarer til Ipv4-adressen 0.0.0.0, der matcher alle maskinens netkort og 
		Endpoint.publish("http://ubuntu4.javabog.dk:42072/server", serv);
           
		System.out.println("Gruppesys publiceret min ven.");
          
       
       
   }
    
   
    
}