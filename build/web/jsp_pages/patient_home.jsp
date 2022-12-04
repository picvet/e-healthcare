<%@page import="com.ehealthcare.entities.Patient"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>

<head>
    <title>Patient Home Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="javascript/script.js"></script>

    <style>
        * {
            box-sizing: 0;
            margin: 0;
            padding: 0;
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

        /* end of the header css */

        /* start of the body or navigations for patient */

        .content-nav {
            height: 80vh;
            margin: 0% 20%;
        }
        
        .button {
            background: transparent;
            border: 2px solid #0099cc;
            border-radius: 70px;
            text-decoration: none;
            text-transform: uppercase;
            border: solid;
            border-color: blue;
            color: white;
            padding: 16px 32px;
            text-decoration: none;
            display: inline;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }
        
        .button:hover {
            color: orange;
            opacity: 0.8;
        }
        
        #formcontainer {
            text-align: center;
            margin: 24px 50px 12px;
        }
        
        input[type=text]
        {
            width: 100%;
            padding: 16px 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        
        form label {
            size: 50px;
        }
        
        .container-2 {
            padding: 16px 0;
            text-align: left;
        }
        
    </style>
</head>

<body>
    
    <%
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
                    <a href="FindPreviousConversations.do">Previous conversations</a>
                </li>
                <li>
                    <a href="ServletLogout.do">Logout</a>
                </li>
            </ul>
        </nav>
    </header>
        
        
        <form action="PatientStartChat.do" method="POST">
            <div class="context-nav" id="formcontainer">
                <div class="container-2">
                    
                    <label class="titleofchat" for="title">Describe your sickness</label>
                    <input required="" type="text" name="title">
                    <input class="button" type="submit" value="CHAT TO DOCTOR">
                
                </div>
            </div>
        </form>
        
        
        

</body>

</html>