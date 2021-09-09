<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error{
            color: red;
        }
    </style>
    <title>Book creation</title>
</head>
<body>
    <table>
        <form:form method="post" modelAttribute="book">
            <tr>
                <td><form:label path="title">Title:</form:label></td>
                <td><form:input path="title" /></td>
                <td><form:errors path="title" /></td>
            </tr>
            <tr>
                <td><form:label path="rating">Rating:</form:label></td>
                <td><form:input path="rating" /></td>
                <td><form:errors path="rating" /></td>
            </tr>
            <tr>
                <td><form:label path="description">Description:</form:label></td>
                <td><form:textarea path="description" rows="5" cols="200" /></td>
                <td><form:errors path="description" /></td>
            </tr>
            <tr>
                <td><form:label path="pages">Pages:</form:label></td>
                <td><form:input path="pages" /></td>
                <td><form:errors path="pages" /></td>
            </tr>
            <tr>
                <td><form:label path="category">Category:</form:label></td>
                <td><form:select path="category" items="${categories}" itemValue="id" itemLabel="name"/></td>
                <td><form:errors path="category" /></td>
            </tr>
            <tr>
                <td><form:label path="authors">Author:</form:label></td>
                <td><form:select path="authors" items="${authors}" itemValue="id" multiple="true" itemLabel="fullName" /></td>
                <td><form:errors path="authors" /></td>
            </tr>
            <tr>
                <td><form:label path="publisher">Publisher:</form:label></td>
                <td><form:select path="publisher" items="${publishers}" itemValue="id" itemLabel="name" /></td>
                <td><form:errors path="publisher" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"></td>
            </tr>
        </form:form>
    </table>
</body>
</html>
