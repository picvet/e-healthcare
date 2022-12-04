/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.business;

import com.ehealthcare.entities.Messages;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Percival
 */
@Stateless
public class MessagesFacade extends AbstractFacade<Messages> implements MessagesFacadeLocal {

    @PersistenceContext(unitName = "healthcarePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessagesFacade() {
        super(Messages.class);
    }

    @Override
    public void createMessages(Messages messages) {
        create(messages);
    }

    @Override
    public void editMessages(Messages messages) {
        edit(messages);
    }

    @Override
    public void removeMessages(Messages messages) {
        remove(messages);
    }

    @Override
    public Messages findMessages(Long id) {
        return find(id);
    }

    @Override
    public List<Messages> findAllMessages() {
        return findAll();
    }
    
}
