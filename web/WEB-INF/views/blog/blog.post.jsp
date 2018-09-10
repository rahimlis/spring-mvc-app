<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rahim
  Date: 10/09/18
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
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
            <h1 class="slogan"><a href="${pageContext.request.contextPath}/blog">App's news</a></h1>
        </div>
        <div class="block-bg" data-stellar-ratio="0.5"></div>
    </header>
    <!-- INTRO END -->

    <!-- BLOG BEGIN -->
    <section id="blog">
        <div class="container">
            <div class="row">
                <div class="col-md-12 single-content">
                    <h2 class="head">${post.title}</h2>
                    <div class="news-info">
                        <div class="author"><i class="icon icon-user"></i>${post.user.name}</div>
                        <div class="date"><i class="icon icon-clock"></i>${post.timestamp}</div>
                        <div class="comments"><i class="icon icon-bubble"></i>0 Comments</div>
                    </div>
                    <div class="post-content">
                        <img src="../../<c:url value="${post.imageUrl}"/>" alt="${post.title}" class="img-responsive"/>
                        <p>${post.text}</p>
                    </div>


                    <!-- COMMENTS BEGIN -->
                    <div id="comments" class="comments">
                        <h3>4 Comments:</h3>
                        <ul class="comment-list">
                            <li class="comment depth-1">
                                <div class="comment-body">
                                    <div class="photo"><img src="../../resources/images/customer_photo.jpg" alt=""/>
                                    </div>
                                    <p>I am deeply experienced in this sphere (more than 14 years) and I know how should
                                        high-quality products look like. Here it is. It’s excellent.</p>
                                    <div class="comment-data"><span class="author">John Doe</span><span class="date">10 June 2014, 7:14 am</span><a
                                            href="#">Reply</a></div>
                                </div>
                                <ul class="children">
                                    <li class="comment depth-2">
                                        <div class="comment-body">
                                            <div class="photo"><img src="../../resources/images/customer_photo.jpg" alt=""/></div>
                                            <p>I don’t like to write reviews. But this time I can’t help from giving
                                                proper respect to developers. This is really nice work.</p>
                                            <div class="comment-data"><span class="author">Sarah Doe</span><span
                                                    class="date">11 June 2014, 11:08 am</span><a href="#">Reply</a>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="comment depth-1">
                                <div class="comment-body">
                                    <div class="photo"><img src="../../resources/images/customer_photo.jpg" alt=""/></div>
                                    <p>Such simple and flexible settings make this product a universal solution for the
                                        most of the interested customers. Try it, I am sure for 100% that you will be
                                        satisfied.</p>
                                    <div class="comment-data"><span class="author">Tim Bim</span><span class="date">12 June 2014, 2:48 pm</span><a
                                            href="#">Reply</a></div>
                                </div>
                            </li>
                            <li class="comment depth-1">
                                <div class="comment-body">
                                    <div class="photo"><img src="../../resources/images/customer_photo.jpg" alt=""/></div>
                                    <p>It’s just five stars. I will certainly come back and bring my friends with
                                        me.</p>
                                    <div class="comment-data"><span class="author">Sam Willis</span><span class="date">13 June 2014, 9:01 pm</span><a
                                            href="#">Reply</a></div>
                                </div>
                            </li>
                        </ul>
                        <div class="comment-respond">
                            <h3>Leave a comment:</h3>
                            <form role="form" id="comment_form">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="comment_name" placeholder="Full name *"
                                           name="name">
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" id="comment_email"
                                           placeholder="Email Address *" name="email">
                                </div>
                                <div class="form-group">
                                    <input type="url" class="form-control" id="comment_site" placeholder="Your site"
                                           name="site">
                                </div>
                                <div class="form-group">
                                    <textarea class="form-control" rows="6" placeholder="Type your comment *"
                                              id="comment_message" name="message"></textarea>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn_send" id="comment_submit">Post</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- COMMENTS END -->

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