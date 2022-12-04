/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.ChatRoomsFacadeLocal;
import com.ehealthcare.entities.ChatRooms;
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
public class FindPreviousConversations extends HttpServlet {

    @EJB
    private ChatRoomsFacadeLocal chatRoomsFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Patient patient = (Patient) session.getAttribute("patient");
        String username = patient.getUsername();
        
        // TODO: Create list to store conversations of the user
        List<ChatRooms> room = new ArrayList<>();
        // TODO: find all titles that contain this username in chatrooms and closed
        for(ChatRooms c : chatRoomsFacade.findAllChatRoom()) {
            if (c.getUsername().equalsIgnoreCase(username) && c.getStatus().equalsIgnoreCase("Answered")) {
                room.add(c);
            }
        }
        
        // TODO: Store to session then send to page where we'll display previous chats
        session.setAttribute("rooms", room);
        
        RequestDispatcher dis = request.getRequestDispatcher("jsp_pages/past_chats.jsp");
        dis.forward(request, response); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Patient patient = (Patient) session.getAttribute("patient");
        String username = patient.getUsername();
        
        // TODO: Create list to store conversations of the user
        List<ChatRooms> room = new ArrayList<>();
        // TODO: find all titles that contain this username in chatrooms and closed
        for(ChatRooms c : chatRoomsFacade.findAllChatRoom()) {
            if (c.getUsername().equalsIgnoreCase(username) && c.getStatus().equalsIgnoreCase("Answered")) {
                room.add(c);
            }
        }
        
        // TODO: Store to session then send to page where we'll display previous chats
        session.setAttribute("rooms", room);
        
        RequestDispatcher dis = request.getRequestDispatcher("jsp_pages/past_chats.jsp");
        dis.forward(request, response);
    }
    
    
}
