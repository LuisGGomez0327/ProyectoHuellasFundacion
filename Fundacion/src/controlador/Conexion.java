
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



   public class Conexion {
    Connection con;
  //Atributos o variables de la clase, declaradas e inicializadas.
    public String bd = "fundacion";
    public String login = "root";
    public String password = "";
    public String url = "jdbc:mysql://localhost/" + bd;  
    public Conexion(){
     try{
       Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection(url,login,password);
     }catch(ClassNotFoundException | SQLException e){
       System.err.println("Error " + e);
     }
    }
    public Connection getConnection(){
       return con; 
    }
}
 

