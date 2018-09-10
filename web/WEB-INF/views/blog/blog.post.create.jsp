<%--
  Created by IntelliJ IDEA.
  User: rahim
  Date: 07/09/18
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Create offer</title>
    <jsp:include page="../partials/head.jsp"/>
</head>
<body>

<jsp:include page="../partials/header.jsp"/>

<div class="container">
    <h3>Create blog post</h3>


    <div class="card" style="padding-top: 20px">
        <div class="row">
            <form:form class="col s10 offset-s1" action="${pageContext.request.contextPath}/posts/store"
                       commandName="post" method="POST">


                <div class="row">
                    <div class="input-field col s12">
                        <form:input placeholder="Please enter a title of post" id="title" name="title"
                                       class="" path="title"/>
                        <label for="text">Post Title</label>
                        <span class="helper-text materialize-red-text"><form:errors path="title"/></span>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                        <form:textarea placeholder="Please enter a text of post" id="text" name="text"
                                       class="materialize-textarea" path="text"/>
                        <label for="text">Text</label>
                        <span class="helper-text materialize-red-text"><form:errors path="text"/></span>
                    </div>
                </div>

                <div class="row">
                    <button class="btn waves-effect waves-light" type="submit" name="submit">Create post
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </form:form>
        </div>
        <div class="card-action">
            <a href="${pageContext.request.contextPath}/">Back to home</a>
            <a href="${pageContext.request.contextPath}/offers/create">New offer</a>
        </div>
    </div>

</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.datepicker');
        var instances = M.Datepicker.init(elems, {
            format: "dd-mm-yyyy"
        });
    });
</script>
</body>
</html>
