<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value="/resources/css/Storage.css" />" rel="stylesheet">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

            <c:choose>
                <c:when test="${empty itemListings}">
                    <div class="noitem-container">
                    <h1>No items have been uploaded yet...</h1>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${itemListings}" var="item" varStatus="theCount">
                        <div class="list-container">
                            <div class="flip-container" ontouchstart="this.classList.toggle('hover');">
                                <a id="selector"
                                   href="${pageContext.servletContext.contextPath}/item/${item.reference}">
                                    <div class="flipper">
                                        <div class="front">
                                            <!-- front content -->
                                            <span class="logoWrapper">
                                     <img id="img" height="200px" width="150px" src="${item.imageUrl}"
                                          alt='icon'></span>
                                            <p id="price"><c:out value="Price: ${item.price}"/></p>
                                        </div>
                                        <div class="back">
                                            <!-- back content -->
                                            <p><c:out value="${item.description}"/></p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
    </tiles:putAttribute>
</tiles:insertDefinition>