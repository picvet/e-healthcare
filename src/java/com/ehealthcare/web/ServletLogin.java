/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.web;

import com.ehealthcare.business.DoctorFacadeLocal;
import com.ehealthcare.business.PatientFacadeLocal;
import com.ehealthcare.entities.Doctor;
import com.ehealthcare.entities.Patient;
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
public class ServletLogin extends HttpServlet {

    @EJB
    private PatientFacadeLocal patientFacade;

    @EJB
    private DoctorFacadeLocal doctorFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        
        session.setAttribute("typeOfPerson", type);
        
        if (type.equalsIgnoreCase("doctor")) {
            Doctor doctor = checkDoctor(username);
            
            if (doctor != null) {
                // setting to session 
                session.setAttribute("doctor", doctor);
                RequestDispatcher dis = request.getRequestDispatcher("jsp_pages/doctor_home.jsp");
                dis.forward(request, response);
            } else {
                RequestDispatcher dis = request.getRequestDispatcher("user_not_found.html");
                dis.forward(request, response);
            }
        } else {
            Patient patient = checkPatient(username);
            
            if (patient != null) {
                // setting to session 
                session.setAttribute("patient", patient);
                RequestDispatcher dis = request.getRequestDispatcher("jsp_pages/patient_home.jsp");
                dis.forward(request, response);
            } else {
                RequestDispatcher dis = request.getRequestDispatcher("user_not_found.html");
                dis.forward(request, response);
            }
        }
    }
    
    private Doctor checkDoctor(String username) {
        return doctorFacade.findDoctor(username.trim());
    }

    private Patient checkPatient(String username) {
        return patientFacade.findPatient(username.trim());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String typo = (String) session.getAttribute("typeOfPerson");
        
        if (typo.equalsIgnoreCase("doctor")) {
            RequestDispatcher dis = req.getRequestDispatcher("jsp_pages/doctor_home.jsp");
            dis.forward(req, resp);
        } else {
            RequestDispatcher dis = req.getRequestDispatcher("jsp_pages/patient_home.jsp");
            dis.forward(req, resp);
        }
        
    } 

}
