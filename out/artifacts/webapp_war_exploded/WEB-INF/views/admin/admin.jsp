<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin page</title>
    <jsp:include page="../partials/head.jsp"/>

</head>
<body>

<jsp:include page="../partials/header.jsp"/>

<div class="container">

    <div class="card">

        <div class="row">
            <div class="col s10 offset-s1">
                <h4>this page is seen only by admins</h4>
            </div>
        </div>

        <hr>

        <div class="row">
            <div class="col s10 offset-s1">
                <table>
                    <thead>
                    <tr>
                        <td>Name</td>
                        <td>Email</td>
                        <td>Authority</td>
                        <td>Enabled</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.authority}</td>
                            <td>${user.enabled}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="card-action">
            <a href="${pageContext.request.contextPath}/">Back to home</a>
        </div>

    </div>

</div>

</body>
</html>
