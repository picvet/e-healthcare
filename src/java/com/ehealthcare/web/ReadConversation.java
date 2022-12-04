/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.MessagesFacadeLocal;
import com.ehealthcare.entities.Messages;
import com.ehealthcare.entities.Patient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class ReadConversation extends HttpServlet {

    @EJB
    private MessagesFacadeLocal messagesFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Patient patient = (Patient) session.getAttribute("patient");
        
        String title = request.getParameter("title");
        
        // TODO: find the conversation in the messages database
        List<Messages> messagesDatabase = messagesFacade.findAllMessages();
        List<Messages> messages = new ArrayList<>();
        
        System.out.println(messagesDatabase);
        
        for(Messages m : messagesDatabase){   
            if (m.getTitle().equalsIgnoreCase(title)) {
                messages.add(m); 
            }
        }
        session.setAttribute("messages", messages);
        
        // TODO: Take to page for read only
        RequestDispatcher dis = request.getRequestDispatcher("jsp_pages/read_past_chat.jsp");
        dis.forward(request, response);
    }

}
