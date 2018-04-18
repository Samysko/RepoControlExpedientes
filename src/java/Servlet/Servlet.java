/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.UsuariosDelSistema;
import java.io.IOException;
import java.io.PrintWriter;
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
        }else if(pagina.equals("altadoctor")){
            altadoctor(request, response);
        }else if(pagina.equals("altapaciente")){
            altapaciente(request, response);
        }else if(pagina.equals("altahospital")){
            altahospital(request, response);
        }else if(pagina.equals("altausuariosdelsistema")){
            altausuariosdelsistema(request, response);
        }else if(pagina.equals("altaexpedienteclinico")){
            altaexpedienteclinico(request, response);
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
                    System.out.println(usu.getIdusuariosdelsistema());
                    usudao.inicioSesion(usu.getIdusuariosdelsistema());
                    flag = true;
                    response.sendRedirect("pages/PaginaPrincipal.jsp");
                    
                }
                
            }

            if(flag == false){
                out.println("<div> Contraseña incorrecta, por favor intenta de nuevo </div>");
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void altadoctor(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        System.out.println("estás dentro de alta doctor servlet");
        response.setContentType("text/html");
        try {
            PrintWriter out=response.getWriter();
            DoctorDao docdao = new DoctorDao();
            
            boolean flag = false;

            String nombre = request.getParameter("nombre");
            String apellidopaterno = request.getParameter("apellidopaterno");
            String apellidomaterno = request.getParameter("apellidomaterno");
            String titulo = request.getParameter("titulo");
            Float salario = Float.parseFloat(request.getParameter("salario"));
            int idhospital = Integer.parseInt(request.getParameter("idhospital"));
            
            Doctor doctor = new Doctor();
            
            doctor.setNombre(nombre);
            doctor.setApellidopaterno(apellidopaterno);
            doctor.setApellidomaterno(apellidomaterno);
            doctor.setTitulo(titulo);
            doctor.setSalario(salario);
            doctor.setIdhospital(idhospital);
            
            docdao.alta(doctor);
            
            response.sendRedirect("pages/AltaDoctor.jsp");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void altapaciente(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("estás dentro de alta paciente servlet");
        response.setContentType("text/html");
        try {
            PrintWriter out=response.getWriter();
            PacienteDao pacientedao = new PacienteDao();
            
            boolean flag = false;

            String nombre = request.getParameter("nombre");
            String apellidopaterno = request.getParameter("apellidopaterno");
            String apellidomaterno = request.getParameter("apellidomaterno");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String direccion = request.getParameter("direccion");
            float peso = Float.parseFloat(request.getParameter("peso"));
            
            Paciente paciente = new Paciente();
            
            paciente.setNombre(nombre);
            paciente.setApellidopaterno(apellidopaterno);
            paciente.setApellidomaterno(apellidomaterno);
            paciente.setEdad(edad);
            paciente.setDireccion(direccion);
            paciente.setPeso(peso);
            
            pacientedao.alta(paciente);
            
            response.sendRedirect("pages/AltaPaciente.jsp");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void altahospital(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("estás dentro de alta hospital servlet");
        response.setContentType("text/html");
        try {
            PrintWriter out=response.getWriter();
            HospitalDao pacientedao = new HospitalDao();
            
            boolean flag = false;

            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            
            Hospital hospital = new Hospital();
            
            hospital.setNombre(nombre);
            hospital.setDireccion(direccion);
            
            pacientedao.alta(hospital);
            
            response.sendRedirect("pages/AltaHospital.jsp");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    private void altausuariosdelsistema(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("estás dentro de alta de usuarios del sistema servlet");
        response.setContentType("text/html");
        try {
            PrintWriter out=response.getWriter();
            UsuariosDelSistemaDao usuariosdelsistemadao = new UsuariosDelSistemaDao();
            
            boolean flag = false;

            String idusuario = request.getParameter("idusuario");
            String contraseña = request.getParameter("contrasena");
            
            UsuariosDelSistema usuariodelsistema = new UsuariosDelSistema();
            
            usuariodelsistema.setIdusuariosdelsistema(idusuario);
            usuariodelsistema.setContraseña(contraseña);
            
            usuariosdelsistemadao.alta(usuariodelsistema);
            
            response.sendRedirect("pages/AltaUsuariosDelSistema.jsp");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void altaexpedienteclinico(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("estás dentro de alta expediente clinico servlet");
        response.setContentType("text/html");
        try {
            PrintWriter out=response.getWriter();
            ExpedienteClinicoDao expedienteclinicodao = new ExpedienteClinicoDao();
            
            boolean flag = false;

            String fechadeexaminacion = request.getParameter("fechaex");
            String diagnosticomedico = request.getParameter("diagnosticomedico");
            int idpaciente = Integer.parseInt(request.getParameter("idpaciente"));
            int iddoctor = Integer.parseInt(request.getParameter("iddoctor"));
            int idhosptial = Integer.parseInt(request.getParameter("idhospital"));
            
            System.out.println(fechadeexaminacion + " " + diagnosticomedico + " " +
                    idpaciente + " " + iddoctor + " " + idhosptial);
            
            ExpedienteClinico expedienteclinico = new ExpedienteClinico();
            
            expedienteclinico.setFechadeexaminacion(fechadeexaminacion);
            expedienteclinico.setDiagnosticomedico(diagnosticomedico);
            expedienteclinico.setIdpaciente(idpaciente);
            expedienteclinico.setIddoctor(iddoctor);
            expedienteclinico.setIdhospital(idhosptial);
            
            expedienteclinicodao.alta(expedienteclinico);
            
            response.sendRedirect("pages/AltaPaciente.jsp");
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
