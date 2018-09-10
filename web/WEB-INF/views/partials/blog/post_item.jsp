<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: rahim
  Date: 10/09/18
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set value="${requestScope.post}" var="post"/>

<li>
    <h2><a href="/blog/post/${post.id}">${post.title}</a></h2>

    <div class="news-info">
        <div class="author"><i class="icon icon-user"></i>${post.username}</div>
        <div class="date"><i class="icon icon-clock"></i>${post.timestamp}</div>
        <div class="comments"><i class="icon icon-bubble"></i>0</div>
    </div>


    <div class="post-content">
        <img src="${post.imageUrl}" alt="${post.title}" class="img-responsive"/>
        <p>${fn:substring(post.text, 0, 200)}
            <a href="/blog/post/${post.id}" class="read-more" title="read more">&bull;&bull;&bull;</a>
        </p>
    </div>
</li>