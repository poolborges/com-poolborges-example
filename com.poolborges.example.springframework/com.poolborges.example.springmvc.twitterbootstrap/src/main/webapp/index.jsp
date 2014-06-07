<!--
 - index.jsp
 - Copyright (c) 2012 by Paulo Borges. All rights reserved.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>
            <b>JSP Page Context Information</b><br/>
        </p>
        <p>
            <b>Pre-defined objects:</b><br/>
            <%
                out.println("out: " + out.getClass().getName() + "<br/>");
                out.println("this: " + this.getClass().getName() + "<br/>");
                out.println("request: " + request.getClass().getName() + "<br/>");
                out.println("response: " + response.getClass().getName() + "<br/>");
                out.println("session: " + session.getClass().getName() + "<br/>");
                out.println("application: " + application.getClass().getName() + "<br/>");
                out.println("config: " + config.getClass().getName() + "<br/>");
                out.println("pageContext: " + pageContext.getClass().getName() + "<br/>");
                out.println("pathInfo:  " + request.getPathInfo() + "<br/>");
                out.println("pathTrans: " + request.getPathTranslated() + "<br/>");
                out.println("uri:       " + request.getRequestURI() + "<br/>");
            %>
        </p>
        <p>
            <b>Information about session:</b><br/>
            <i>= pageContext.getSession();</i><br/>
            <%
                out.println("Class Name: " + session.getClass().getName() + "<br/>");
                out.println("Session ID: " + session.getId() + "<br/>");
                java.util.Date d = new java.util.Date();
                d.setTime(session.getCreationTime());
                out.println("Create Time: " + d.toString() + "<br/>");
                d.setTime(session.getLastAccessedTime());
                out.println("Last Access Time: " + d.toString() + "<br/>");
                out.println("Is Session New: " + session.isNew() + "<br/>");
            %>
        </p>
        <p>
            <b>Information about sessionContext:</b><br/>
            <i>= session.getSessionContext();</i><br/>
            <%
                javax.servlet.http.HttpSessionContext c = session.getSessionContext();
                out.println("Class name: " + c.getClass().getName() + "<br/>");
            %>
        </p>
        <p>
            <b>Information about application:</b><br/>
            <i>= pageContext.getServletContext();</i><br/>
            <%
                out.println("Class Name: " + application.getClass().getName() + "<br/>");
                out.println("Major Version: " + application.getMajorVersion() + "<br/>");
                out.println("Minor Version: " + application.getMinorVersion() + "<br/>");
                out.println("Server Info: " + application.getServerInfo() + "<br/>");
                out.println("Serlet Context Name: "
                        + application.getServletContextName() + "<br/>");
                java.util.Enumeration e = application.getServletNames();
                while (e.hasMoreElements()) {
                    String n = (String) e.nextElement();
                    out.println("Servlet Name: " + n + "<br/>");
                }
                e = application.getInitParameterNames();
                while (e.hasMoreElements()) {
                    String n = (String) e.nextElement();
                    out.println("Init Parameter Name: " + n + "<br/>");
                }
            %>
        </p>
    </body></html>