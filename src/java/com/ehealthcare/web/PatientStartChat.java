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
public class PatientStartChat extends HttpServlet {
 
    @EJB
    private ChatRoomsFacadeLocal chatRoomsFacade;
 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Patient patient = (Patient)session.getAttribute("patient");
        
        String username = patient.getUsername();
        
        String title = request.getParameter("title");
        
        
        //check if the chatroom already exists
        boolean found = checkChatRoomExists(title, username);
        
        if ( found == Boolean.TRUE ) {  
            // TODO: check if it is closed 
            boolean closed = isClosed(title, username);
            
            if( closed != true ) {
                // delete what's already in the database then create it again
                findAndDeleteChatRoom(title, username);
                session.setAttribute("location", "chat_patient.jsp");
                session.setAttribute("title", title);
                //TODO: go to message servlet
                response.sendRedirect("GetAllMessagesServlet.do");
//                RequestDispatcher dis = request.getRequestDispatcher("chat_patient.jsp");
//                dis.forward(request, response);
            } else {
                RequestDispatcher dis = request.getRequestDispatcher("jsp_pages/used_name.jsp");
                dis.forward(request, response);
            }
            
            
        } else {
            session.setAttribute("location", "chat_patient.jsp");
            session.setAttribute("title", title);
            // create a chatroom
            ChatRooms chatRooms = createChatRoom(title, username);
            
            // persist to chatroom 
            chatRoomsFacade.createChatRoom(chatRooms);
            
            // go to message servlet
            response.sendRedirect("GetAllMessagesServlet.do");
//               RequestDispatcher dis = request.getRequestDispatcher("chat_patient.jsp");
//                dis.forward(request, response);
        }
         
    }

    private boolean checkChatRoomExists(String title, String username) {
        boolean found =  false;
          
            if ( !chatRoomsFacade.findAllChatRoom().isEmpty() ) {
                for (ChatRooms c : chatRoomsFacade.findAllChatRoom()) {
                    if ( (c.getTitle().equalsIgnoreCase(title))
                            && (c.getUsername().equalsIgnoreCase(username))) { 
                                found = true;  
                        }
                    }
            }
        
        return found;
    }

    private ChatRooms createChatRoom(String title, String username) {
        ChatRooms chatRooms = new ChatRooms();
        chatRooms.setStatus("Not Answered");
        chatRooms.setTitle(title);
        chatRooms.setUsername(username);
        return chatRooms;
    }

    private boolean isClosed(String title, String username) {
        boolean closed =  false;
        
        for (ChatRooms c : chatRoomsFacade.findAllChatRoom()) {
            if ( (c.getTitle().equalsIgnoreCase(title))
                    && (c.getUsername().equalsIgnoreCase(username))) {
                    if ( c.getStatus().equals(Boolean.TRUE)) {
                        closed = true; 
                }
            }
            }
        return closed;
    }

    private void findAndDeleteChatRoom(String title, String username) {
        for (ChatRooms c : chatRoomsFacade.findAllChatRoom()) {
            if ( (c.getTitle().equalsIgnoreCase(title))
                    && (c.getUsername().equalsIgnoreCase(username))) {
                    if ( c.getStatus().equals(Boolean.TRUE)) {
                        chatRoomsFacade.removeChatRoom(c);
                        chatRoomsFacade.createChatRoom(c);
                }
            }
            }
    }
}
