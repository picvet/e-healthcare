/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.business;

import com.ehealthcare.entities.LicenseNumbers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Percival
 */
@Stateless
public class LicenseNumbersFacade extends AbstractFacade<LicenseNumbers> implements LicenseNumbersFacadeLocal {

    @PersistenceContext(unitName = "healthcarePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LicenseNumbersFacade() {
        super(LicenseNumbers.class);
    }

    @Override
    public void createLicenseNumber(LicenseNumbers licenseNumbers) {
        create(licenseNumbers);
    }

    @Override
    public void editLicenseNumber(LicenseNumbers licenseNumbers) {
        edit(licenseNumbers);
    }

    @Override
    public void removeLicenseNumber(LicenseNumbers licenseNumbers) {
        remove(licenseNumbers);
    }

    @Override
    public LicenseNumbers findLicenseNumber(String id) {
        return find(id);
    }

    @Override
    public List<LicenseNumbers> findAllLicenseNumber() {
        return findAll();
    }
    
}
