<%-- 
    Document   : available_patients
    Created on : May 25, 2022, 6:30:32 PM
    Author     : Percival
--%>

<%@page import="com.ehealthcare.entities.ChatRooms"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available clients Page</title>
        
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
        
        /*end of navbar*/
        
        form {
            border: 3px solid #555;
            margin: 0 10%; 
        }
         
        
        .sec {  
            margin-bottom: 20px;
        } 
        
        .sec-2 {  
            text-align: center;
            border: solid;
            padding-top: 10px;
            margin: 2% 2%;
        } 
        
        input[type="text"],
        input[type="submit"]{
            border: none;
            font-size: 16px; 
        }
        
        input[type="submit"] {
            border: 1px solid #0099cc;
            border-radius: 70px;
            text-decoration: blink;
            text-transform: uppercase;
            border: solid;
            border-color: silver;
            color: white;
            padding: 10px 30px;
            text-decoration: none;
            display: inline;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        } 
        
        input[type="submit"]:hover {
            background: transparent;
            border: 2px solid white;
            border-radius: 70px;
            text-decoration: none;
            text-transform: uppercase;
            border: solid;
            border-color: white;
            color: white;
            padding: 11px 31px;
            text-decoration: none;
            display: inline;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }
         
        .middle {
            text-align: center;
        }
        
        .sec-2 h1 {
            font-size: 20px;
        }
         
    </style>
    
    
    </head>
    <body>
        <%
            // getting the list of available clients
            ArrayList<ChatRooms> chats = (ArrayList<ChatRooms>)session.getAttribute("chats");
        %>
        
        <header>
        <p class="logo">E-HEALTHCARE</p>
        <nav>
            <ul class="nav_links">
                <li>
                    <a href="AdminCheck.do">Home</a>
                </li>
                <li>
                    <a href="ServletLogout.do">LOGOUT</a>
                </li> 
            </ul>
        </nav>
    </header>
        
        
        <section class="middle">
        
        <section class="sec-2">
            <h1>THERE IS/ARE <%=chats.size()%> PATIENTS WHO NEED HELP</h1>
            <br> <br>
        <% 
            for (ChatRooms c : chats) {
                String title = c.getTitle();
                String un = c.getUsername();
                
                %>
                <section class="sec">
                <form method="POST" action="ChatToClientServlet.do">
                    <input readonly type="text" size="50" name="username" value="<%=un%>"> <br>
                    <input readonly type="text"  name="title"  value="<%=title%>" > <br>
                    <input type="submit" value="CHAT">
                </form>
                </section>
                <%
            }

        %>
        </section>
        </section>
    </body>
</html>
