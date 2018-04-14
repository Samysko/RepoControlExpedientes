/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//    <%@page import="Dao.*"%>
//                                                <%@page import="java.util.*"%>
//                                                <%
//                                                    HospitalDao hospitaldao = new HospitalDao();
//                                                    ArrayList<Hospital> listahospital = new ArrayList();
//                                                    listahospital = hospitaldao.consulta;   
//                                                    for(Hospital hospitaldao : listahospital){
//                                                        out.println("<option value='" + hospitaldao.getidhospital + "'>" + 
//                                                                + hospitaldao.getIdhospital + "</option>");
//                                                    }
//    %>
package CustomTags;

import Dao.DataSource;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.sql.*;
import java.util.ArrayList;
import Dao.*;

/**
 *
 * @author TechM User
 */
public class ConsultaSelect extends TagSupport{
    
    private String tabla, nombre;
    private int id;

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
    
    

    @Override
    public int doStartTag() throws JspException {
        System.out.println("estas dentro de consultaselect tag");
        JspWriter out=pageContext.getOut();
        try
        {
            Connection c=new DataSource().getConexion();
            String sql="select * from " + tabla;
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet r=ps.executeQuery();
            ArrayList<Doctor> lista=new ArrayList();
            while(r.next())
            {
                Doctor doc = new Doctor();
                doc.setIdhospital(r.getInt(1));
                doc.setNombrehospital(r.getString(2));
                lista.add(doc);
            }
            r.close();
            ps.close();
            c.close();
            
            for (Doctor doctor : lista) {
                out.println("<option value='"+doctor.getIdhospital()+"'>"+doctor.getNombrehospital()+"</option>");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return SKIP_BODY;
    }
}
