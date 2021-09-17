<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Confirm task deletion</title>
</head>
<body>
    <table>
        <tr>
            <form action="/tasks/delete/${taskId}" method="post">
                <td><input type="submit" value="Confirm"></td>
            </form>
            <form action="/tasks/details/${taskId}" method="get">
                <td><input type="submit" value="Cancel"></td>
            </form>
        </tr>
    </table>
</body>
</html>
