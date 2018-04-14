/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

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
            String sql="select * from doctor";
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
       boolean b = false;
       try{
       Connection c = new DataSource().getConexion();
       
       String sql="insert into doctor(nombre, apellidopaterno, apellidomaterno, titulo, "
               + "salario, idhospital) values(?, ?, ?, ?, ?, ?)";
       
       PreparedStatement ps=c.prepareStatement(sql);
       
       Doctor doctor=(Doctor)o;
       
       ps.setString(1, doctor.getNombre());
       ps.setString(2, doctor.getApellidopaterno());
       ps.setString(3, doctor.getApellidomaterno());
       ps.setString(4, doctor.getTitulo());
       ps.setFloat(5, doctor.getSalario());
       ps.setInt(6, doctor.getIdhospital());
       
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
