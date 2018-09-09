<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <jsp:include page="../partials/head.jsp"/>
</head>
<body>

<jsp:include page="../partials/header.jsp"/>

<div class="container">

    <h3 class="center-align">Login</h3>


    <div class="card" style="padding-top: 20px">
        <div class="row">
            <form id="login" class="col s10 offset-s1"
                  action="${pageContext.request.contextPath}/j_spring_security_check"
                  method="POST">

                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="Please enter username" value="" id="j_username" name="j_username"
                               type="text"
                               class="validate" path="j_username">
                        <label for="j_username">Username</label>
                        <span class="helper-text materialize-red-text"></span>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="Please enter an email" id="j_password" name="j_password" type="password"
                               class="validate" path="j_password">
                        <label for="j_password">Password</label>

                        <c:if test="${param.error!=null}">
                        <span class="helper-text materialize-red-text">
                            These credentials didn't match our records. Please check your login and password.
                        </span>
                        </c:if>

                    </div>
                </div>

                <div class="row">
                    <div class="col s12">
                        <label>
                            <input placeholder="Remember me" class="filled-in" id="remember_me" checked
                                   name="_spring_security_remember_me" type="checkbox">
                            <span>Remember me</span>
                        </label>
                    </div>
                </div>

                <div class="row">
                    <button class="btn waves-effect waves-light center-align" type="submit">Login
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </form>
        </div>

        <div class="card-action">
            <a href="${pageContext.request.contextPath}/signup">Register new user</a>
        </div>
    </div>

</div>

</body>
</html>
