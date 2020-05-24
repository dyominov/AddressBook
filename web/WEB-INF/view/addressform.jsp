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
    <c:if test="${requestScope.addressBook != null}">
    <form action="${pageContext.request.contextPath}/update" method="post">
        </c:if>
        <c:if test="${requestScope.addressBook == null}">
        <form action="${pageContext.request.contextPath}/new" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <c:if test="${requestScope.addressBook != null}">
                    <input type="hidden" name="id" value="<c:out value='${requestScope.addressBook.id}' />"/>
                </c:if>
                <tr>
                    <th>First name:</th>
                    <td>
                        <label>
                            <input type="text" name="name"
                                   value="${requestScope    .addressBook.person.firstName}" onclick="this.value=''"/>
                        </label>

                    </td>
                </tr>
                <tr>
                    <th>Last name:</th>
                    <td>
                        <label>
                            <input type="text" name="lastName"
                                   value="${requestScope.addressBook.person.lastName}" onclick="this.value=''"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>Address:</th>
                    <td>
                        <label>
                            <input type="text" name="address"
                                   value="${requestScope.addressBook.address}" onclick="this.value=''"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Create"/>
                        <input type="reset" value="Clear"/>
                    </td>
                </tr>
            </table>
        </form>
        <c:if test="${requestScope.exist}">
        Ann error occurred! Please try again!
        </c:if>
</div>
</body>
</html>