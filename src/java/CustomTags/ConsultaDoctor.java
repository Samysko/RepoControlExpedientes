/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
import Dao.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author TechM User
 */
public class ConsultaDoctor extends TagSupport{
    ArrayList<Doctor> listadoctor;
    @Override
    public int doStartTag() throws JspException {
        System.out.println("estas dentro dostartag de consultadoctor");
        
        DoctorDao dd = new DoctorDao();
        
        listadoctor = dd.consulta();
        
        JspWriter out=pageContext.getOut();
        
        if(listadoctor.isEmpty()){
            System.out.println("No hay doctores");
        }else{
            for (Doctor doctor : listadoctor) {
                System.out.println(doctor.getNombre());
                try {
                    out.println("<tr>");
                    out.println("<td>" + doctor.getIddoctor() + "</td>");
                    out.println("<td>" + doctor.getNombre()+ "</td>");
                    out.println("<td>" + doctor.getApellidopaterno()+ "</td>");
                    out.println("<td>" + doctor.getApellidomaterno() + "</td>");
                    out.println("<td>" + doctor.getTitulo()+ "</td>");
                    out.println("<td>" + doctor.getSalario()+ "</td>");
                    out.println("<td>" + doctor.getIdhospital()+ "</td>");
                    out.println("</tr>");
    //            <tr>
    //                <td>1</td>
    //                <td>Mark</td>
    //                <td>Otto</td>
    //                <td>@mdo</td>
    //            </tr>
                } catch (IOException ex) {
                    Logger.getLogger(ConsultaDoctor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
                
        return SKIP_BODY;
    }
    
}
