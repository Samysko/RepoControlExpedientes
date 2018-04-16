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
public class PacienteDao implements Dao{

    @Override
    public ArrayList consulta() {
            ArrayList lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select * from paciente";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            lista=new ArrayList();
            while(r.next())
            {
                Paciente paciente = new Paciente();
                paciente.setIdpaciente(r.getInt("idpaciente"));
                paciente.setNombre(r.getString("nombre"));
                paciente.setApellidopaterno(r.getString("apellidopaterno"));
                paciente.setApellidomaterno(r.getString("apellidomaterno"));
                paciente.setEdad(r.getInt("edad"));
                paciente.setDireccion(r.getString("direccion"));
                paciente.setPeso(r.getFloat("peso"));
                lista.add(paciente);
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
       boolean b = false;
       try{
       Connection c = new DataSource().getConexion();
       
       String sql="insert into paciente(nombre, apellidopaterno, apellidomaterno, direccion, "
               + "edad, peso) values(?, ?, ?, ?, ?, ?)";
       
       PreparedStatement ps=c.prepareStatement(sql);
       
       Paciente paciente=(Paciente)o;
       
       ps.setString(1, paciente.getNombre());
       ps.setString(2, paciente.getApellidopaterno());
       ps.setString(3, paciente.getApellidomaterno());
       ps.setString(4, paciente.getDireccion());
       ps.setInt(5, paciente.getEdad());
       ps.setFloat(6, paciente.getPeso());
       
       int r= ps.executeUpdate();
       
       if(r>0){
           b=true;
       }
           ps.close();
           c.close();
           
           
       }catch(Exception x){
           x.printStackTrace();
       }
       return b;
    }
    
}
