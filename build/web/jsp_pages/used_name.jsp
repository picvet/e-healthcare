<%-- 
    Document   : used_name
    Created on : May 25, 2022, 5:06:48 PM
    Author     : Percival
--%>

<%@page import="com.ehealthcare.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Title Error Page</title>
        <script type="text/javascript" src="javascript/script.js"></script>

        
        <style>
            * {
            box-sizing: 0;
            margin: 0;
            padding: 0;
            background-color: #0088a9;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
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
        /* end of header tags */
        </style>
    </head>
    <body>
        
         <%
            Patient patient = (Patient) session.getAttribute("patient");
            String username = patient.getUsername(); 
        %>
        <header>
        <p class="logo">
            <%=username%>
        </p>
        <nav>
            <ul class="nav_links">
                <li>
                    <a href="ServletLogin.do">Home</a>
                </li>
                <li>
                    <a href="#">Profile</a>
                </li>
                <li>
                    <a href="ServletLogout.do">Logout</a>
                </li>
            </ul>
        </nav>
    </header>
        
        <div class="back">
        <div class="content">
            <h5>TITLE ALREADY USED</h5>
            <p>
                The description already exist please refer to your past chats to see more details.
            </p> 
            <button class="button" onclick="goToPatientHomePage()"><%=username%> HOME PAGE</button>
        </div>
    </div>
    </body>
</html>
