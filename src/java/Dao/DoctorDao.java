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
            String sql="select * from doctor d join hospital h on d.idhospital = h.idhospital";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            lista=new ArrayList();
            while(r.next())
            {
                Doctor doctor = new Doctor();
                doctor.setIddoctor(Integer.parseInt(r.getString(1)));
                doctor.setNombre(r.getString(2));
                doctor.setSalario(r.getFloat(3));
                doctor.setApellidomaterno(r.getString(5));
                doctor.setApellidopaterno(r.getString(6));
                doctor.setTitulo(r.getString(4));
                doctor.setNombrehospital(r.getString(9));
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
