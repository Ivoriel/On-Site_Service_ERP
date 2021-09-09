<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books list</title>
</head>
<body>
    <table>
        <tr>
            <td>
                <form action="/books/add">
                    <input type="submit" value="Add book">
                </form>
            </td>
            <td>
                <form action="/authors/all">
                    <input type="submit" value="Authors list">
                </form>
            </td>
            <td>
                <form action="/publishers/all">
                    <input type="submit" value="Publishers list">
                </form>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Rating</th>
            <th>Authors</th>
            <th>Publisher</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${allBooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.rating}</td>
                <td>${book.authors}</td>
                <td>${book.publisher.name}</td>
                <form action="/books/update/${book.id}" method="get">
                    <td>
                        <input type="submit" value="Edit">
                    </td>
                </form>
                <form action="/books/delete/${book.id}" method="get">
                    <td>
                        <input type="submit" value="Delete">
                    </td>
                </form>
            </tr>
        </c:forEach>


    </table>
</body>
</html>