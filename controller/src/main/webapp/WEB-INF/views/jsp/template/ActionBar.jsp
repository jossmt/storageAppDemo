<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="principal" property="principal"/>
<sec:authorize var="loggedIn" access="isAuthenticated()"/>


<div class="navbar">

    <h3 id="logo">Company<span>logo</span></h3>

    <div class="login">
        <ul>
            <c:choose>
                <c:when test="${loggedIn}">
                    <a href="${pageContext.servletContext.contextPath}/profile">${principal.firstName}</a>
                    <a href="${pageContext.servletContext.contextPath}/logout">Logout</a>
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
            <a id="discovernav" href="${pageContext.servletContext.contextPath}/discover">Discover</a>
            <a id="howitworksnav" href="${pageContext.servletContext.contextPath}/home">How selling works?</a>
            <c:choose>
                <c:when test="${loggedIn}">
                    <a href="${pageContext.servletContext.contextPath}/myItems">My Items</a>
                </c:when>
            </c:choose>
            <a id="basketnav" href="${pageContext.servletContext.contextPath}/basket">Basket</a>
        </ul>
    </div>
</div>