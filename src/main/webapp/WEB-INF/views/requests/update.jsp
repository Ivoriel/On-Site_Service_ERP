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
        <form:form method="post" modelAttribute="request">
            <tr>
                <td><form:label path="client">Client:</form:label></td>
                <td><form:select path="client" items="${clients}" itemValue="id" itemLabel="name"/></td>
                <td><form:errors path="client" /></td>
            </tr>
            <tr>
                <td><form:label path="type">Type:</form:label></td>
                <td><form:select path="type"><form:options items="${types}" itemValue="label" itemLabel="label"/> </form:select></td>
                <td><form:errors path="type" /></td>
            </tr>
            <tr>
                <td><form:label path="status">Status:</form:label></td>
                <td><form:select path="status" items="${statuses}" itemValue="label" itemLabel="label"/></td>
                <td><form:errors path="status" /></td>
            </tr>
            <tr>
                <td><form:label path="brief">Brief:</form:label></td>
                <td><form:textarea path="brief" /></td>
                <td><form:errors path="brief" /></td>
            </tr>
            <tr>
                <td><form:label path="debrief">Debrief:</form:label></td>
                <td><form:textarea path="debrief" /></td>
                <td><form:errors path="debrief" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"></td>
            </tr>
        </form:form>
    </table>
</body>
</html>
