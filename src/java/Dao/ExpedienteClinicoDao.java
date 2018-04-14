/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TechM User
 */
public class ExpedienteClinicoDao implements Dao{

    @Override
    public ArrayList consulta() {
            ArrayList lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select ec.idpaciente, ec.diagnosticomedico, ec.fechadeexaminacion, "
                    + "ec.iddoctor, ec.idhospital, ec.idexpedienteclinico, p.nombre nombrepa, "
                    + "d.nombre nombredoc, h.nombre nombrehos "
                    + "from expedienteclinico ec "
                    + "join paciente p on ec.idpaciente = p.idpaciente "
                    + "join doctor d on d.iddoctor = ec.iddoctor "
                    + "join hospital h on h.idhospital = ec.idhospital";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            lista=new ArrayList();
            while(r.next())
            {
                ExpedienteClinico expedienteclinico = new ExpedienteClinico();
                expedienteclinico.setIdpaciente(r.getInt("idpaciente"));
                expedienteclinico.setDiagnosticomedico(r.getString("diagnosticomedico"));
                expedienteclinico.setFechadeexaminacion(r.getString("fechadeexaminacion"));
                expedienteclinico.setIddoctor(r.getInt("iddoctor"));
                expedienteclinico.setIdhospital(r.getInt("idhospital"));
                expedienteclinico.setIdexpedienteclinico(r.getInt("idexpedienteclinico"));
                expedienteclinico.setNombredoctor(r.getString("nombredoc"));
                expedienteclinico.setNombrehospital(r.getString("nombrehos"));
                expedienteclinico.setNombrepaciente(r.getString("nombrepa"));
                
                lista.add(expedienteclinico);
            }
            r.close();
            ps.close();
            c.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean alta(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
