<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error{
            color: red;
        }
    </style>
    <title>Add work time to request</title>
</head>
<body>
<table>
    <form:form method="post" modelAttribute="request">
        <tr>
            <form:hidden path="requestId" value="${requestId}" />
            <th>
                <form:label path="workTime">Add work time to request: </form:label>
            </th>
            <th>
                <form:input path="workTime"></form:input>
            </th>
            <th><form:errors path="workTime" /></th>
        </tr>
        <tr>
            <th><input type="submit" value="Save"></th>
        </tr>
    </form:form>
</table>
</body>
</html>
