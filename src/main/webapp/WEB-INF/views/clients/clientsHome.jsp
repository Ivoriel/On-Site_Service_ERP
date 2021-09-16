<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Clients list</title>
</head>
<body>
    <table>
        <tr>
            <td>
                <form action="/clients/create">
                    <input type="submit" value="Add client">
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
            <td>
                <form action="/tasks">
                    <input type="submit" value="Tasks list">
                </form>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Details</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.name}</td>
                <form action="/clients/details/${client.id}" method="get">
                    <td>
                        <input type="submit" value="Details">
                    </td>
                </form>
                <form action="/clients/update/${client.id}" method="get">
                    <td>
                        <input type="submit" value="Edit">
                    </td>
                </form>
                <form action="/clients/delete/${client.id}" method="get">
                    <td>
                        <input type="submit" value="Delete">
                    </td>
                </form>
            </tr>
        </c:forEach>


    </table>
</body>
</html>