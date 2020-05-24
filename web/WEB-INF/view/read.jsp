<%--
  Created by IntelliJ IDEA.
  User: dyominov
  Date: 24.05.2020
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <form action="${pageContext.request.contextPath}/read" method="get">
        <c:if test="${requestScope.addressBook != null}">
            <input type="hidden" name="id" value="<c:out value='${requestScope.addressBook.id}' />"/>
        </c:if>
        <table border="1" cellpadding="5">
            <tr>
                <th>First name:</th>
                <td>
                    <label>
                        <div> ${requestScope.addressBook.person.firstName}</div>
                    </label>

                </td>
            </tr>
            <tr>
                <th>Last name:</th>
                <td>
                    <label>
                        <div> ${requestScope.addressBook.person.lastName}</div>
                    </label>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <label>
                        <div> ${requestScope.addressBook.address}</div>
                    </label>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
