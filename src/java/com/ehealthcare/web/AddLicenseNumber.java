/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.LicenseNumbersFacadeLocal;
import com.ehealthcare.entities.LicenseNumbers;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Percival
 */
public class AddLicenseNumber extends HttpServlet {

    @EJB
    private LicenseNumbersFacadeLocal licenseNumbersFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String licNum = request.getParameter("licNum");
        
        // TODO: Check if taken or not
        LicenseNumbers licenseNumbers = licenseNumbersFacade.findLicenseNumber(licNum);
        
        String nextPage = "id_taken.html";
        
        // TODO: Check if licNum has been taken or not
        if (licenseNumbers == null) {
            // TODO: Create and persist to database
            licenseNumbers = createLicenseNumber(licNum);
            
            licenseNumbersFacade.createLicenseNumber(licenseNumbers);
            
            // TODO: Take to sucessfully created license number
            nextPage = "id_added.html";
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(nextPage);
        dis.forward(request, response);
    }

    private LicenseNumbers createLicenseNumber(String licNum) {
        LicenseNumbers licenseNumbers = new LicenseNumbers();
        
        licenseNumbers.setLicNum(licNum);
        licenseNumbers.setTaken(Boolean.FALSE);
        
        return licenseNumbers;
    }
 

}
