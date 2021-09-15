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
    <title>Request details</title>
</head>
<body>
<table>
        <tr>
            <td>Request number: </td>
            <td>${request.id}</td>
        </tr>
        <tr>
            <td>Request type: </td>
            <td>${request.type.label}</td>
        </tr>
        <tr>
            <td>Request status: </td>
            <td>${request.status.label}</td>
        </tr>
        <tr>
            <td>Client: </td>
            <td>${request.client}</td>
        </tr>
        <tr>
            <td>Client: </td>
            <td>${request.brief}</td>
        </tr>
        <tr>
            <td>Client: </td>
            <td>${request.debrief}</td>
        </tr>
        <tr>
            <td><form action="/requests" method="get"> <input type="submit" value="Back to list"></form></td>
            <td><form action="/requests/update/${request.id}" method="get"> <input type="submit" value="Update request"></form></td>
            <td><form action="/requests/delete/${request.id}" method="get"> <input type="submit" value="Delete request"></form></td>
        </tr>
        <tr>
            <th>Unit id:</th>
            <th>Serial number:</th>
        </tr>
        <c:forEach items="${requestUnits}" var="unit">
            <tr>
                <td>${unit.id}</td>
                <td>${unit.serialNumber}</td>
            </tr>
        </c:forEach>
</table>
</body>
</html>