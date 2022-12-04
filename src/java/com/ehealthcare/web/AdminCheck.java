/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.AdminFacadeLocal;
import com.ehealthcare.entities.Admin;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Percival
 */
public class AdminCheck extends HttpServlet {

    @EJB
    private AdminFacadeLocal adminFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession(true);
         
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         
         // TODO: find the admin
         Admin admin = adminFacade.findAdmin(username);
         
         String nextPage = "user_not_found.html";
         // TODO: if null don't go to next page
         if (admin != null) {
             // TODO: check the password
             if (admin.getPassword().equals(password)) {
                nextPage = "jsp_pages/admin_home_page.jsp";

                // TODO: Store details to session
                session.setAttribute("admin", admin);
             }
         }
         
         RequestDispatcher dis = request.getRequestDispatcher(nextPage);
         dis.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dis = req.getRequestDispatcher("jsp_pages/admin_home_page.jsp");
        dis.forward(req, resp);
    } 

}
