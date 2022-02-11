/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Registro2;
import modelo.Registro2DAO;
import vista.FormRegistro2;

/**
 *
 * @author SALA406-27
 */
public class ControladorRegistro2 implements ActionListener{
    
    private FormRegistro2 fregistro2;
    private Registro2 registro2;
    private Registro2DAO registro2d;
    
    
    public ControladorRegistro2(FormRegistro2 fregistro2, Registro2 registro2, Registro2DAO registro2d) {
        this.fregistro2 = fregistro2;
        this.registro2 = registro2;
        this.registro2d = registro2d;
        this.fregistro2.jBtGuardar.addActionListener(this);
        this.fregistro2.jBtConsultar.addActionListener(this);
        this.fregistro2.jBtActualizar.addActionListener(this);
        this.fregistro2.jBtEliminar.addActionListener(this);
        this.fregistro2.jBtSalir.addActionListener(this);
        this.fregistro2.jBtNuevo.addActionListener(this);
    }

   

  
   
    
    
    //este validar sirve para colocar los campos obligatorios
    public boolean validar(){
      boolean ok=true;  
      if(fregistro2.jTxprimerNombre.getText().isEmpty()){
        JOptionPane.showMessageDialog(fregistro2, "por favor llene todos los campos, si no cuenta con la información del campo requerido, coloque una X ", "AVISO", JOptionPane.ERROR_MESSAGE);
        ok=false;
      }
      else if(fregistro2.jTxprimerApellido.getText().isEmpty()){
        JOptionPane.showMessageDialog(fregistro2, "por favor llene todos los campos, si no cuenta con la información del campo requerido, coloque una X ", "AVISO", JOptionPane.ERROR_MESSAGE);
        ok=false;
      }
      else if(fregistro2.jTxsexo.getText().isEmpty()){
        JOptionPane.showMessageDialog(fregistro2, "por favor llene todos los campos, si no cuenta con la información del campo requerido, coloque una X ", "AVISO", JOptionPane.ERROR_MESSAGE);
        ok=false;
      }
      
       else if(fregistro2.jTxtipoDocumento.getText().isEmpty()){
        JOptionPane.showMessageDialog(fregistro2, "por favor llene todos los campos, si no cuenta con la información del campo requerido, coloque una X ", "AVISO", JOptionPane.ERROR_MESSAGE);
        ok=false;
       }
       else if(fregistro2.jTxprimerNombreacudiente.getText().isEmpty()){
        JOptionPane.showMessageDialog(fregistro2, "por favor llene todos los campos, si no cuenta con la información del campo requerido, coloque una X ", "AVISO", JOptionPane.ERROR_MESSAGE);
        ok=false;
       }
       else if(fregistro2.jTxprimerApellidoacudiente.getText().isEmpty()){
        JOptionPane.showMessageDialog(fregistro2, "por favor llene todos los campos, si no cuenta con la información del campo requerido, coloque una X ", "AVISO", JOptionPane.ERROR_MESSAGE);
        ok=false;
       }
       else if(fregistro2.jTxdirección.getText().isEmpty()){
        JOptionPane.showMessageDialog(fregistro2, "por favor llene todos los campos ", "AVISO", JOptionPane.ERROR_MESSAGE);
        ok=false;
       }
       else if(fregistro2.jTxtelefono.getText().isEmpty()){
        JOptionPane.showMessageDialog(fregistro2, "por favor llene todos los campos,Si no cuenta con un número de contacto propio, por favor, ingrese el número de alguien cercano a usted ", "AVISO", JOptionPane.ERROR_MESSAGE);
        ok=false; 
       }
      if(fregistro2.jTxndocumento.getText().length()>10){
        JOptionPane.showMessageDialog(fregistro2, "el documento debe tener maximo 10 caracteres", "AVISO", JOptionPane.ERROR_MESSAGE);
        ok=false;
       }
           
     return ok;
           

} 
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==fregistro2.jBtGuardar){
          if(validar()){  
            String primern= fregistro2.jTxprimerNombre.getText();
            String segundon= fregistro2.jTxsegundoNombre.getText();
            String primerap = fregistro2.jTxsexo.getText();
            String segundoap=fregistro2.jTxsegundoApellido.getText();
            String sex=fregistro2.jTxsexo.getText();
            String tipoDoc=fregistro2.jTxtipoDocumento.getText();
            int ndocu=Integer.parseInt(fregistro2.jTxndocumento.getText());
            String edad=fregistro2.jTxedad.getText();
            
            //Capturar dato fecha
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = format.format(fregistro2.jDtfechaNacimiento.getDate());
            java.util.Date fechaN=null;
          
            try {
              fechaN = format.parse(fecha);
            } catch (ParseException ex) {
              Logger.getLogger(ControladorRegistro2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            java.sql.Date fechasql = new java.sql.Date(fechaN.getTime());
            String salud = fregistro2.jTxcoberturaEnsalud.getText();
            String primerna = fregistro2.jTxprimerNombreacudiente.getText();
            String segundona = fregistro2.jTxsegundoNombreacudiente.getText();
            String primerapeacu=fregistro2.jTxprimerApellidoacudiente.getText();
            String segundoapeacu=fregistro2.jTxsegundoApellidoacudiente.getText();
            String parent=fregistro2.jTxparentesco.getText();
            String direc=fregistro2.jTxdirección.getText();
            String sect=fregistro2.jTxsector.getText();
            String tel=fregistro2.jTxtelefono.getText();
            String ob=fregistro2.jTxobservaciones.getText();
            registro2 = new Registro2(primern, segundon, primerap, segundon,sex,tipoDoc,ndocu,fechasql,edad,salud,primerna,
            segundona,primerapeacu,segundoapeacu,parent,direc,sect,tel,ob);
            if(registro2d.adicionar(registro2)){
               JOptionPane.showMessageDialog(fregistro2, "participante registrado con éxito");
               limpiarControles();
            }else{
                JOptionPane.showMessageDialog(fregistro2, "participante No registrado - verificar datos", "AVISO", JOptionPane.ERROR_MESSAGE);  
            }
          }   
        }
        if(e.getSource()==fregistro2.jBtSalir){
            int respuesta = JOptionPane.showConfirmDialog(fregistro2, "¿Esta seguro de salir?", "Fin Datos Persona", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
               fregistro2.dispose();
            }
        }
        if(e.getSource()==fregistro2.jBtConsultar){
          int ident = Integer.parseInt(JOptionPane.showInputDialog("Identificación del participante: "));
          
            try {
                registro2 = registro2d.consultaDato(ident);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistro2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (registro2.getNdocumento()==0){
                JOptionPane.showMessageDialog(fregistro2,"este participante no esta registrado");
            } else {
                fregistro2.jTxprimerNombre.setText(registro2.getPrimerNombre());
                fregistro2.jTxsegundoNombre.setText(registro2.getSegundoNombre());
                fregistro2.jTxprimerApellido.setText(registro2.getPrimerApellido());
                fregistro2.jTxsegundoApellido.setText(registro2.getSegundoApellido());
                fregistro2.jTxsexo.setText(registro2.getSexo());
                fregistro2.jTxtipoDocumento.setText(registro2.getTipoDocumento());
                fregistro2.jTxndocumento.setText(String.valueOf(registro2.getNdocumento()));
                fregistro2.jDtfechaNacimiento.setDate(registro2.getFechaNacimiento());
                fregistro2.jTxedad.setText(registro2.getEdad());
                fregistro2.jTxcoberturaEnsalud.setText(registro2.getCoberturaEnsalud());
                fregistro2.jTxprimerNombreacudiente.setText(registro2.getPrimerNombreacudiente());
                fregistro2.jTxsegundoNombreacudiente.setText(registro2.getSegundoNombreacudiente());
                fregistro2.jTxprimerApellidoacudiente.setText(registro2.getPrimerApellidoacudiente());
                fregistro2.jTxsegundoApellidoacudiente.setText(registro2.getSegundoApellidoacudiente());
                fregistro2.jTxparentesco.setText(registro2.getParentesco());
                fregistro2.jTxdirección.setText(registro2.getDireccion());
                fregistro2.jTxsector.setText(registro2.getSector());
                fregistro2.jTxtelefono.setText(registro2.getTelefono());
                fregistro2.jTxobservaciones.setText(registro2.getObservaciones());
            } 
            //Enviando los datos del objeto a al vista
        }  
        if(e.getSource()==fregistro2.jBtActualizar){
            if(validar()){  
                String primern= fregistro2.jTxprimerNombre.getText();
                String segundon= fregistro2.jTxsegundoNombre.getText();
                String primerap = fregistro2.jTxsexo.getText();
                String segundoap=fregistro2.jTxsegundoApellido.getText();
                String sex=fregistro2.jTxsexo.getText();
                String tipoDoc=fregistro2.jTxtipoDocumento.getText();
                int ndocu=Integer.parseInt(fregistro2.jTxndocumento.getText());
                String edad=fregistro2.jTxedad.getText();
                //Capturar dato fecha
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = format.format(fregistro2.jDtfechaNacimiento.getDate());
                java.util.Date fechaN=null;
                try {
                    fechaN = format.parse(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(ControladorRegistro2.class.getName()).log(Level.SEVERE, null, ex);
                }
                java.sql.Date fechasql = new java.sql.Date(fechaN.getTime());
                String salud = fregistro2.jTxcoberturaEnsalud.getText();
                String primerna = fregistro2.jTxprimerNombreacudiente.getText();
                String segundona = fregistro2.jTxsegundoNombreacudiente.getText();
                String primerapeacu=fregistro2.jTxprimerApellidoacudiente.getText();
                String segundoapeacu=fregistro2.jTxsegundoApellidoacudiente.getText();
                String parent=fregistro2.jTxparentesco.getText();
                String direc=fregistro2.jTxdirección.getText();
                String sect=fregistro2.jTxsector.getText();
                String tel=fregistro2.jTxtelefono.getText();
                String ob=fregistro2.jTxobservaciones.getText();
                registro2 = new Registro2(primern, segundon, primerap, segundon,sex,tipoDoc,ndocu,fechasql,edad,salud,primerna,
                segundona,primerapeacu,segundoapeacu,parent,direc,sect,tel,ob);

                if(registro2d.actualizarDatos(registro2)){
                   JOptionPane.showMessageDialog(fregistro2, "Participante actualizado con éxito"); 
                }else{
                    JOptionPane.showMessageDialog(fregistro2, "Participante No se actualizó - verificar datos");  
                }
            }    
        }
        if(e.getSource()==fregistro2.jBtEliminar){
            String id = fregistro2.jTxndocumento.getText();
            int respuesta = JOptionPane.showConfirmDialog(fregistro2, "¿Esta seguro de eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
              if(registro2d.eliminarParticipantes(id)){
                JOptionPane.showMessageDialog(fregistro2, "El participante se eliminó con éxito");
                limpiarControles();
              }else{
                JOptionPane.showMessageDialog(fregistro2, "El participante No se elimino - verificar datos");  
              }   
            }
        }
        if (e.getSource()==fregistro2.jBtNuevo){
          limpiarControles();
        }
    }
   
        

    private void limpiarControles(){
     java.util.Date date = new java.sql.Date(new java.util.Date().getTime());
      fregistro2.jTxprimerNombre.setText("");
      fregistro2.jTxsegundoNombre.setText("");
      fregistro2.jTxsexo.setText("");
      fregistro2.jTxprimerApellido.setText("");
      fregistro2.jTxsegundoApellido.setText("");
      fregistro2.jTxsexo.setText("");
      fregistro2.jTxtipoDocumento.setText("");
      fregistro2.jTxndocumento.setText("");
      fregistro2.jDtfechaNacimiento.setDate(date);
      fregistro2.jTxedad.setText("");
      fregistro2.jTxcoberturaEnsalud.setText("");
      fregistro2.jTxprimerNombreacudiente.setText("");
      fregistro2.jTxsegundoNombreacudiente.setText("");
      fregistro2.jTxprimerApellidoacudiente.setText("");
      fregistro2.jTxsegundoApellidoacudiente.setText("");
      fregistro2.jTxparentesco.setText("");
      fregistro2.jTxdirección.setText("");
      fregistro2.jTxsector.setText("");
      fregistro2.jTxtelefono.setText("");
      fregistro2.jTxobservaciones.setText("");
     
        
    }

}
       
    
       
