<%--
  Created by IntelliJ IDEA.
  User: rahim
  Date: 06/09/18
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hello world</title>
    <jsp:include page="partials/head.jsp"/>

</head>
<body>

<jsp:include page="partials/header.jsp"/>

<div class="container">
    <div class="card">
        <div class="row">
            <div class="col s9 offset-s2">
                <h2>Error occurred while processing this request. Please try again later!</h2>
            </div>
        </div>
        <div class="card-action">
            <a href="${pageContext.request.contextPath}/offers">View offers</a>
            <a href="${pageContext.request.contextPath}/offers/create">Create offer</a>
        </div>
    </div>
</div>
</body>
</html>
