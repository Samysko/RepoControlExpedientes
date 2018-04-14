/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author TechM User
 */
public class ExpedienteClinico {
    private int idexpedienteclinico, idpaciente, iddoctor, idhospital;
    private String fechadeexaminacion, diagnosticomedico, nombrepaciente, nombredoctor, nombrehospital;

    public int getIdexpedienteclinico() {
        return idexpedienteclinico;
    }

    public String getNombrepaciente() {
        return nombrepaciente;
    }

    public void setNombrepaciente(String nombrepaciente) {
        this.nombrepaciente = nombrepaciente;
    }

    public String getNombredoctor() {
        return nombredoctor;
    }

    public void setNombredoctor(String nombredoctor) {
        this.nombredoctor = nombredoctor;
    }

    public String getNombrehospital() {
        return nombrehospital;
    }

    public void setNombrehospital(String nombrehospital) {
        this.nombrehospital = nombrehospital;
    }

    public void setIdexpedienteclinico(int idexpedienteclinicoid) {
        this.idexpedienteclinico = idexpedienteclinicoid;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public int getIdhospital() {
        return idhospital;
    }

    public void setIdhospital(int idhospital) {
        this.idhospital = idhospital;
    }

    public String getFechadeexaminacion() {
        return fechadeexaminacion;
    }

    public void setFechadeexaminacion(String fechadeexaminacion) {
        this.fechadeexaminacion = fechadeexaminacion;
    }

    public String getDiagnosticomedico() {
        return diagnosticomedico;
    }

    public void setDiagnosticomedico(String diagnosticomedico) {
        this.diagnosticomedico = diagnosticomedico;
    }
    
    
}
