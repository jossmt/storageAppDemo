<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value="/resources/css/Storage.css" />" rel="stylesheet">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <c:choose>
            <c:when test="${empty storageItems}">
                <h1>You have not yet uploaded any items..</h1>
            </c:when>
            <c:otherwise>
                <c:forEach items="${storageItems}" var="item" varStatus="theCount">
                    <div class="list-container">
                        <div class="flip-container" ontouchstart="this.classList.toggle('hover');">
                            <div class="flipper">
                                <div class="front">
                                    <!-- front content -->
                                    <span class="logoWrapper">
                                     <img id="img" height="200px" width="150px" src="${item.imageUrl}"
                                          alt='icon'></span>
                                </div>
                                <div class="back">
                                    <!-- back content -->
                                    <p><c:out value="Brand: ${item.brand}"/></p>
                                    <p><c:out value="Size: ${item.size}"/></p>
                                    <p><c:out value="Description: ${item.description}"/></p>
                                    <p id="price"><c:out value="Price: ${item.price}"/></p>
                                    <p><c:out value="Grade: ${item.grade}"/></p>
                                    <a id="selector"
                                       href="${pageContext.servletContext.contextPath}/item/${item.reference}">View
                                        Item</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </tiles:putAttribute>
</tiles:insertDefinition>