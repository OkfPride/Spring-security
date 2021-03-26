<%-- 
    Document   : startPage
    Created on : 26.03.2021, 7:23:15
    Author     : JavaDev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Page</title>
    </head>
    <body>
        <%--<security:authorize access="hasRole('Manager')">--%>
        <input type="button" value="perfomance" onclick="window.location.href = 'manager_page'"/> only for HR staff
    <%--</security:authorize>--%>
    <br/>
    <br/>
    <%--<security:authorize access = "hasRole('HR')">--%>
        <button value="salary" onclick="window.location.href = 'hr_page'">only for HR staff</button>only for HR staff
    <%--</security:authorize>--%>
</body>


</html>
