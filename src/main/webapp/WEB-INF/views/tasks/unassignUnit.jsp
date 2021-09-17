<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Confirm unit unassignment</title>
</head>
<body>
    <table>
        <tr>
            <form action="/tasks/unassignunit/${taskId}" method="post">
                <td><input type="submit" value="Confirm"></td>
            </form>
            <form action="/tasks/details/${taskId}" method="get">
                <td><input type="submit" value="Cancel"></td>
            </form>
        </tr>
    </table>
</body>
</html>
