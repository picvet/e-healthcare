package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.rmi.PortableRemoteObject;
import javax.naming.InitialContext;
import java.util.List;
import java.util.ArrayList;
import com.ehealthcare.entities.Messages;
import javax.ejb.EJB;
import com.ehealthcare.entities.Patient;
import com.ehealthcare.business.MessagesFacadeLocal;

public final class chat_005fpatient_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title>Chat To Doctor</title>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"refresh\" content=\"20\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        * {\n");
      out.write("            box-sizing: 0;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0; \n");
      out.write("            background-color: #323232;\n");
      out.write("            color: white; \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        li,\n");
      out.write("        a {\n");
      out.write("            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;\n");
      out.write("            font-weight: 500;\n");
      out.write("            font-size: 16px; \n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        header {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: flex-end;\n");
      out.write("            align-items: center;\n");
      out.write("            padding: 30px 30px;\n");
      out.write("            height: 30px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .logo {\n");
      out.write("            cursor: pointer;\n");
      out.write("            margin-right: auto;\n");
      out.write("            font-size: 40px;\n");
      out.write("            color: #edf0f1;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .nav_links {\n");
      out.write("            list-style: none;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .nav_links li {\n");
      out.write("            display: inline-block;\n");
      out.write("            padding: 0px 20px; \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .nav_links li a {\n");
      out.write("            transition: all 0.3s ease 0s;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .nav_links li a:hover {\n");
      out.write("            color: grey;\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("        /* end of header tags */\n");
      out.write("        \n");
      out.write("        .container-div { \n");
      out.write("            margin: 0% 20%;\n");
      out.write("            height: 80vh;\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            box-shadow: 2px 2px 20px silver; \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .header {\n");
      out.write("            color: white;\n");
      out.write("            background-color: #555;\n");
      out.write("            padding: 15px;\n");
      out.write("        } \n");
      out.write("        .message {\n");
      out.write("            background-color: rgb(255, 167, 4);\n");
      out.write("            padding: 10px;\n");
      out.write("            color: rgb(255, 251, 251);\n");
      out.write("            width: fit-content;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .user-message {\n");
      out.write("            display: inline-block;\n");
      out.write("            margin-left: auto;\n");
      out.write("            background-color: #555;  \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .footer form {\n");
      out.write("            clear: both;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        form input {\n");
      out.write("            flex: 1;\n");
      out.write("            height: 40px;\n");
      out.write("            border: none;\n");
      out.write("            outline: none;\n");
      out.write("            padding-left: 5px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        form .button {   \n");
      out.write("            width: 100px;\n");
      out.write("            font-size: 18px;\n");
      out.write("            border: none;\n");
      out.write("            outline: none;\n");
      out.write("            background-color: #555;\n");
      out.write("            color: rgb(239, 240, 239);\n");
      out.write("            cursor: pointer; \n");
      out.write("            float:right; \n");
      out.write("            display: table;\n");
      out.write("            margin-right:0px; \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        form .button:hover {\n");
      out.write("            opacity: 0.7;\n");
      out.write("            transition: 0.2s ease;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .message-div {\n");
      out.write("            width:100px;\n");
      out.write("            min-height:100px;\n");
      out.write("            float:left; \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .wrapper-div { \n");
      out.write("            overflow-y: scroll; \n");
      out.write("            height: 70vh;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        input[type=\"text\"] {\n");
      out.write("            background-color: #555;\n");
      out.write("        } \n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    ");

        Patient patient = (Patient) session.getAttribute("patient");
        String username = patient.getUsername(); 
        List<Messages> messages = (List<Messages>)session.getAttribute("messages");
    
      out.write("\n");
      out.write("\n");
      out.write("    <header>\n");
      out.write("        <p class=\"logo\">\n");
      out.write("            ");
      out.print(username);
      out.write("\n");
      out.write("        </p>\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"nav_links\">\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"ServletLogin.do\">Home</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">Profile</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"ServletLogout.do\">Logout</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <br>\n");
      out.write("    <form method=\"POST\" action=\"MessageSendServlet.do\">\n");
      out.write("        <div class=\"container-div\">\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <h1 style=\"background-color: #555\">Online</h1>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"wrapper-div\">\n");
      out.write("            ");
  
                if(messages.isEmpty()) {
                    
      out.write("\n");
      out.write("                    <p>No new messages yet!</p>\n");
      out.write("                    ");

                }
                else {
                    for ( Messages m : messages ) {
                        String me = m.getMessage();
                        String name = m.getSender().toUpperCase();
                        
      out.write("\n");
      out.write("                        <div class=\"body\">\n");
      out.write("                            <p><strong>");
      out.print(name);
      out.write("</strong>: ");
      out.print(me);
      out.write("</p> \n");
      out.write("                        </div>\n");
      out.write("                        <br> <br>\n");
      out.write("                        ");

                    }
                } 
            
      out.write("\n");
      out.write("            </div>\n");
      out.write("                                \n");
      out.write("                 \n");
      out.write("            <div class=\"footer\">\n");
      out.write("                <form>\n");
      out.write("                    <input type=\"text\" name=\"message\" id=\"user-message\" placeholder=\"Enter your message\" required=\"\"/>\n");
      out.write("                    <input id=\"send\" class=\"button\" type=\"submit\" value=\"send\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("    \n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
