/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.business;

import com.ehealthcare.entities.Messages;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Percival
 */
@Local
public interface MessagesFacadeLocal {

    void createMessages(Messages messages);

    void editMessages(Messages messages);

    void removeMessages(Messages messages);

    Messages findMessages(Long id);

    List<Messages> findAllMessages();

    
}
