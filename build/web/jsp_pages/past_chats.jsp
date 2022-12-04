<%-- 
    Document   : past_chats
    Created on : May 27, 2022, 12:38:34 AM
    Author     : Percival
--%>

<%@page import="com.ehealthcare.entities.Patient"%>
<%@page import="com.ehealthcare.entities.ChatRooms"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Past Conversations Page</title>
        
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
            List<ChatRooms> rooms = (List<ChatRooms>) session.getAttribute("rooms");
            Patient patient = (Patient) session.getAttribute("patient");
            String username = patient.getUsername();
        %>
        
        <header>
        <p class="logo"><%=username%></p>
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
            <% 
            for (ChatRooms c : rooms) {
                String title = c.getTitle(); 
                
                %>
                <form method="POST" action="ReadConversation.do"> 
                    <input readonly type="text" name="title"  value="<%=title%>" >
                    <input type="submit" value="READ CONVERSATION">
                </form>
                
                <%
            }

        %>
        </section>
        
    </body>
</html>
