/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.ChatRoomsFacadeLocal;
import com.ehealthcare.entities.ChatRooms;
import java.io.IOException; 
import java.util.ArrayList;
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
public class FindPatientsServlet extends HttpServlet {

    @EJB
    private ChatRoomsFacadeLocal chatRoomsFacade;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        ArrayList<ChatRooms> chats = new ArrayList<>();
        int count = 0;
        if ( !chatRoomsFacade.findAllChatRoom().isEmpty() ) {
            // TODO: find all the chatrooms open then display in the next page
            for (ChatRooms c : chatRoomsFacade.findAllChatRoom()) {
                
                if (c.getStatus().equalsIgnoreCase("Not Answered")) {
                    count++;
                    chats.add(c);
                }
            }
            
            
            if (count == 0) {
                // TODO: take you to a page that tells you to come and check back later
                RequestDispatcher dis = request.getRequestDispatcher("jsp_pages/no_patients.jsp");
                dis.forward(request, response);
            } else{
                // done iterating and adding to the arraylist
                // store to the session
                session.setAttribute("chats", chats);

                // dispatch to where I'll display the available patients
                RequestDispatcher dis = request.getRequestDispatcher("jsp_pages/available_patients.jsp");
                dis.forward(request, response);
            }
            
            
            
        } else {
            // TODO: take you to a page that tells you to come and check back later
            RequestDispatcher dis = request.getRequestDispatcher("jsp_pages/no_patients.jsp");
            dis.forward(request, response);
        }
         
    }

}
