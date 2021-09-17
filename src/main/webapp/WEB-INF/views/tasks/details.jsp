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
            <td>Task number: </td>
            <td>${task.id}</td>
        </tr>
        <tr>
            <td>Request status: </td>
            <td>${task.status.label}</td>
        </tr>
        <tr>
            <td>Unit: </td>
            <td>${task.unit.serialNumber}</td>
        </tr>
        <tr>
            <td>Description: </td>
            <td>${task.description}</td>
        </tr>
        <tr>
            <td><form action="/requests/details/${task.request.id}" method="get"> <input type="submit" value="Back to request"></form></td>
            <td><form action="/tasks/update/${task.id}" method="get"> <input type="submit" value="Update task"></form></td>
            <td><form action="/tasks/delete/${task.id}" method="get"> <input type="submit" value="Delete task"></form></td>
        </tr>
</table>
</body>
</html>