<%-- 
    Document   : faqs
    Created on : Jul 4, 2023, 9:37:47 AM
    Author     : ThanhHai
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
        <h1>FAQ management</h1>
        <c:set var="itemlist" value="${requestScope.itemList}"/>
        <c:if test="${not empty itemlist}">
            <form action="MainController" method="post">
                <input type="hidden" value="loadFAQItem" name="action"/>
                <select name="value">
                    <option value="" selected disabled hidden>Choose item</option>
                    <c:forEach var="itemname" items="${requestScope.itemList}">
                        <option value="${itemname.getItemId()}">${itemname.getItemName()}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Choose"/>
            </form>
        </c:if>
        
        <c:if test="${empty itemlist}">
            <h2>List is empty, please create some items</h2>
            <a href="MainController?action=manageItem">Click here to go to Item Management</a>
        </c:if>

        <c:set var="faqlist" value="${requestScope.faqList}"/>
        <c:if test="${not empty faqlist}">
            <c:forEach var="faq" items="${requestScope.faqList}">
                <p>FAQ ID: <input type="number" value="${faq.getId()}" readonly/></p>
                <p>Customer Name: <input type="text" value="${faq.getCustName()}" readonly/></p>
                <p>Content: <input type="text" value="${faq.getCustContent()}" readonly/></p>
            </c:forEach>
        </c:if>
         <a href="MainController">Back</a>
    </body>
</html>
