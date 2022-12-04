<%-- 
    Document   : patient_profile
    Created on : May 27, 2022, 1:07:51 AM
    Author     : Percival
--%>

<%@page import="com.ehealthcare.entities.Doctor"%>
<%@page import="com.ehealthcare.entities.Contact"%>
<%@page import="com.ehealthcare.entities.Address"%>
<%@page import="com.ehealthcare.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Profile View</title>
        
            <style>
            
            * {
                background-color: black;
                color: white;
            }
            li,
        a {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
            font-weight: 500;
            font-size: 16px;
            color: #edf0f1;
            text-decoration: none;
        }
        
        header {
            display: flex;
            justify-content: flex-end;
            align-items: center;
            padding: 30px 30px;
            height: 30px;
        }
        
        .logo {
            cursor: pointer;
            margin-right: auto;
            font-size: 40px;
            color: #edf0f1;
        }
        
        .nav_links {
            list-style: none;
        }
        
        .nav_links li {
            display: inline-block;
            padding: 0px 20px;
        }
        
        .nav_links li a {
            transition: all 0.3s ease 0s;
        }
        
        .nav_links li a:hover {
            color: #0088a9
        }
        </style>
    </head>
    <body>
        <%
            Doctor doctor = (Doctor) session.getAttribute("doctor");
            String username = doctor.getUsername();  
            String password = doctor.getPassword();
            String name = doctor.getName();
            String surname = doctor.getSurname();
            String id_number = doctor.getId_number();
            String gender = doctor.getGender();
            String dob = doctor.getDob(); 
            String licNum = doctor.getLicense_number();
            String spec = doctor.getSpecialization();
            
            // address
            Address address = doctor.getAddress();
            String streetNum = address.getStreet();
            String town = address.getTown();
            String province = address.getProvince();
            String zip = address.getZip();
            
            // contact
            Contact contact = doctor.getContact();
            String email = contact.getEmail();
            Long phone = contact.getPhone();
        %>
        
        <header>
        <p class="logo"><%=username%></p>
        <nav>
            <ul class="nav_links">
                <li>
                    <a href="ServletLogin.do">Home</a>
                </li> 
                <li>
                    <a href="ServletLogout.do">Logout</a>
                </li>
            </ul>
        </nav>
    </header>
        
        <section>
            <div class="details">
                <h2>Personal Details</h2>
                
                <div>
                    <table>
                        <tr>
                            <td><strong>Name</strong> </td>
                            <td>
                                <%=name%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Surname</strong> </td>
                            <td>
                                <%=surname%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Username</strong> </td>
                            <td>
                                <%=username%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Password</strong> </td>
                            <td>
                                <%=password%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Identity number</strong> </td>
                            <td>
                                <%=id_number%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Gender</strong> </td>
                            <td>
                                <%=gender%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Birth Date</strong> </td>
                            <td>
                                <%=dob%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>License number</strong> </td>
                            <td>
                                <%=licNum%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Specialization</strong> </td>
                            <td>
                                <%=spec%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Street</strong> </td>
                            <td>
                                <%=streetNum%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Town</strong> </td>
                            <td>
                                <%=town%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Province</strong> </td>
                            <td>
                                <%=province%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Zip</strong> </td>
                            <td>
                                <%=zip%>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Email</strong> </td>
                            <td>
                                <%=email%>
                            </td>
                        </tr>
                         <tr>
                            <td><strong>Phone</strong> </td>
                            <td>
                                <%=phone%>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </section>
    </body>
</html>
