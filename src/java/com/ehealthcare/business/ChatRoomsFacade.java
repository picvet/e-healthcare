/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.business;

import com.ehealthcare.entities.ChatRooms;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Percival
 */
@Stateless
public class ChatRoomsFacade extends AbstractFacade<ChatRooms> implements ChatRoomsFacadeLocal {

    @PersistenceContext(unitName = "healthcarePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChatRoomsFacade() {
        super(ChatRooms.class);
    }

    @Override
    public void createChatRoom(ChatRooms chatRooms) {
        create(chatRooms);
    }

    @Override
    public void editChatRoom(ChatRooms chatRooms) {
        edit(chatRooms);
    }

    @Override
    public void removeChatRoom(ChatRooms chatRooms) {
        remove(chatRooms);
    }

    @Override
    public ChatRooms findChatRoom(Long id) {
        return find(id);
    }

    @Override
    public List<ChatRooms> findAllChatRoom() {
        return findAll();
    }
    
}
