<%--
  Created by IntelliJ IDEA.
  User: rahim
  Date: 07/09/18
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create offer</title>
    <jsp:include page="../partials/head.jsp"/>
</head>
<body>

<jsp:include page="../partials/header.jsp"/>

<div class="container">
    <h3>Register new user</h3>


    <div class="card" style="padding-top: 20px">
        <div class="row">
            <form:form class="col s10 offset-s1" id="form" action="${pageContext.request.contextPath}/users/store"
                       commandName="user" method="POST">

                <div class="row">
                    <div class="input-field col s12">
                        <form:input placeholder="Please enter username" id="username" name="username" type="text"
                                    class="validate" path="username"/>
                        <label for="username">Username</label>
                        <span class="helper-text materialize-red-text"><form:errors
                                path="username"/></span>
                    </div>
                </div>


                <div class="row">
                    <div class="input-field col s12">
                        <form:input placeholder="Please enter a name" value="" id="name" name="name" type="text"
                                    class="validate" path="name"/>
                        <label for="name">Name</label>
                        <span class="helper-text materialize-red-text"><form:errors path="name"/></span>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                        <form:input placeholder="Please enter an email" id="email" name="email" type="email"
                                    class="validate" path="email"/>
                        <label for="email">Email</label>
                        <span class="helper-text materialize-red-text"><form:errors path="email"/></span>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">

                        <form:input placeholder="Please enter password" id="password" name="password" type="password"
                                    path="password"/>

                        <label for="password">Password</label>
                        <span class="helper-text materialize-red-text"><form:errors
                                path="password"/></span>
                    </div>
                </div>


                <div class="row">
                    <div class="input-field col s12">

                        <input placeholder="Please confirm password" id="password_confirmation"
                               name="password_confirmation" type="password"
                               path="password">

                        <label for="password_confirmation">Confirm password</label>
                        <span class="helper-text materialize-red-text" id="passwords_match_text"></span>
                    </div>
                </div>


                <div class="row">
                    <button class="btn waves-effect waves-light" type="submit" name="submit">Register
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </form:form>
        </div>

        <div class="card-action">
            <a href="${pageContext.request.contextPath}/">Back to home</a>
            <a href="${pageContext.request.contextPath}/login">Login page</a>
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

<script type="application/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="application/javascript" src="<c:url value="/resources/js/signup.js" />"></script>

</body>
</html>
