/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.FAQsDAO;
import dbaccess.ItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lehai
 */
public class DeleteItemServlet extends HttpServlet {

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
            String msg;
            //kiem tra item hien co FAQ hay ko, neu co khong duoc thuc hien hanh dong xoa
            ArrayList<Integer> faqID = FAQsDAO.getFAQsIdfromItemId(Integer.parseInt(itemid));

            if (faqID != null && faqID.size() > 0) {
                msg = "Failed to remove because this item currently has FAQ";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("MainController?action=manageItem").forward(request, response);
            } else {
                int rs = ItemDAO.deleteItem(Integer.parseInt(itemid));
                if (rs > 0) {
                    msg = "Successful removed";
                    request.setAttribute("msg", msg);
                    request.getRequestDispatcher("MainController?action=manageItem").forward(request, response);
                } else {
                    msg = "Failed to remove";
                    request.setAttribute("msg", msg);
                    request.getRequestDispatcher("MainController?action=manageItem").forward(request, response);
                }
            }

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
