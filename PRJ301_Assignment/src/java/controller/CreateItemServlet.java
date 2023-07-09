/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.ItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utility.DataValidator;

/**
 *
 * @author lehai
 */
public class CreateItemServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String itemid = request.getParameter("txtitemid");
            String itemName = request.getParameter("txtitemname");
            String itemPrice = request.getParameter("txtitemprice");
            String cateid = request.getParameter("txtcateid");
            String msg = "";
            int rs = 0;
            // Validate data
            boolean flag = true;
            if(DataValidator.checkID(Integer.parseInt(itemid.trim()))) {
                msg += "\nInvalid input ID: must be above zero or not match other ID";
                flag = false;
            }
            
            if(!DataValidator.checkNullString(itemName.trim())) {
                msg += "\nInvalid name: please fill it with name";
                flag = false;
            }
            
            if(!DataValidator.checkPrice(Integer.parseInt(itemPrice.trim()))) {
                msg += "\nInvalid price: must be above zero";
                flag = false;
            }
            
            if(!DataValidator.checkCategory(Integer.parseInt(cateid.trim()))) {
                msg += "\nThis category does not exist";
                flag = false;
            }
            // Create item
            if(flag) {
                rs = ItemDAO.insertItem(Integer.parseInt(itemid.trim()), itemName.trim(), Integer.parseInt(itemPrice.trim()), Integer.parseInt(cateid.trim()));
                if (rs > 0) {
                    msg = "Successfully created";
                } else {
                    msg = "Failed to created, something wrong";
                }
            }
            
            request.setAttribute("msg2", msg);
            request.getRequestDispatcher("MainController?action=manageItem").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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

}
