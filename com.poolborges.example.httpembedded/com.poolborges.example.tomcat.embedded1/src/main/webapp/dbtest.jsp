<%-- 
    Document   : dbtest
    Created on : Dec 21, 2012, 12:30:47 PM
    Author     : PauloBorges
--%>
<html> 
    <head> 
        <title>DB Test</title> 
    </head> 
    <body> 

        <%
            String completion = request.getParameter("completion");
            com.poolborges.example.tomcat.embedded.DBTest test = new com.poolborges.example.tomcat.embedded.DBTest();
            test.init(completion);
        %> 
        <h2>Transaction completion</h2> 
        Transaction completion is :<strong><%= completion%></strong> 

        <h2>Results</h2> 
        Int stored in JDBC : <strong><%= test.getFoo()%></strong><br /> 

        <hr /> 

        <form action="test.jsp" method="get"> 
            <input type="radio" name="completion" value="commit" checked="true"> Commit<BR> 
            <input type="radio" name="completion" value="rollback">Rollback<BR> 
            <button type="submit">Completion</button> 
        </form> 
    </body> 
</html>
