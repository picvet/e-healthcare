/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.business;

import com.ehealthcare.entities.LicenseNumbers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Percival
 */
@Local
public interface LicenseNumbersFacadeLocal {

    void createLicenseNumber(LicenseNumbers licenseNumbers);

    void editLicenseNumber(LicenseNumbers licenseNumbers);

    void removeLicenseNumber(LicenseNumbers licenseNumbers);

    LicenseNumbers findLicenseNumber(String id);

    List<LicenseNumbers> findAllLicenseNumber();
 
    
}
