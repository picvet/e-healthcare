<%-- 
    Document   : read_past_chat
    Created on : May 27, 2022, 12:56:28 AM
    Author     : Percival
--%>

<%@page import="java.util.List"%>
<%@page import="com.ehealthcare.entities.Messages"%>
<%@page import="com.ehealthcare.entities.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Past Conversation Read Page</title>
        
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
            Patient patient = (Patient) session.getAttribute("patient");
            String username = patient.getUsername(); 
            List<Messages> messages = (List<Messages>)session.getAttribute("messages");
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
                    <a href="jsp_pages/patient_profile.jsp">Profile</a>
                </li>
                <li>
                    <a href="ServletLogout.do">Logout</a>
                </li>
            </ul>
        </nav>
    </header>
        
        <section>
            <div class="wrapper-div">
                <%  
                    if(messages.isEmpty()) {
                        %>
                        <p>No Message was sent on this chat!</p>
                        <%
                    }
                    else {
                        for ( Messages m : messages ) {
                            String me = m.getMessage();
                            String name = m.getSender().toUpperCase();
                            %>
                            <div class="body">
                                <p><strong><%=name%></strong>:   <%=me%></p> 
                            </div>
                            <%
                        }
                    } 
                %>
                </div>
        </section>
    </body>
</html>
