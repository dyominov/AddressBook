<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Address Book</title>
</head>
<body>
<center>
    <h2>
        <a href="${pageContext.request.contextPath}/">Home page</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/create">Add new records</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/list">Show all records</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        Sort by: &nbsp;
        <a href="${pageContext.request.contextPath}/sortAsc">ascending</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/sortDesc">descending</a>
        <tr>
            <th>ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Address</th>
            <th>Operation</th>
        </tr>
        <c:forEach var="addressBook" items="${requestScope.addressBooks.addressBooks}">
            <tr>
                <td><c:out value="${addressBook.id}"/></td>
                <td><c:out value="${addressBook.person.firstName}"/></td>
                <td><c:out value="${addressBook.person.lastName}"/></td>
                <td><c:out value="${addressBook.address}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/read?id=<c:out value='${addressBook.id}' />">Read</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/edit?id=<c:out value='${addressBook.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${addressBook.id}' />">Delete</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
