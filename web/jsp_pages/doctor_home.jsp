<%@page import="com.ehealthcare.entities.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>

<head>
    <title>Doctor Home Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        * {
            box-sizing: 0;
            margin: 0;
            padding: 0; 
            background-color: #323232;
            color: white; 
        }
        
        li,
        a {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
            font-weight: 500;
            font-size: 16px; 
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
            color: grey;
            text-decoration: underline;
        }
        
        .button { 
            border: 2px solid #0099cc;
            border-radius: 70px;
            text-decoration: blink;
            text-transform: uppercase;
            border: solid;
            border-color: silver;
            color: white;
            padding: 10px 10px;
            text-decoration: none;
            display: inline;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }
        
        .button:hover {
            background: transparent;
            border: 2px solid white;
            border-radius: 70px;
            text-decoration: none;
            text-transform: uppercase;
            border: solid;
            border-color: white;
            color: white;
            padding: 11px 11px;
            text-decoration: none;
            display: inline;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }
        
        .inside {
            text-align: center;
        }
    </style>
</head>

<body>

    <%
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        String username = doctor.getUsername();
    %>

    <header>
        <p class="logo"><%=username%></p>
        <nav>
            <ul class="nav_links">
                <li>
                    <a href="ServletLogin.do">Home</a>
                </li>
                <li>
                    <a href="jsp_pages/doctor_profile.jsp">Profile</a>
                </li>
                <li>
                    <a href="ServletLogout.do">Logout</a>
                </li>
            </ul>
        </nav>
    </header>
        
        <section class="inside">
            <form method="GET" action="FindPatientsServlet.do">
                <input class="button" type="submit" value="See available people" />
            </form>
        </section> 

</body>

</html>