<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error{
            color: red;
        }
    </style>
    <title>Request creation</title>
</head>
<body>
    <table>
        <form:form method="post" modelAttribute="task">
            <tr>
                <td><form:label path="unit">Unit:</form:label></td>
                <td><form:select path="unit">
                    <form:option value="Select unit"/>
                    <form:options items="${units}" itemValue="id" itemLabel="serialNumber"/>
                    </form:select>
                </td>
                <td><form:errors path="unit" /></td>
            </tr>
            <tr>
                <td><form:label path="status">Status:</form:label></td>
                <td><form:select path="status">
                    <form:options items="${statuses}" itemValue="label" itemLabel="label" />
                    </form:select>
                </td>
                <td><form:errors path="status" /></td>
            </tr>
            <tr>
                <td><form:label path="description">Description:</form:label></td>
                <td><form:textarea path="description" /></td>
                <td><form:errors path="description" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"></td>
            </tr>
        </form:form>
    </table>
</body>
</html>
