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
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

/**
 *
 * @author TechM User
 */
public class ConsultaHospital extends TagSupport {
    ArrayList<Hospital> listahospital;
    @Override
    public int doStartTag() throws JspException {
        System.out.println("estas dentro dostartag de consultahospital");
        
        HospitalDao hd = new HospitalDao();
        
        listahospital = hd.consulta();//aqui te quedaste
        
        JspWriter out=pageContext.getOut();
        
        if(listahospital.isEmpty()){
            System.out.println("No hay hospital");
        }else{
            for (Hospital hospital : listahospital) {
                System.out.println(hospital.getNombre() + hospital.getIdhospital());
                System.out.println(hospital.getNombre());
                try {
                    out.println("<tr>");
                    out.println("<td>" + hospital.getIdhospital()+ "</td>");
                    out.println("<td>" + hospital.getNombre()+ "</td>");
                    out.println("<td>" + hospital.getDireccion()+ "</td>");
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
