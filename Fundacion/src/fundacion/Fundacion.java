/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundacion;

import modelo.Login;
import modelo.LoginDAO;
import vista.FormMenu;
import vista.Formbienvenido;

/**
 *
 * @author SARA
 */
public class Fundacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
        
        Login  milogin= new Login();
        LoginDAO logindao= new LoginDAO();
        
        Formbienvenido fbienvenido= new Formbienvenido();
        fbienvenido.setVisible(true);
     
    }
    
}
