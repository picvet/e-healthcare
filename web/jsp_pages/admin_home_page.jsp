<%-- 
    Document   : admin_home_page
    Created on : May 26, 2022, 6:20:17 PM
    Author     : Percival
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN HOME PAGE</title>
        
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
        
        label {
            text-transform: uppercase;
        }
        
        input[type=text],
        input[type=password],
        select {
            width: 100%;
            padding: 16px 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        } 
        
        .submit-btn { 
            border: 2px solid #0099cc;
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
        
        .submit-btn:hover {
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
        
        h1 {
            text-align: center;
            font-size: 18;
        }
        
         
        .formcontainer {
            text-align: center;
            margin: 24px 50px 12px;
        }
        
        .container {
            padding: 16px 0;
            text-align: left;
        }
        
        span.psw {
            float: right;
            padding-top: 0;
            padding-right: 15px;
        }
    </style>
    
    </head>
    <body>
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
        
        <form action="AddLicenseNumber.do" method="POST">
         
        <div class="formcontainer">
            <h1>ADD LICENSE NUMBER</h1>
            <div class="container">

                <label for="licNum"><strong>NEW LICENSE NUMBER</strong></label>
                <input type="text" placeholder="Enter License Number" name="licNum" required> 

            </div>
            <button class="submit-btn" type="submit"><strong>ADD LICENSE NUMBER</strong></button>
    </form>
    </body>
</html>
