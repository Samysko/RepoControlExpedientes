/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTags;

import Dao.Paciente;
import Dao.PacienteDao;
import Dao.UsuariosDelSistema;
import Dao.UsuariosDelSistemaDao;
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
public class ConsultaUsuariosDelSistema extends TagSupport{
    ArrayList<UsuariosDelSistema> listausuariosdelsistema;
    @Override
    public int doStartTag() throws JspException {
        System.out.println("estas dentro dostartag de consultaususariosdelsistema");
        
        UsuariosDelSistemaDao udsd = new UsuariosDelSistemaDao();
        
        listausuariosdelsistema = udsd.consulta();//aqui te quedaste
        
        JspWriter out=pageContext.getOut();
        
        if(listausuariosdelsistema.isEmpty()){
            System.out.println("No hay usuarios del sistema");
        }else{
            for (UsuariosDelSistema usuariosdelsistema : listausuariosdelsistema) {
                System.out.println(usuariosdelsistema.getIdusuariosdelsistema());
                try {
                    out.println("<tr>");
                    out.println("<td>" + usuariosdelsistema.getIdusuariosdelsistema()+ "</td>");
                    out.println("<td>" + usuariosdelsistema.getContraseña()+ "</td>");
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
