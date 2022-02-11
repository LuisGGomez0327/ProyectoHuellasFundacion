/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SALA404-05
 */
public class LoginDAO {
    // Atributos de la conexión
    Conexion cn = new Conexion(); 
    Connection con; // Esta linea de código verificar la instriccion sql a ejecutar.
    PreparedStatement ps; // Objeto donde se carga. 
    ResultSet  rs; // Aquí se guardará el resultado de la consulta.  
    Login usu = new Login();
    
   public boolean validarLogin (String usuario,String password) {
        boolean ok ;
        
        String sql = "select * from usuarios where usuario='"+usuario+"' and contraseña='"+password+"'";
             
        try {
            ps = cn.getConnection().prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = ps.executeQuery();
            ok= true;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok=false;
        }
          return ok;     
   
   }      
}

