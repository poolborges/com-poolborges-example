
<%@ page language="java" import="com.poolborges.example.smvc.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Article: <c:out value="${article.title}" /></title>
    </head>

    <body>

        <%@ include file="header.jsp" %>

        <div id="mainContent">

            <p><a href="home.htm">Home</a></p>

            <div id="articleContentHeading">

                <h2><c:out value="${article.title}" /></h2>
                <p>By <span class="articleAuthor"><c:out value="${article.author}" /></span>
                    on <span class="articleDate"><fmt:formatDate value="${article.date}" type="both" /></span>
                </p>

            </div>

            <div id="articleContent">
                <c:out value="${article.content}" escapeXml="false" />
            </div>

        </div>

        <%@ include file="footer.jsp" %>

    </body>
</html>
