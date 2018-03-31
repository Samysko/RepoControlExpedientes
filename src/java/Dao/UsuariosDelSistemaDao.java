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
public class UsuariosDelSistemaDao implements Dao{

    @Override
    public ArrayList consulta() {
        ArrayList lista=null;
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select * from usuariosdelsistema";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            lista=new ArrayList();
            while(r.next())
            {
                UsuariosDelSistema usuario=new UsuariosDelSistema();
                usuario.setIdusuariosdelsistema(r.getString("idusuariosdelsistema"));
                usuario.setContraseña(r.getString("contraseña"));
                lista.add(usuario);
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
