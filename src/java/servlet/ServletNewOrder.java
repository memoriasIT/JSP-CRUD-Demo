/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CustomerFacade;
import dao.ProductFacade;
import dao.PurchaseOrderFacade;
import entity.Customer;
import entity.PurchaseOrder;
import java.io.IOException;
import entity.Product;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author memoriasIT
 */
@WebServlet(name = "ServletNewOrder", urlPatterns = {"/ServletNewOrder"})
public class ServletNewOrder extends HttpServlet {

    @EJB
    private PurchaseOrderFacade purchaseOrderFacade;

    @EJB
    private ProductFacade productFacade;

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
        
        String id = request.getParameter("id");
        Customer client = this.customerFacade.findCustomerByID(new Integer(id));
        request.setAttribute("cliente", client);
        RequestDispatcher rd = request.getRequestDispatcher("createOrder.jsp");
        rd.forward(request, response);
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
        
        String id = request.getParameter("clientNum");
        Customer client = this.customerFacade.findCustomerByID(new Integer(id));
        
        Product prod = this.productFacade.getProductByID(new Integer(request.getParameter("prodID")));
        
        PurchaseOrder order = new PurchaseOrder();
        order.setCustomerId(client);
        order.setOrderNum(new Integer(request.getParameter("orderNum")));
        order.setQuantity(new Short(request.getParameter("quantity")));
        order.setProductId(prod);
        
        this.purchaseOrderFacade.create(order);
        
        String strTo = "ServletOrders?=" + id;
        response.sendRedirect(strTo);
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
