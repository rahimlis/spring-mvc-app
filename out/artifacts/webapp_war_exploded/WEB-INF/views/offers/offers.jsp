<%--
  Created by IntelliJ IDEA.
  User: rahim
  Date: 06/09/18
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
    <title>Hello world</title>
    <jsp:include page="../partials/head.jsp"/>

</head>
<body>
<jsp:include page="../partials/header.jsp"/>

<div class="container">
    <div class="card">
        <div class="row">
            <div class="col s10 offset-s1">
                <h1>${title}</h1>

                <hr>

                <table>
                    <thead>
                    <tr>
                        <td>Name</td>
                        <td>Email</td>
                        <td>Text</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="offer" items="${offers}">
                        <tr>
                            <td>${offer.user.name}</td>
                            <td>${offer.user.email}</td>
                            <td>${offer.text}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-action">
            <a href="${pageContext.request.contextPath}/">Back to home</a>
            <a href="${pageContext.request.contextPath}/offers/create">New offer</a>
        </div>
    </div>
</div>
</body>
</html>
