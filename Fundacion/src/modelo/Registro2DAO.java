/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SARA
 */
public class Registro2DAO {
    
    Conexion cn = new Conexion();
    Connection con; //Verificar la instrucción sql y ejecutarla
    PreparedStatement ps;//Objeto donde se carga el resultado de la consulta
    ResultSet rs; //Objeto que guarda el resultado de la consulta
    Registro2 registro2 = new Registro2();
    private Object registro2list;
    
     public boolean adicionar (Registro2 registro2) {
        String sql = "insert into participantes(primerNombre, segundoNombre, primerApellido,segundoApellido,"
       + " sexo,tipoDocumento,ndocumento,fechaNacimiento,edad,coberturaEnsalud,primerNombreacudiente,segundoNombreacudiente,"
        + "primerApellidoacudiente,segundoApellidoacudiente,parentesco,direccion,sector,telefono,observaciones)"
        + "values ('" + registro2.getPrimerNombre() +
        "','"+registro2.getSegundoNombre()+"','"+registro2.getPrimerApellido()+"','"+registro2.getSegundoApellido()+
        "','"+registro2.getSexo()+"','"+registro2.getTipoDocumento()+"',"+registro2.getNdocumento()+",'"
        + registro2.getFechaNacimiento()+"','"+registro2.getEdad()+"','"+registro2.getCoberturaEnsalud()+"','"
        + registro2.getPrimerNombreacudiente()+"','"+registro2.getSegundoNombreacudiente()+"','"
        + registro2.getPrimerApellidoacudiente()+"','"+registro2.getSegundoApellidoacudiente()+"','"+registro2.getParentesco()+"','"
        + registro2.getDireccion()+"','"+registro2.getSector()+"','"+registro2.getTelefono()+"','"+registro2.getObservaciones()+"')";
        
        //Conectarse a BD
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Registro2DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return false;
        }
        return true;
   
        }
      public Registro2 consultaDato(int ndocumento) throws SQLException{
       String sql = "Select * from participantes where ndocumento="+ndocumento;
       con = cn.getConnection(); //Establece la conexion
       ps = con.prepareStatement(sql); //Se prepara el codigo sql
       rs = ps.executeQuery();
       while(rs.next()){
          registro2.setPrimerNombre(rs.getString("primerNombre"));
          registro2.setSegundoNombre(rs.getString("segundoNombre"));
          registro2.setPrimerApellido(rs.getString("primerApellido"));
          registro2.setSegundoApellido(rs.getString("segundoApellido"));
          registro2.setSexo(rs.getString("sexo"));
          registro2.setTipoDocumento(rs.getString("tipoDocumento"));
          registro2.setNdocumento(rs.getInt("ndocumento"));
          registro2.setFechaNacimiento(rs.getDate("fechaNacimiento"));
          registro2.setEdad(rs.getString("edad"));
          registro2.setCoberturaEnsalud(rs.getString("coberturaEnsalud"));
          registro2.setPrimerNombreacudiente(rs.getString("primerNombreacudiente"));
          registro2.setSegundoNombreacudiente(rs.getString("segundoNombreacudiente"));
          registro2.setPrimerApellidoacudiente(rs.getString("primerApellidoacudiente"));
          registro2.setSegundoApellidoacudiente(rs.getString("segundoApellidoacudiente"));
          registro2.setParentesco(rs.getString("parentesco"));
          registro2.setDireccion(rs.getString("direccion"));
          registro2.setSector(rs.getString("sector"));
          registro2.setTelefono(rs.getString("telefono"));
          registro2.setObservaciones(rs.getString("observaciones"));
         
          
       }
       return registro2;
      }
      
     public boolean actualizarDatos(Registro2 registro2){
        String sql = "update participantes set primerNombre='"+registro2.getPrimerNombre()+"',segundoNombre='"+
                registro2.getSegundoNombre()+"',primerApellido='"+registro2.getPrimerApellido()+
                "',segundoApellido='"+registro2.getSegundoApellido()+"',sexo='"+registro2.getSexo()+
                "',tipoDocumento='"+registro2.getTipoDocumento()+"',"
                + "fechaNacimiento='"+registro2.getFechaNacimiento()+"',edad='"+registro2.getEdad()+"',"
                + "coberturaEnsalud='"+registro2.getCoberturaEnsalud()+"',"
                + "primerNombreacudiente='"+registro2.getPrimerNombreacudiente()+"',"
                + "segundoNombreacudiente='"+registro2.getSegundoNombreacudiente()+"',"
                + "primerApellidoacudiente='"+registro2.getPrimerApellidoacudiente()+"',"
                + "segundoApellidoacudiente='"+registro2.getSegundoApellidoacudiente()+"',"
                + "parentesco='"+registro2.getParentesco()+"',direccion='"+registro2.getDireccion()+"',"
                + "sector='"+registro2.getSector()+"',telefono='"+registro2.getTelefono()+"',"
                + "observaciones='"+registro2.getObservaciones()+"' where ndocumento="+
                registro2.getNdocumento();
        //Conectarse a BD
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Registro2DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return false;
        }
        return true;
    }  
    
       public boolean eliminarParticipantes(String ndocumento){
        String sql = "Delete from participantes where ndocumento='"+ndocumento+"'";
        //Conectarse a BD
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Registro2DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return false;
        }
        return true;
    
    }
        public ArrayList listarParticipantes(int nDoc) throws SQLException{
       String sql = "Select * from participantes";
       con = cn.getConnection(); //Establece la conexion
       ps = con.prepareStatement(sql); //Se prepara el codigo sql
       rs = ps.executeQuery();
       ArrayList registro2list = new ArrayList();
       while(rs.next()){
          registro2.setPrimerNombre(rs.getString("primer nombre"));
          registro2.setSegundoNombre(rs.getString("segundo nombre"));
          registro2.setPrimerApellido(rs.getString("primer apellido"));
          registro2.setSegundoApellido(rs.getString("segundo apellido"));
          registro2.setSexo(rs.getString("sexo"));
          registro2.setTipoDocumento(rs.getString("tipo documento"));
          registro2.setNdocumento(rs.getInt("ndocumento"));
          registro2.setFechaNacimiento(rs.getDate("fecha nacimiento"));
          registro2.setEdad(rs.getString("edad"));
          registro2.setCoberturaEnsalud(rs.getString("cobertura en salud"));
          registro2.setPrimerNombreacudiente(rs.getString("primer nombre acudiente"));
          registro2.setSegundoNombreacudiente(rs.getString("segundo nombre acudiente"));
          registro2.setPrimerApellidoacudiente(rs.getString("primer apellido acudiente"));
          registro2.setSegundoApellidoacudiente(rs.getString("segundo apellido acudiente"));
          registro2.setParentesco(rs.getString("parentesco"));
          registro2.setDireccion(rs.getString("direccion"));
          registro2.setSector(rs.getString("sector"));
          registro2.setTelefono(rs.getString("telefono"));
          registro2.setObservaciones(rs.getString("observaciones"));
          
          //Llenar el ArrayList con todos los registros que trae de la consulta participantes
          registro2list.add(new Registro2(registro2.getPrimerNombre(), registro2.getSegundoNombre(),
          registro2.getPrimerApellido(), registro2.getSegundoApellido(),registro2.getSexo(),
          registro2.getTipoDocumento(),registro2.getNdocumento(),registro2.getFechaNacimiento(),
          registro2.getEdad(),registro2.getCoberturaEnsalud(),registro2.getPrimerNombreacudiente(),
          registro2.getSegundoNombreacudiente(),registro2.getPrimerApellidoacudiente(),
          registro2.getSegundoApellidoacudiente(),registro2.getParentesco(),registro2.getDireccion(),
          registro2.getSector(),registro2.getTelefono(),registro2.getObservaciones()));
       }
       return registro2list;
    }

    
}