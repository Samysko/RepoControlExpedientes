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
    private String fechadeexaminacion, diagnosticomedico;

    public int getIdexpedienteclinico() {
        return idexpedienteclinico;
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
