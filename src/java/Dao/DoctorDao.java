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
public class DoctorDao implements Dao{

    @Override
    public ArrayList consulta() {
        ArrayList lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select d.iddoctor, d.nombre, d.salario, d.apellidomaterno, "
                    + "d.apellidopaterno, d.titulo, d.idhospital "
                    + "from doctor d "
                    + "join hospital h on d.idhospital = h.idhospital";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            lista=new ArrayList();
            while(r.next())
            {
                Doctor doctor = new Doctor();
                doctor.setIddoctor(Integer.parseInt(r.getString("iddoctor")));
                doctor.setNombre(r.getString("nombre"));
                doctor.setSalario(r.getFloat("salario"));
                doctor.setApellidomaterno(r.getString("apellidomaterno"));
                doctor.setApellidopaterno(r.getString("apellidopaterno"));
                doctor.setTitulo(r.getString("titulo"));
                doctor.setIdhospital(r.getInt("idhospital"));
                lista.add(doctor);
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
