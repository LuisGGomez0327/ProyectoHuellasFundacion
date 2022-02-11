/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author SARA
 */


public class Registro2 {

    /*Creación de los atributos de la clase*/
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;
    private String tipoDocumento;
    private int ndocumento;
    private Date fechaNacimiento;
    private String edad;
    private String coberturaEnsalud;
    private String primerNombreacudiente;
    private String segundoNombreacudiente;
    private String primerApellidoacudiente;
    private String segundoApellidoacudiente;
    private String parentesco;
    private String direccion;
    private String sector;
    private String telefono;
  
    private String observaciones;

    public Registro2() {
    }
    

    public Registro2(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String sexo, String tipoDocumento, int ndocumento, Date fechaNacimiento, String edad, String coberturaEnsalud, String primerNombreacudiente, String segundoNombreacudiente, String primerApellidoacudiente, String segundoApellidoacudiente, String parentesco, String direccion, String sector, String telefono, String observaciones) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.sexo = sexo;
        this.tipoDocumento = tipoDocumento;
        this.ndocumento = ndocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.coberturaEnsalud = coberturaEnsalud;
        this.primerNombreacudiente = primerNombreacudiente;
        this.segundoNombreacudiente = segundoNombreacudiente;
        this.primerApellidoacudiente = primerApellidoacudiente;
        this.segundoApellidoacudiente = segundoApellidoacudiente;
        this.parentesco = parentesco;
        this.direccion = direccion;
        this.sector = sector;
        this.telefono = telefono;
        this.observaciones = observaciones;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNdocumento() {
        return ndocumento;
    }

    public void setNdocumento(int ndocumento) {
        this.ndocumento = ndocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCoberturaEnsalud() {
        return coberturaEnsalud;
    }

    public void setCoberturaEnsalud(String coberturaEnsalud) {
        this.coberturaEnsalud = coberturaEnsalud;
    }

    public String getPrimerNombreacudiente() {
        return primerNombreacudiente;
    }

    public void setPrimerNombreacudiente(String primerNombreacudiente) {
        this.primerNombreacudiente = primerNombreacudiente;
    }

    public String getSegundoNombreacudiente() {
        return segundoNombreacudiente;
    }

    public void setSegundoNombreacudiente(String segundoNombreacudiente) {
        this.segundoNombreacudiente = segundoNombreacudiente;
    }

    public String getPrimerApellidoacudiente() {
        return primerApellidoacudiente;
    }

    public void setPrimerApellidoacudiente(String primerApellidoacudiente) {
        this.primerApellidoacudiente = primerApellidoacudiente;
    }

    public String getSegundoApellidoacudiente() {
        return segundoApellidoacudiente;
    }

    public void setSegundoApellidoacudiente(String segundoApellidoacudiente) {
        this.segundoApellidoacudiente = segundoApellidoacudiente;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
      
}

   