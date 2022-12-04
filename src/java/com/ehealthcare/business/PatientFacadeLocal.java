/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.business;

import com.ehealthcare.entities.Patient;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Percival
 */
@Local
public interface PatientFacadeLocal {

    void createPatient(Patient patient);

    void editPatient(Patient patient);

    void removePatient(Patient patient);

    Patient findPatient(String id);

    List<Patient> findAllPatient();
    
}
