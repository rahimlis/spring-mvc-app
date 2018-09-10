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
                <h4>Your post has been created!</h4>
                <h5>Username: ${post.username}</h5>
                <h5>Title: ${post.title}</h5>
                <h5>Text: ${post.text}</h5>
                <h5>Link: <a href="/blog/post/${post.id}">go</a></h5>
            </div>
        </div>
        <div class="card-action">
            <a href="${pageContext.request.contextPath}/">Back to home</a>
            <a href="${pageContext.request.contextPath}/posts/create">New post</a>
        </div>
    </div>

</div>

</body>
</html>
