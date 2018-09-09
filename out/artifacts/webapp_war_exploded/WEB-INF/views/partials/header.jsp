<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<header>
    <nav>
        <div class="nav-wrapper">
            <a style="margin-left: 2%" href="${pageContext.request.contextPath}/" class="brand-logo">WebApp</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="<c:url value='/offers'/>">View offers</a></li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="<c:url value='/admin'/>">Admin</a></li>
                </sec:authorize>


                <sec:authorize access="!isAuthenticated()">
                    <li><a href="<c:url value='/login'/>">Login</a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li><a href="<c:url value='/j_spring_security_logout'/>">Logout</a></li>
                </sec:authorize>

            </ul>
        </div>
    </nav>
</header>