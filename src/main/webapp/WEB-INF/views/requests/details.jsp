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
        <td><form action="/requests" method="get"> <input type="submit" value="Back to list"></form></td>
        <td><form action="/requests/update/${request.id}" method="get"> <input type="submit" value="Update request"></form></td>
        <td><form action="/requests/delete/${request.id}" method="get"> <input type="submit" value="Delete request"></form></td>
    </tr>
</table>
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
</table>
<table>
    <tr>
        <th>Combined work time:</th>
        <th>${request.workTime}</th>
        <td><form action="/requests/addtoworktime/${request.id}" method="get"> <input type="submit" value="Add to work time"></form></td>
        <td><form action="/requests/subtractfromworktime/${request.id}" method="get"> <input type="submit" value="Subtract from work time"></form></td>
    </tr>
</table>
<table>
        <tr>
            <td><form action="/tasks/create/${request.id}" method="get"> <input type="submit" value="Create task"></form></td>
        </tr>
</table>
<table>
    <tr>
        <th>Task id: </th>
        <th>Status: </th>
        <th>Unit: </th>
        <th>Description: </th>
        <th>Edit: </th>
        <th>Delete: </th>
    </tr>
    <c:forEach items="${request.tasks}" var="task">
        <tr>
            <td>${task.id}</td>
            <td>${task.status}</td>
            <td>${task.unit.serialNumber}</td>
            <td>${task.description}</td>
            <td><form action="/tasks/assignunit/${request.id}/${task.id}" method="get"> <input type="submit" value="Assign unit"></form></td>
            <td><form action="/tasks/unassignunit/${task.id}" method="get"> <input type="submit" value="Unassign unit"></form></td>
            <td><form action="/tasks/update/${task.id}" method="get"> <input type="submit" value="Update task"></form></td>
            <td><form action="/tasks/delete/${task.id}" method="get"> <input type="submit" value="Delete task"></form></td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <td><form action="/requests/addunits/${request.id}" method="get"> <input type="submit" value="Add units"></form></td>
        <td><form action="/requests/removeunits/${request.id}" method="get"> <input type="submit" value="Remove units"></form></td>
    </tr>
</table>
<table>
    <tr>
        <th>Unit id:</th>
        <th>Serial number:</th>
    </tr>
    <c:forEach items="${request.units}" var="unit">
        <tr>
            <td>${unit.id}</td>
            <td>${unit.serialNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>