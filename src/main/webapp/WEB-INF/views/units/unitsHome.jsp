<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Units list</title>
</head>
<body>
    <table>
        <tr>
            <td>
                <form action="/units/form/create">
                    <input type="submit" value="Add unit">
                </form>
            </td>
            <td>
                <form action="/clients/form">
                    <input type="submit" value="Clients list">
                </form>
            </td>
            <td>
                <form action="/requests/form">
                    <input type="submit" value="Requests list">
                </form>
            </td>
            <td>
                <form action="/tasks/form">
                    <input type="submit" value="Tasks list">
                </form>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <th>Id</th>
            <th>Serial number</th>
            <th>Client id</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${units}" var="unit">
            <tr>
                <td>${unit.id}</td>
                <td>${unit.serialNumber}</td>
                <td>${unit.client.name}</td>
                <form action="/units/form/details/${unit.id}" method="get">
                    <td>
                        <input type="submit" value="Details">
                    </td>
                </form>
                <form action="/units/form/update/${unit.id}" method="get">
                    <td>
                        <input type="submit" value="Edit">
                    </td>
                </form>
                <form action="/units/form/delete/${unit.id}" method="get">
                    <td>
                        <input type="submit" value="Delete">
                    </td>
                </form>
            </tr>
        </c:forEach>


    </table>
</body>
</html>