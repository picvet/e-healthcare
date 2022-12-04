/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.MessagesFacadeLocal;
import com.ehealthcare.entities.Doctor;
import com.ehealthcare.entities.Messages;
import com.ehealthcare.entities.Patient;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Percival
 */
public class MessageSendServlet extends HttpServlet {

    @EJB
    private MessagesFacadeLocal messagesFacade;
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // GETTING THE SESSION
        HttpSession session = request.getSession();
        String title = (String) session.getAttribute("title");
        String message = request.getParameter("message");
        
        String location = (String)session.getAttribute("location");
        
        if (location.equalsIgnoreCase("doc")) {
            Doctor doctor = (Doctor) session.getAttribute("doctor");
            
            String username = doctor.getUsername();
            
            Messages messages = createMessage(message, username, title);
            // persist it to database
            messagesFacade.createMessages(messages);

            response.sendRedirect("GetAllMessagesServlet.do");
        } else {
            Patient patient = (Patient) session.getAttribute("patient");
 
            String username = patient.getUsername();

            Messages messages = createMessage(message, username, title);
            // persist it to database
            messagesFacade.createMessages(messages);

            response.sendRedirect("GetAllMessagesServlet.do"); 
        }
    }
    
    private Messages createMessage(String message, String username, String title) {
        Messages messages = new Messages();
        messages.setDateTime(new Date());
        messages.setMessage(message);
        messages.setTitle(title);
        messages.setSender(username);
        return messages;
    }

}
