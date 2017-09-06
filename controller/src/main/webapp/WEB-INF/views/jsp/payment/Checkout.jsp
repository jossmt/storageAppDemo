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
                                <c:choose>
                                    <c:when test="${not empty item.deliveryCharge}">
                                        <p id="price"> + Delivery Charge: ${item.deliveryCharge}</p>
                                    </c:when>
                                    <c:otherwise/>
                                </c:choose>


                                <form:form action="${pageContext.servletContext.contextPath}/removeFromBasket">
                                    <input name="uniqueRef" type="hidden" value="${item.reference}">
                                    <button type="submit">Remove</button>
                                </form:form>

                            </div>
                        </div>
                    </c:forEach>

                    <div></div>

                    <form:form method="post" modelAttribute="paymentTransaction" cssClass="msformwrapper">

                        <div class="msform">
                            <fieldset>
                                <h2 class="fs-title">Payment Method</h2>
                                <h3 class="fs-subtitle">Preferred Method of Payment</h3>
                                <div class="paymentOptions">
                                    <label><form:radiobutton name="paymentOption" path="usePaypal"
                                                             value="true" checked="checked"/>Paypal
                                    </label>
                                    <label><form:radiobutton name="paymentOption" path="usePaypal"
                                                             value="false"/>Card
                                    </label>
                                </div>
                                <div id="paypalDetails">
                                    <form:input path="paymentInformation.paypalUsername" type="text"
                                                name="paypalUsername"
                                                placeholder="Paypal Username"/>
                                </div>
                                <div id="cardDetails" hidden>
                                    <form:select path="paymentInformation.cardType">
                                        <form:options items="${paymentInformation.cardType}"/>
                                    </form:select>
                                    <form:input path="paymentInformation.cardHolderName" type="text"
                                                name="cardholdername"
                                                placeholder="Card Holder Name"/>
                                    <form:input path="paymentInformation.cardNumber" type="text"
                                                name="cardnumber"
                                                placeholder="Card Number"/>
                                    <form:input path="paymentInformation.cvvValue" type="text" name="cvv"
                                                placeholder="CVV"/>
                                    <form:input path="paymentInformation.expirationMonth" type="text"
                                                name="expmonth"
                                                placeholder="Expiration Month e.g. 02"/>
                                    <form:input path="paymentInformation.expirationYear" type="text"
                                                name="expyear"
                                                placeholder="Expiration Year"/>
                                </div>
                            </fieldset>
                        </div>

                        <div class="msform">
                            <fieldset>
                                <h2 class="fs-title">Delivery Address</h2>
                                <h3 class="fs-subtitle">Preferred Address for Item Delivery</h3>
                                <form:input path="address.streetAddress" name="addressList" placeholder="Address"/>
                                <form:input path="address.region" type="text" name="region" placeholder="Region"/>
                                <form:input path="address.postcode" type="text" name="postcode" placeholder="Postcode"/>
                                <form:input path="address.countryName" type="text" name="country"
                                            placeholder="Country"/>
                            </fieldset>
                        </div>

                        <div class="submit-container">
                            <p>Total Price: ${totalPrice}</p>
                            <form:input path="transactionAmount" name="transactionAmount" type="hidden"/>
                            <input id="paynowbutton" type="submit" name="submit" value="Pay Now"/>
                        </div>
                    </form:form>
                </c:otherwise>
            </c:choose>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>