<%@ page import="com.app.storage.domain.model.listing.ItemListing" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<link href="<c:url value="/resources/css/Basket.css" />" rel="stylesheet">
<sec:authorize var="loggedIn" access="isAuthenticated()"/>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <div class="singleitem-container">
            <c:choose>
                <c:when test="${empty basketItems}">
                    <h1>You have not yet added any items to your basket..</h1>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${basketItems}" var="item" varStatus="theCount">

                        <div class="listingwrapper">
                            <div class="imageholder">
                <span class="logoWrapper">
                    <img id="img" height="100px" width="80px" src="${item.imageUrl}"
                         alt='icon'></span>
                            </div>

                            <div class="detailsholder">

                                <p>${item.description}</p>
                                <p id="price">Price: &pound${item.price}</p>
                                <c:choose>
                                    <c:when test="${not empty item.deliveryCharge}">
                                        <p id="price"> + Delivery Charge: &pound${item.deliveryCharge}</p>
                                    </c:when>
                                    <c:otherwise/>
                                </c:choose>

                                <form:form action="${pageContext.servletContext.contextPath}/removeFromBasket">
                                    <input name="uniqueRef" type="hidden" value="${item.reference}">
                                    <button id="removeButton" type="submit">Remove</button>
                                </form:form>

                            </div>
                        </div>
                    </c:forEach>

                    <div class="checkout">

                        <h3>Total price: &pound${totalPrice}</h3>

                        <form:form method="get" action="${pageContext.servletContext.contextPath}/checkout">
                            <button id="checkoutButton" type="submit">Check Out</button>
                        </form:form>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>