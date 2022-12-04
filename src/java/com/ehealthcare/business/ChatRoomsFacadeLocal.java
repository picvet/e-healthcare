/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.business;

import com.ehealthcare.entities.ChatRooms;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Percival
 */
@Local
public interface ChatRoomsFacadeLocal {

    void createChatRoom(ChatRooms chatRooms);

    void editChatRoom(ChatRooms chatRooms);

    void removeChatRoom(ChatRooms chatRooms);

    ChatRooms findChatRoom(Long id);

    List<ChatRooms> findAllChatRoom();

    
}
