<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Requests list</title>
</head>
<body>
    <table>
        <tr>
            <td>
                <form action="/clients">
                    <input type="submit" value="Clients list">
                </form>
            </td>
            <td>
                <form action="/units">
                    <input type="submit" value="Units list">
                </form>
            </td>
            <td>
                <form action="/requests">
                    <input type="submit" value="Requests list">
                </form>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <th>Id</th>
            <th>Request</th>
            <th>Unit</th>
            <th>Status</th>
            <th>Description</th>
            <th>Details</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.request.id}</td>
                <td>${task.unit.serialNumber}</td>
                <td>${task.status.label}</td>
                <td>${task.description}</td>
                <form action="/tasks/details/${task.id}" method="get">
                    <td>
                        <input type="submit" value="Details">
                    </td>
                </form>
                <form action="/tasks/update/${task.id}" method="get">
                    <td>
                        <input type="submit" value="Edit">
                    </td>
                </form>
                <form action="/tasks/delete/${task.id}" method="get">
                    <td>
                        <input type="submit" value="Delete">
                    </td>
                </form>
            </tr>
        </c:forEach>


    </table>
</body>
</html>