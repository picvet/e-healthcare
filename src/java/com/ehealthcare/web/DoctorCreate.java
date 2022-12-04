/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.DoctorFacadeLocal;
import com.ehealthcare.business.LicenseNumbersFacadeLocal;
import com.ehealthcare.entities.Address;
import com.ehealthcare.entities.Contact;
import com.ehealthcare.entities.Doctor;
import com.ehealthcare.entities.LicenseNumbers;
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
public class DoctorCreate extends HttpServlet {

    @EJB
    private LicenseNumbersFacadeLocal licenseNumbersFacade;

    @EJB
    private DoctorFacadeLocal doctorFacade;

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
        
        if ( found == true ) {
            RequestDispatcher dis = request.getRequestDispatcher("username_invalid.html");
            dis.forward(request, response);
        } else {
            // TODO: Check license number if it's already taken or not
            String licNum = request.getParameter("licNum").trim();
            
            
            LicenseNumbers licenseNumbers = licenseNumbersFacade.findLicenseNumber(licNum);
            
            String nextPage = "invalid_id.html";
            
            // TODO: if found in database continue with the creation
            
            if (licenseNumbers != null) {
                
                // TODO: check if it's taken or not
                if (licenseNumbers.getTaken().equals(Boolean.TRUE)) {
                    nextPage = "id_used.html";
                } else {
                    nextPage = "register_outcome.html";
                    String spec = request.getParameter("spec");

                    Address address = createAddress(street, town, province, zip);
                    Contact contact = createContact(phone, email);

                        // create a doctor 
                        Doctor doctor = createDoctor(name, surname, username, password, id,
                                dob, gender, licNum, spec, address, contact);

                        // persist to database
                        doctorFacade.createDoctor(doctor);
                        
                        // TODO: change status for the license number
                        licenseNumbers.setTaken(Boolean.TRUE);
                        licenseNumbersFacade.editLicenseNumber(licenseNumbers); 
                }
            }  
            RequestDispatcher dis = request.getRequestDispatcher(nextPage);
            dis.forward(request, response);
        }
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
    
    private Doctor createDoctor(String name, String surname, 
            String username, String password, String id,
            String dob, String gender, String licNum, 
            String spec, Address address, Contact contact) {
        Doctor doctor = new Doctor();
        
        doctor.setAddress(address);
        doctor.setContact(contact);
        doctor.setDob(dob);
        doctor.setGender(gender);
        doctor.setId_number(gender);
        doctor.setName(name);
        doctor.setPassword(password);
        doctor.setSurname(surname);
        doctor.setUsername(username);
        doctor.setId_number(id);
        doctor.setLicense_number(licNum);
        doctor.setSpecialization(spec);
        
        return doctor;
    }
    
    private boolean checkUsername(String username) {
        boolean found = false;
        for (Doctor d : doctorFacade.findAllDoctor()) {
            if (d.getUsername().equalsIgnoreCase(username)) {
                found = true;
            } 
        }
        return found;
    }

}
