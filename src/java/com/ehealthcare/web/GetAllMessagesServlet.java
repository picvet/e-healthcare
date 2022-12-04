/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.MessagesFacadeLocal;
import com.ehealthcare.entities.Messages;
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
public class GetAllMessagesServlet extends HttpServlet {

    @EJB
    private MessagesFacadeLocal messagesFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        
        String title = (String)session.getAttribute("title");
        
        // using the facade to find the messages using the title
        // adding that to a list
        
        List<Messages> messagesDatabase = messagesFacade.findAllMessages();
        List<Messages> messages = new ArrayList<>();
        
        System.out.println(messagesDatabase);
        
        for(Messages m : messagesDatabase){     
            if(m.getTitle().equalsIgnoreCase(null)){
                
            }else{
            if (m.getTitle().equalsIgnoreCase(title)) {
                messages.add(m);
             }
            }
        }
        session.setAttribute("messages", messages);
        
        //Redirect to dedicated page
        String location = (String)session.getAttribute("location");
        
        
        if ( location.equalsIgnoreCase("doc")) {
            RequestDispatcher dis = request.getRequestDispatcher("chat_doctor.jsp");
            dis.forward(request, response); 
        } else 
        {
            RequestDispatcher dis = request.getRequestDispatcher("chat_patient.jsp");
            dis.forward(request, response);
        }
        
    }
}
