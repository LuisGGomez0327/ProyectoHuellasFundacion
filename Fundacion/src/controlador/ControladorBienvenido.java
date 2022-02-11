/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionListener;
import modelo.Login;
import modelo.LoginDAO;
import vista.Formbienvenido;

/**
 *
 * @author SALA406-27
 */
public class ControladorBienvenido {
    private Formbienvenido fbienvenido;
    private Login login;
    private LoginDAO logind;
    
    public ControladorBienvenido (Formbienvenido fbienvenido,Login login,LoginDAO logind){
       this.fbienvenido=fbienvenido;
       this.login=login;
       this.logind=logind;
       
       this.fbienvenido.btnIngresar3.addActionListener((ActionListener) this);
       this.fbienvenido.btnSalir3.addActionListener((ActionListener) this);
     
         
    }
    
    
    /*String usuario = TxtUsuario.getText();//  Devuelve un objeto String como un tipo de dato cadena.
    String password = String.valueOf(clave.getText()); */
}
