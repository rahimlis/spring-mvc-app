<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Created offer</title>
    <jsp:include page="../partials/head.jsp"/>

</head>
<body>

<jsp:include page="../partials/header.jsp"/>

<div class="container">

    <div class="card">
        <div class="row">
            <div class="col s10 offset-s1">
                <h4>You have been logged out</h4>
                <%--<h5>Email: ${offer.email}</h5>--%>
                <%--<h5>Text: ${offer.text}</h5>--%>
                <%--<h5>Birthday: ${offer.birthday}</h5>--%>
            </div>
        </div>
        <div class="card-action">
            <a href="${pageContext.request.contextPath}/">Back to home</a>
            <a href="${pageContext.request.contextPath}/login">Login page</a>
        </div>
    </div>

</div>

</body>
</html>
