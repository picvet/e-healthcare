/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.business;

import com.ehealthcare.entities.Doctor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Percival
 */
@Local
public interface DoctorFacadeLocal {

    void createDoctor(Doctor doctor);

    void editDoctor(Doctor doctor);

    void removeDoctor(Doctor doctor);

    Doctor findDoctor(String id);

    List<Doctor> findAllDoctor();

    
}
