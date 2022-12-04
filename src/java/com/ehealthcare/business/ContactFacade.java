/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.business;

import com.ehealthcare.entities.Contact;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Percival
 */
@Stateless
public class ContactFacade extends AbstractFacade<Contact> implements ContactFacadeLocal {

    @PersistenceContext(unitName = "healthcarePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactFacade() {
        super(Contact.class);
    }

    @Override
    public void createContact(Contact contact) {
        create(contact);
    }

    @Override
    public void editContact(Contact contact) {
        edit(contact);
    }

    @Override
    public void removeContact(Contact contact) {
        remove(contact);
    }

    @Override
    public Contact findContact(Long id) {
        return find(id);
    }

    @Override
    public List<Contact> findAllContact() {
        return findAll();
    }
    
}
