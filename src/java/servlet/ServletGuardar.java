/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CustomerFacade;
import java.io.IOException;
import entity.Customer;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author memoriasIT
 */
@WebServlet(name = "ServletGuardar", urlPatterns = {"/ServletGuardar"})
public class ServletGuardar extends HttpServlet {

    @EJB
    private CustomerFacade customerFacade;
    
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
        
        String id, nombre, email, phone;
        Customer cliente; 
        
        id = request.getParameter("id");
        nombre = request.getParameter("fname");
        email = request.getParameter("email");      
        phone = request.getParameter("phone");    
       
        if (id == null || id.isEmpty()) { // Crear nuevo cliente
            cliente = new Customer();            
        } else { // Editar cliente existente
            cliente = this.customerFacade.find(new Integer(id));
        }
        cliente.setName(nombre);
        cliente.setEmail(email);
        cliente.setPhone(phone);
        
        if (id == null || id.isEmpty()) { // Crear nuevo cliente        
            this.customerFacade.create(cliente);
        } else { // Editar cliente existente
            this.customerFacade.edit(cliente);
        }
        
        response.sendRedirect("ServletCustomerListar");
        
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

}
