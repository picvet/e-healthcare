/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.PatientFacadeLocal;
import com.ehealthcare.entities.Address;
import com.ehealthcare.entities.Contact;
import com.ehealthcare.entities.Patient;
import java.io.IOException; 
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Percival
 */
public class PatientCreate extends HttpServlet {

    @EJB
    private PatientFacadeLocal patientFacade;

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String id = request.getParameter("id");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String street = request.getParameter("street");
        String town = request.getParameter("town");
        String province = request.getParameter("province");
        String zip = request.getParameter("zip");
        
        boolean found = checkUsername(username);
        
        if (found == true) {
            RequestDispatcher dis = request.getRequestDispatcher("username_invalid.html");
            dis.forward(request, response);
        } else {
            Address address = createAddress(street, town, province, zip);
            Contact contact = createContact(phone, email);
            // create a patient
                Patient patient = createPatient(name, surname, username, password,
                        id, dob, gender, address, contact);

                // persist to database
                patientFacade.createPatient(patient);


            RequestDispatcher dis = request.getRequestDispatcher("register_outcome.html");
            dis.forward(request, response);

        }
    }
    
    private boolean checkUsername(String username) {
        boolean found = false;
        for (Patient d : patientFacade.findAllPatient()) {
            if (d.getUsername().equalsIgnoreCase(username)) {
                found = true;
            } 
        }
        return found;
    }
    
    
    private Address createAddress(String street, 
            String town, String province, String zip) {
        Address address = new Address();
        
        address.setProvince(province);
        address.setStreet(street);
        address.setTown(town);
        address.setZip(zip);
        
        return address;
    }
    
    private Contact createContact(String phone, String email) {
        Contact contact = new Contact();
        
        contact.setEmail(email);
        contact.setPhone(Long.parseLong(phone));
        
        return contact;
    }
    
    private Patient createPatient(String name, String surname,
            String username, String password, String id,
            String dob, String gender, Address address, Contact contact) {
        Patient patient = new Patient();
        
        patient.setId_number(id);
        patient.setAddress(address);
        patient.setContact(contact);
        patient.setDob(dob);
        patient.setGender(gender);
        patient.setId_number(gender);
        patient.setName(name);
        patient.setPassword(password);
        patient.setSurname(surname);
        patient.setUsername(username);
        
        return patient;
    }

    
}
