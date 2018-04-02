/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.UsuariosDelSistema;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.*;
import java.util.*;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author samuelbernal
 */
@WebServlet(name = "Servlet", urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Estas dentro de proces srequest");
        String pagina=request.getParameter("pagina");
        if(pagina.equals("login")){
            login(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void login(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        System.out.println("Estas dentro de login");
        response.setContentType("text/html");
        
        try {
            PrintWriter out=response.getWriter();
            
            boolean flag = false;

            String usuario = request.getParameter("usuario");
            String contraseña = request.getParameter("contrasena");
            System.out.println(usuario + " " + contraseña + " usuario y contraseña recibidos de pagina");

            UsuariosDelSistemaDao usudao = new UsuariosDelSistemaDao();

            ArrayList<UsuariosDelSistema> listausuarios = usudao.consulta();

            for (UsuariosDelSistema usu : listausuarios) {
                System.out.println("Usuario y contraseña a comparar = " + 
                        usu.getIdusuariosdelsistema()+ " " + usu.getContraseña());
                
                if(usu.getIdusuariosdelsistema().equals(usuario) && usu.getContraseña().equals(contraseña)){
                    response.sendRedirect("pages/PaginaPrincipal.jsp");
                    flag = true;
                }
                
            }

            if(flag == false){
                out.println("<div> Contraseña incorrecta, por favor intenta de nuevo </div>");
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
