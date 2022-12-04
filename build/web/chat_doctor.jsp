<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ehealthcare.entities.Messages"%>
<%@page import="com.ehealthcare.entities.Doctor"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>

<head>
    <title>Chat To Patient</title>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="20">
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
        /* end of header tags */
        
        .container-div { 
            margin: 0% 20%;
            height: 80vh;
            display: flex;
            flex-direction: column;
            box-shadow: 2px 2px 20px silver; 
        }
        
        .header {
            color: white;
            background-color: #555;
            padding: 15px;
        } 
        .message {
            background-color: rgb(255, 167, 4);
            padding: 10px;
            color: rgb(255, 251, 251);
            width: fit-content;
            border-radius: 10px;
            margin-bottom: 15px;
        }
        
        .user-message {
            margin-left: auto;
            background-color: #555;  
        }
        
        .footer form {
            clear: both;
        }
        
        form input {
            flex: 1;
            height: 40px;
            border: none;
            outline: none;
            padding-left: 5px;
            font-size: 16px;
            
        }
        
        form .button {   
            width: 100px;
            font-size: 18px;
            border: none;
            outline: none;
            background-color: #555;
            color: rgb(239, 240, 239);
            cursor: pointer; 
            float:right; 
            display: table;
            margin-right:0px; 
        }
        
        form .button:hover {
            opacity: 0.7;
            transition: 0.2s ease;
        }
        
        .message-div {
            width:100px;
            min-height:100px;
            float:left; 
        }
        
        .wrapper-div { 
            overflow-y: scroll; 
            height: 70vh;
        }
        
        input[type="text"] {
            background-color: #555;
        }
    </style>
</head>

<body>
<%
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        String username = doctor.getUsername(); 
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
                    <a href="#">Profile</a>
                </li>
                <li>
                    <a href="ServletLogout.do">Logout</a>
                </li>
            </ul>
        </nav>
    </header>

    <br>
    <form method="POST" action="MessageSendServlet.do">
        <div class="container-div">
            <div class="header">
                <h1 style="background-color: #555">Online</h1>
            </div>
            <div class="wrapper-div">
            <%  
                if(messages.isEmpty()) {
                    %>
                    <p>No new messages yet!</p>
                    <%
                }
                else {
                    for ( Messages m : messages ) {
                        String me = m.getMessage();
                        String name = m.getSender().toUpperCase();
                        %>
                        <div class="body">
                            <p><strong><%=name%></strong>: <%=me%></p> 
                        </div>
                        <br> <br>
                        <%
                    }
                } 
            %>
            </div>
                                
                 
            <div class="footer">
                <form>
                    <input type="text" name="message" id="user-message" placeholder="Enter your message"/>
                    <input id="send" class="button" type="submit" value="send">
                </form>
            </div>
        </div>
    </form>

</body>

</html>