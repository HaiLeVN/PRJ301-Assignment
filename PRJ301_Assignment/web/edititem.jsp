<%-- 
    Document   : edititem
    Created on : Jul 7, 2023, 11:30:35 AM
    Author     : lehai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Item</h1>
        
        <c:set var="i" value="${requestScope.item}"/>
        
        <c:if test="${i != null}">
            <form action="MainController" method="post">
                <input type="hidden" value="updateItem" name="action"/>
                <p>Item ID: <input type="number" value="${i.getItemId()}" name="txtitemid" readonly/></p>
                <p>Item Name: <input type="text" value="${i.getItemName()}" name="txtitemname"/></p>
                <p>Item Price: <input type="number" value="${i.getPrice()}" name="txtitemprice"/></p>
                <p>Category ID: <input type="number" value="${i.getCateId()}" name="txtcateid"/></p>
                <input type="submit" value="Save"/>
            </form>
                <a href="MainController">Cancel</a>
        </c:if>
        <h3 style="color: red">${requestScope.msg}</h3>
    </body>
</html>
