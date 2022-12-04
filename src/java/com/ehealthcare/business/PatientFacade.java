/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.business;

import com.ehealthcare.entities.Patient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Percival
 */
@Stateless
public class PatientFacade extends AbstractFacade<Patient> implements PatientFacadeLocal {

    @PersistenceContext(unitName = "healthcarePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PatientFacade() {
        super(Patient.class);
    }

    @Override
    public void createPatient(Patient patient) {
        create(patient);
    }

    @Override
    public void editPatient(Patient patient) {
        edit(patient);
    }

    @Override
    public void removePatient(Patient patient) {
        remove(patient);
    }

    @Override
    public Patient findPatient(String id) {
        return find(id);
    }

    @Override
    public List<Patient> findAllPatient() {
        return findAll();
    }
    
}
