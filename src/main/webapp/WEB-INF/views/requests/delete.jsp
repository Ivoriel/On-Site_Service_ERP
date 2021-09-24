<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Confirm request deletion</title>
</head>
<body>
    <table>
        <tr>
            <form action="/requests/form/delete/${requestId}" method="post">
                <td><input type="submit" value="Confirm"></td>
            </form>
            <form action="/requests/form/details/${requestId}" method="get">
                <td><input type="submit" value="Cancel"></td>
            </form>
        </tr>

    </table>
</body>
</html>
