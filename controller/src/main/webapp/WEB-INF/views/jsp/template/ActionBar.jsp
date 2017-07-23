<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="principal" property="principal" />

<div class="navbar">

    <h3 id="logo">Company<span>logo</span></h3>

    <div class="login">
        <ul>
            <c:choose>
                <c:when test="${principal.username != null}">
                    <a href="/profile">${principal.username}</a>
                    <a href="/logout">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.servletContext.contextPath}/login">Login</a>
                    <a href="${pageContext.servletContext.contextPath}/signup">Sign Up</a>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
    <div class="home">
        <ul>
            <a href="${pageContext.servletContext.contextPath}/home">Home</a>
            <a href="${pageContext.servletContext.contextPath}/about">About</a>
            <a href="${pageContext.servletContext.contextPath}/mystorage">My Storage</a>
            <a href="${pageContext.servletContext.contextPath}/myrequests">My Requests</a>
        </ul>
    </div>
</div>