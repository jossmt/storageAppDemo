<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<link href="<c:url value="/resources/css/StorageSingle.css" />" rel="stylesheet">
<sec:authorize var="loggedIn" access="isAuthenticated()"/>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <div class="singleitem-container">
            <div class="imageholder">
                <span class="logoWrapper">
                    <img id="img" height="100%" src="${storageItem.imageUrl}"
                         alt='icon'></span>
            </div>

            <div class="detailsholder">

                <p>Brand: ${storageItem.brand}</p>
                <p>Size: ${storageItem.size}</p>
                <p>Description: ${storageItem.description}</p>
                <p>Grade: ${storageItem.grade}</p>
                <p id="price">Price: ${storageItem.price}</p>

                <form:form action="${pageContext.servletContext.contextPath}/addToBasket">
                    <input name="uniqueRef" type="hidden" value="${storageItem.reference}">
                    <button id="addToBasketButton" type="submit">Add to Basket</button>
                </form:form>

            </div>

        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>