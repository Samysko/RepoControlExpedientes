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
public class HospitalDao implements Dao{

    @Override
    public ArrayList consulta() {
        ArrayList lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select * from hospital";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            lista=new ArrayList();
            while(r.next())
            {
                Hospital hospital = new Hospital();
                hospital.setIdhospital(r.getInt("idhospital"));
                hospital.setNombre(r.getString("nombre"));
                hospital.setDireccion(r.getString("direccion"));
                lista.add(hospital);
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
       
       String sql="insert into hospital(nombre, direccion) values(?, ?)";
       
       PreparedStatement ps=c.prepareStatement(sql);
       
       Hospital hospital=(Hospital)o;
       
       ps.setString(1, hospital.getNombre());
       ps.setString(2, hospital.getDireccion());
       
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
