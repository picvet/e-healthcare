/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.external;

import com.ehealthcare.business.MessagesFacadeLocal;
import com.ehealthcare.entities.Messages;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Percival
 */
public class GettingUsers extends HttpServlet{

    @EJB
    private MessagesFacadeLocal messagesFacade;

    
    public ArrayList<Messages> getMessages(String title) {
        ArrayList<Messages> want = new ArrayList<>();
        List<Messages> temp = messagesFacade.findAllMessages();
        
        for ( Messages m : temp ) {
            if ( m.getTitle().equalsIgnoreCase(title) ) {
                want.add(m);
            } 
        }
        return want;
    }
    
}
