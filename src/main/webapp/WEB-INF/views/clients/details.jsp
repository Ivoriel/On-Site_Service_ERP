<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        .error{
            color: red;
        }
    </style>
    <title>Client details</title>
</head>
<body>
<table>
        <tr>
            <td>Name: </td>
            <td>${client.name}</td>
        </tr>
        <tr>
            <td><form action="/clients" method="get"> <input type="submit" value="Back to list"></form></td>
            <td><form action="/clients/update/${client.id}" method="get"> <input type="submit" value="Update client"></form></td>
            <td><form action="/clients/delete/${client.id}" method="get"> <input type="submit" value="Delete client"></form></td>
        </tr>
        <tr>
            <th>Unit id:</th>
            <th>Serial number:</th>
        </tr>
        <c:forEach items="${clientUnits}" var="unit">
            <tr>
                <td>${unit.id}</td>
                <td>${unit.serialNumber}</td>
            </tr>
        </c:forEach>
</table>
</body>
</html>