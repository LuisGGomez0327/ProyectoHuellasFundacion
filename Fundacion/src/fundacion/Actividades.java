/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundacion;

/**
 *
 * @author SARA
 */
public class Actividades {
private String NombreActividad; 
private String Descripcion;
private String NombreProfesor; 
private String ApellidoProfesor;

//Método constructor / 
public Actividades() {
this.NombreActividad=NombreActividad;
this.Descripcion=Descripcion; 
this. NombreProfesor=NombreProfesor; 
this.ApellidoProfesor=ApellidoProfesor;





}

    public String getNombreActividad() {
        return NombreActividad;
    }

    public void setNombreActividad(String NombreActividad) {
        this.NombreActividad = NombreActividad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNombreProfesor() {
        return NombreProfesor;
    }

    public void setNombreProfesor(String NombreProfesor) {
        this.NombreProfesor = NombreProfesor;
    }

    public String getApellidoProfesor() {
        return ApellidoProfesor;
    }

    public void setApellidoProfesor(String ApellidoProfesor) {
        this.ApellidoProfesor = ApellidoProfesor;
    }
}
