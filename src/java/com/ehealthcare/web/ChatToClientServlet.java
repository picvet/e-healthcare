/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.ChatRoomsFacadeLocal; 
import com.ehealthcare.entities.ChatRooms;
import java.io.IOException;
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
public class ChatToClientServlet extends HttpServlet {

    @EJB
    private ChatRoomsFacadeLocal chatRoomsFacade1;

    @EJB
    private ChatRoomsFacadeLocal chatRoomsFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         
        // get attributes of title and username of patient
         String title = request.getParameter("title"); 
         String username_patient = request.getParameter("username");
         
         // TODO: find the id of the chatroom
         Long id = findChatRoom(title, username_patient);
         
         // TODO: use ID to change the status to replied
         ChatRooms chatRooms = chatRoomsFacade.findChatRoom(id);
         
         chatRooms.setStatus("Answered");
         chatRoomsFacade.editChatRoom(chatRooms);
         
        // TODO: We can set up other attributes that we'll use in the future
        session.setAttribute("title", title);
        session.setAttribute("location", "doc");
        
        response.sendRedirect("GetAllMessagesServlet.do");
    }

    private Long findChatRoom(String title, String username_patient) {
        Long num = -1L;
        
        for (ChatRooms c :chatRoomsFacade.findAllChatRoom()) {
            // TODO: use username and title to find the message
            if ((c.getUsername().equalsIgnoreCase(username_patient)) && (c.getTitle().equalsIgnoreCase(title))) {
                num = c.getId();
            } 
        } 
        return num;
    }

}
