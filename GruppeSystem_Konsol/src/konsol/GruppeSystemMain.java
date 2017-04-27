/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsol;

import konsol.GruppeSystem_Konsol;
import DALException.DALException;
import java.net.MalformedURLException;

/**
 *
 * @author frederik
 */
public class GruppeSystemMain {

    public static void main(String[] args) throws MalformedURLException, DALException {

        new GruppeSystem_Konsol().start();

    }

}
