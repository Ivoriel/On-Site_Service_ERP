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
    <title>Unit details</title>
</head>
<body>
<table>
        <tr>
            <td>Serial Number: </td>
            <td>${unit.serialNumber}</td>
        </tr>
        <tr>
            <td>Client: </td>
            <td>${unit.client.name}</td>
        </tr>
        <tr>
            <td><form action="/units/form" method="get"> <input type="submit" value="Back to list"></form></td>
            <td><form action="/units/form/update/${unit.id}" method="get"> <input type="submit" value="Update unit"></form></td>
            <td><form action="/units/form/delete/${unit.id}" method="get"> <input type="submit" value="Delete unit"></form></td>
        </tr>
<%--        <c:forEach items="${clientUnits}" var="unit">--%>
<%--            <tr>--%>
<%--                <td>${unit.id}</td>--%>
<%--                <td>${unit.serialNumber}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
</table>
</body>
</html>