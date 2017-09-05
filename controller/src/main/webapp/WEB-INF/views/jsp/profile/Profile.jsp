<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<link href="<c:url value="/resources/css/Profile.css" />" rel="stylesheet">
<sec:authorize var="loggedIn" access="isAuthenticated()"/>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <div class="profile-container">

            <div class="profile-data">

                <div class="profile-data-set title">
                    <h1 class="title">Personal Details</h1>
                </div>
                <div class="profile-data-set">
                    <h3>Full Name: ${userModel.firstName} ${userModel.lastName}</h3>
                    <span><a>edit</a></span>
                </div>
                <div class="profile-data-set">
                    <h3>Email: ${userModel.email}</h3>
                    <span><a>edit</a></span>
                </div>
                <div class="profile-data-set">
                    <h3>Password: *******</h3>
                    <span><a>edit</a></span>
                </div>
                <div class="profile-data-set">
                    <h1 class="title">Address Information</h1>
                </div>
                <div class="profile-data-set">
                    <h1 class="minortitle">Billing Address</h1>
                </div>

                <c:set var="existsBilling" value="false" scope="session"/>
                <c:forEach items="${userModel.addressList}" var="address" varStatus="theCount">
                    <c:choose>
                        <c:when test="${address.addressType = 'BILLING'}">
                            <div class="profile-data-set">
                                <h3>Street Address: ${address.streetAddress}</h3>
                            </div>
                            <div class="profile-data-set">
                                <h3>Region: ${address.region}</h3>
                            </div>
                            <div class="profile-data-set">
                                <h3>PostCode: ${address.postcode}</h3>
                            </div>
                            <div class="profile-data-set">
                                <h3>Country Name: ${address.countryName}</h3>
                                <span><a>edit</a></span>
                            </div>
                            <c:set var="existsBilling" value="true" scope="session"/>
                        </c:when>
                        <c:otherwise/>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${not existsBilling}">
                        <div class="profile-data-set">
                            <h3>You have not yet added a Billing Address.</h3>
                            <span><a>Add a Billing Address</a></span>
                        </div>
                    </c:when>
                    <c:otherwise/>
                </c:choose>


                <div class="profile-data-set">
                    <h1 class="minortitle">Delivery Address</h1>
                </div>

                <c:set var="existsDelivery" value="false" scope="session"/>
                <c:forEach items="${userModel.addressList}" var="address" varStatus="theCount">
                    <c:choose>
                        <c:when test="${address.addressType = 'DELIVERY'}">
                            <div class="profile-data-set">
                                <h3>Street Address: ${address.streetAddress}</h3>
                            </div>
                            <div class="profile-data-set">
                                <h3>Region: ${address.region}</h3>
                            </div>
                            <div class="profile-data-set">
                                <h3>PostCode: ${address.postcode}</h3>
                            </div>
                            <div class="profile-data-set">
                                <h3>Country Name: ${address.countryName}</h3>
                                <span><a>edit</a></span>
                            </div>
                            <c:set var="existsDelivery" value="true" scope="session"/>
                        </c:when>
                        <c:otherwise/>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${not existsDelivery}">
                        <div class="profile-data-set">
                            <h3>You have not yet added a Delivery Address.</h3>
                            <span><a>Add a Delivery Address</a></span>
                        </div>
                    </c:when>
                    <c:otherwise/>
                </c:choose>


                <div class="profile-data-set">
                    <h1 class="title">Payment Information</h1>
                </div>

                <div class="profile-data-set">
                    <h1 class="minortitle">Paypal Account</h1>
                </div>

                <c:choose>
                    <c:when test="${not empty userModel.paymentInformation.paypalUsername}">
                        <div class="profile-data-set">
                            <h3>Paypal Username: ${userModel.paymentInformation.paypalUsername}</h3>
                            <span><a>edit</a></span>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="profile-data-set">
                            <h3>You have not yet added a Paypal Account.</h3>
                            <span><a>Add a Paypal Account</a></span>
                        </div>
                    </c:otherwise>
                </c:choose>

                <div class="profile-data-set">
                    <h1 class="minortitle">Card Details</h1>
                </div>

                <c:choose>
                    <c:when test="${not empty userModel.paymentInformation.cardNumber}">
                        <c:set var="cardNumber" value="${userModel.paymentInformation.cardNumber}"/>
                        <div class="profile-data-set">
                            <h3>Cardholder
                                Name: ${userModel.paymentInformation.cardHolderName}</h3>
                        </div>
                        <div class="profile-data-set">
                            <h3>Card Number: ************${fn:substring(cardNumber, 12, 16)}</h3>
                        </div>
                        <div class="profile-data-set">
                            <h3>Expiration Date:  ${userModel.paymentInformation.expirationMonth}
                                /${userModel.paymentInformation.expirationYear}</h3>
                            <span><a>edit</a></span>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="profile-data-set">
                            <h3>You have not yet added Card Payment Information</h3>
                            <span><a>Add a New Card</a></span>
                        </div>
                    </c:otherwise>
                </c:choose>

                <div class="profile-data-set">
                    <h1 class="title">Trading Accounts</h1>
                </div>
            </div>

            <div class="profile-img-container">
                <img width="100%" src="<c:url value="/resources/img/dancer.jpg"/>">
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>