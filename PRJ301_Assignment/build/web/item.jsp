<%-- 
    Document   : item
    Created on : Jul 4, 2023, 9:37:53 AM
    Author     : ThanhHai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Item List</h1>
        <c:set var="list" value="${requestScope.itemlist}"/>
        <c:if test="${list != null && not empty list}">
            <table>
                <tr>
                    <th>Item ID</th>
                    <th>Item Name</th>
                    <th>Price</th>
                    <th>Category ID</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="item" items="${requestScope.itemlist}">
                    <form action="MainController" method="post">
                        <input type="hidden" value="crudItem" name="action"/>
                        <input type="hidden" value="${item.getItemId()}" name="txtitemid"/>
                        <tr>
                            <td>${item.getItemId()}</td>
                            <td>${item.getItemName()}</td>
                            <td>${item.getPrice()}</td>
                            <td>${item.getCateId()}</td>
                            <td>
                                <!-- CRUD table -->
                                <input type="submit" value="Edit" name="crudaction"/>
                                <input type="submit" value="Delete"/>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </c:if>
        <h3 style="color: chocolate">${requestScope.msg}</h3>
        <hr/>
        <h1>Create an item</h1>
        <h3 style="color: forestgreen">${requestScope.msg2}</h3>
        <form action="MainController" method="post">
            <input type="hidden" value="createItem" name="action"/>
            <p><input type="number" name="txtitemid" placeholder="Enter the item ID"/></p>
            <p><input type="text" name="txtitemname" placeholder="Enter the item name"/></p>
            <p><input type="number" name="txtitemprice" placeholder="Enter the price"</p>
            <p><input type="number" name="txtcateid" placeholder="Enter the category ID"</p>
            <p><input type="submit" value="Create"</p>
        </form>
        
        <a href="MainController">Back</a>
        
    </body>
</html>
