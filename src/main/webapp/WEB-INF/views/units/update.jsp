<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error{
            color: red;
        }
    </style>
    <title>Unit creation</title>
</head>
<body>
    <table>
        <form:form method="post" modelAttribute="unit">
            <tr>
                <td><form:label path="serialNumber">Serial number:</form:label></td>
                <td><form:input path="serialNumber" /></td>
                <td><form:errors path="serialNumber" /></td>
            </tr>
            <tr>
                <td><form:label path="client">Client id:</form:label></td>
                <td><form:select path="client" items="${clients}" itemValue="id" itemLabel="name"/></td>
                <td><form:errors path="client" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"></td>
            </tr>
        </form:form>
    </table>
</body>
</html>
