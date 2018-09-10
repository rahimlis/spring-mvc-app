<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <jsp:include page="../partials/blog/head.jsp"/>
</head>

<body>

<!-- PRELOADER -->
<div id="preloader">
    <div class="battery inner">
        <div class="load-line"></div>
    </div>
</div>

<div id="wrap">

    <!-- NAVIGATION BEGIN -->
    <jsp:include page="../partials/blog/navbar.jsp"/>
    <!-- NAVIGAION END -->


    <!-- INTRO BEGIN -->
    <header id="blog-intro" class="intro-block bg-color-main">
        <div class="container">
            <h1 class="slogan">Welcome to blog</h1>
        </div>
        <div class="block-bg" data-stellar-ratio="0.5"></div>
    </header>
    <!-- INTRO END -->


    <!-- BLOG BEGIN -->
    <section id="blog">
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1 blog-content">

                    <c:if test="${empty posts}">
                        <h3>There are no posts to display currently. Please come back later</h3>
                    </c:if>

                    <ul class="news-list post-list">
                        <c:forEach items="${posts}" var="post" varStatus="status">
                            <c:set var="post" value="${post}" scope="request"/>

                            <c:import url="../partials/blog/post_item.jsp"/>

                        </c:forEach>
                    </ul>

                    <ul class="post-pagination">
                        <li class="prev"><a href="#">&nbsp;</a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li class="next"><a href="#">&nbsp;</a></li>
                    </ul>

                </div>
            </div>
        </div>
    </section>
    <!-- BLOG END -->


    <!-- DOWNLOAD BEGIN -->
    <jsp:include page="../partials/blog/download_section.jsp"/>
    <!-- DOWNLOAD END -->


    <!-- FOOTER BEGIN -->
    <jsp:include page="../partials/blog/footer.jsp"/>
    <!-- FOOTER END -->

</div>


<!-- MODALS BEGIN-->
<jsp:include page="../partials/blog/modals.jsp"/>
<!-- MODALS END-->


<jsp:include page="../partials/blog/scripts.jsp"/>

</body>
</html>