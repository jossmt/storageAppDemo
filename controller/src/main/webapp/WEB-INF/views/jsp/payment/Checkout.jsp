<%@ page import="com.app.storage.domain.model.StorageItem" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<link href="<c:url value="/resources/css/Basket.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/Checkout.css" />" rel="stylesheet">
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

                                <p>Description: ${item.description}</p>
                                <p id="price">Price: ${item.price}</p>

                                <form:form action="${pageContext.servletContext.contextPath}/removeFromBasket">
                                    <input name="uniqueRef" type="hidden" value="${item.reference}">
                                    <button type="submit">Remove</button>
                                </form:form>

                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>

        <form:form method="post" modelAttribute="paymentTransaction" cssClass="credit-card">

            <div class="checkout">

                <h3>Total price: ${totalPrice}</h3>

                <form:hidden path="transactionAmount" value="${totalPrice}"/>
            </div>

            <div id="billingAddressInformation">
                <h3>Billing Information</h3>

                <form:input type="text" path="address.streetAddress"
                            placeholder="Full Street Address Details"/>
                <form:input type="text" path="address.region"
                            placeholder="Region"/>
                <form:input type="text" path="address.postcode"
                            placeholder="Postcode"/>
                <form:input type="text" path="address.countryName"
                            placeholder="Country"/>
            </div>

            <div id="paymentInformation">

                <h3>Payment Information</h3>
                <div class="form-header">
                    <h4 class="title">Credit card detail</h4>
                </div>

                <div class="form-body">
                    <!-- Card Number -->
                    <form:input type="text" class="card-number" path="cardInformation.cardHolderName"
                                placeholder="Card Holder Full Name"/>
                    <spring:bind path="cardInformation.cardNumber">
                        <form:input type="text" class="card-number" path="cardInformation.cardNumber"
                                    placeholder="Card Number"/>
                    </spring:bind>
                    <!-- Date Field -->
                    <div class="date-field">
                        <div class="month">
                            <spring:bind path="cardInformation.expirationMonth">
                                <form:input type="text" class="month" placeholder="Month"
                                            path="cardInformation.expirationMonth"/>
                            </spring:bind>
                        </div>
                        <div class="year">
                            <form:input type="text" class="year" placeholder="Year"
                                        path="cardInformation.expirationYear"/>
                        </div>
                    </div>

                    <!-- Card Verification Field -->
                    <div class="card-verification">
                        <spring:bind path="cardInformation.cvvValue">

                            <div class="cvv-input">
                                <form:input type="text" path="cardInformation.cvvValue"
                                            placeholder="CVV"/>
                            </div>
                        </spring:bind>

                        <div class="cvv-details">
                            <p>3 or 4 digits usually found <br> on the signature strip</p>
                        </div>
                    </div>

                    <!-- Buttons -->
                    <form:form method="post" action="${pageContext.servletContext.contextPath}/checkout">
                        <button type="submit" class="proceed-btn">Proceed</button>
                    </form:form>
                    <button type="submit" class="paypal-btn"><a href="#">Pay With Paypal</a></button>
                </div>
            </div>
        </form:form>

    </tiles:putAttribute>
</tiles:insertDefinition>