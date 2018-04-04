/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTags;

import Dao.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author TechM User
 */
public class ConsultaExpedienteClinico extends TagSupport{
    ArrayList<ExpedienteClinico> listaexpedienteclinico;
    @Override
    public int doStartTag() throws JspException {
        System.out.println("estas dentro dostartag de consultaexpedienteclinico");
        
        ExpedienteClinicoDao ecd = new ExpedienteClinicoDao();
        
        listaexpedienteclinico = ecd.consulta();
        
        JspWriter out=pageContext.getOut();
        
        if(listaexpedienteclinico.isEmpty()){
            System.out.println("No hay ExpedientesClinicos");
        }else{
            for (ExpedienteClinico expedienteclinico : listaexpedienteclinico) {
                System.out.println(expedienteclinico.getIdpaciente());
                try {
                    out.println("<tr>");
                    out.println("<td>" + expedienteclinico.getIdexpedienteclinico()+ "</td>");
                    out.println("<td>" + expedienteclinico.getIdpaciente()+ "</td>");
                    out.println("<td>" + expedienteclinico.getIddoctor()+ "</td>");
                    out.println("<td>" + expedienteclinico.getIdhospital()+ "</td>");
                    out.println("<td>" + expedienteclinico.getFechadeexaminacion()+ "</td>");
                    out.println("<td>" + expedienteclinico.getDiagnosticomedico()+ "</td>");
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
