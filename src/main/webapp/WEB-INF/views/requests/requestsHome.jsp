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
                <form action="/requests/create">
                    <input type="submit" value="Add request">
                </form>
            </td>
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
        </tr>
    </table>
    <table>
        <tr>
            <th>Id</th>
            <th>Client</th>
            <th>Type</th>
            <th>Status</th>
            <th>Brief</th>
            <th>Debrief</th>
            <th>Units</th>
            <th>Tasks</th>
        </tr>
        <c:forEach items="${requests}" var="request">
            <tr>
                <td>${request.id}</td>
                <td>${request.client.name}</td>
                <td>${request.type}</td>
                <td>${request.status}</td>
                <td>${request.brief}</td>
                <td>${request.debrief}</td>
                <td>${request.units.size()}</td>
                <td>${request.serviceTasks.size()}</td>
                <form action="/requests/details/${request.id}" method="get">
                    <td>
                        <input type="submit" value="Details">
                    </td>
                </form>
                <form action="/requests/update/${request.id}" method="get">
                    <td>
                        <input type="submit" value="Edit">
                    </td>
                </form>
                <form action="/requests/delete/${request.id}" method="get">
                    <td>
                        <input type="submit" value="Delete">
                    </td>
                </form>
            </tr>
        </c:forEach>


    </table>
</body>
</html>