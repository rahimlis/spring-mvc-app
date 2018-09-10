<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rahim
  Date: 10/09/18
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-fixed-top">
    <div class="container_fluid">
        <a class="navbar-brand goto" href="${pageContext.request.contextPath}/"><b>HOME</b></a>
        <a class="contact-btn icon-envelope" data-toggle="modal" data-target="#modalContact"></a>
        <button class="navbar-toggle menu-collapse-btn collapsed" data-toggle="collapse"
                data-target=".navMenuCollapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span
                class="icon-bar"></span></button>
        <div class="collapse navbar-collapse navMenuCollapse">
            <ul class="nav">
                <li><a href="${pageContext.request.contextPath}/offers">Offers</a></li>
                <li><a href="${pageContext.request.contextPath}/blog">Blog</a></li>

                <sec:authorize access="isAuthenticated()">
                    <li><a href="<c:url value='/posts/create'/>">Create post</a></li>
                </sec:authorize>


                <sec:authorize access="!isAuthenticated()">
                    <li><a href="<c:url value='/login'/>">Login</a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
                </sec:authorize>

            </ul>
        </div>
    </div>
</nav>
