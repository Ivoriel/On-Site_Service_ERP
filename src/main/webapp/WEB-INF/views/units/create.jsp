<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error{
            color: red;
        }
    </style>
    <title>Client creation</title>
</head>
<body>
    <table>
        <form:form method="post" modelAttribute="client">
            <tr>
                <td><form:label path="name">Name:</form:label></td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"></td>
            </tr>
        </form:form>
    </table>
</body>
</html>
