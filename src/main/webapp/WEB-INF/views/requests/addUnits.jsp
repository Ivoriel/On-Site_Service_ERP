<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error{
            color: red;
        }
    </style>
    <title>Add units to request</title>
</head>
<body>
<table>
    <form:form method="post" modelAttribute="unitList">
        <tr>
            <th>
                <form:label path="units">Add units to request: </form:label>
            </th>
            <th>
                <form:select path="units" multiple="true">
                    <form:options items="${units}" itemValue="id" itemLabel="serialNumber" />
                </form:select>
            </th>
            <th><form:errors path="units" /></th>
        </tr>
        <tr>
            <th><input type="submit" value="Save"></th>
        </tr>
    </form:form>
</table>
</body>
</html>
