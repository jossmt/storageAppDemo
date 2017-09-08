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
                    <span><a id="namepopup" class="popupbutton">edit</a></span>
                </div>

                <form:form method="post" action="${pageContext.servletContext.contextPath}/profile/edit/name">
                    <div id="namepopupwrapper" class="popup" hidden>
                        <span id="namepopuptext" class="popuptext" hidden>
                            <fieldset class="modaldata">
                                <h2 class="fs-title">UPDATE NAME</h2>
                                <h3 class="fs-subtitle">Set new full name</h3>
                                <input type="text" placeholder="Enter First Name" name="fname" required>
                                <input type="text" placeholder="Enter Last Name" name="lname" required>
                                <input type="button" name="cancel" class="cancel action-button" value="Cancel"/>
                                <input type="submit" name="submit" class="submit action-button" value="Submit"/>
                            </fieldset>
                        </span>
                    </div>
                </form:form>

                <div class="profile-data-set">
                    <h3>Email: ${userModel.email}</h3>
                    <span><a id="emailpopup" class="popupbutton">edit</a></span>
                </div>

                <form:form method="post" action="${pageContext.servletContext.contextPath}/profile/edit/email">
                    <div id="emailpopupwrapper" class="popup" hidden>
                        <span id="emailpopuptext" class="popuptext" hidden>
                            <fieldset class="modaldata">
                                <h2 class="fs-title">UPDATE EMAIL</h2>
                                <h3 class="fs-subtitle">Set new email</h3>
                                <input type="text" placeholder="Email" name="email" required>
                                <input type="password" placeholder="Verify Password" name="password" required>
                                <input type="button" name="cancel" class="cancel action-button" value="Cancel"/>
                                <input type="submit" name="submit" class="submit action-button" value="Submit"/>
                            </fieldset>
                        </span>
                    </div>
                </form:form>

                <div class="profile-data-set">
                    <h3>Password: *******</h3>
                    <span><a id="passwordpopup" class="popupbutton">edit</a></span>
                </div>

                <form:form method="post" action="${pageContext.servletContext.contextPath}/profile/edit/password">
                    <div id="passwordpopupwrapper" class="popup" hidden>
                        <span id="passwordpopuptext" class="popuptext" hidden>
                            <fieldset class="modaldata">
                                <h2 class="fs-title">UPDATE PASSWORD</h2>
                                <h3 class="fs-subtitle">Set new password</h3>
                                <input type="password" placeholder="Enter Password" name="password" required>
                                <input type="password" placeholder="Confirm Password" name="passwordConfirm" required>
                                <input type="button" name="cancel" class="cancel action-button" value="Cancel"/>
                                <input type="submit" name="submit" class="submit action-button" value="Submit"/>
                            </fieldset>
                        </span>
                    </div>
                </form:form>

                <div class="clear"></div>

                <div class="profile-data-set">
                    <h1 class="title">Address Information</h1>
                </div>
                <div class="profile-data-set">
                    <h1 class="minortitle">Billing Address</h1>
                </div>

                <div class="profile-data-set">
                    <c:set var="existsBilling" value="false" scope="session"/>
                    <c:forEach items="${userModel.addressList}" var="address" varStatus="theCount">
                        <c:choose>
                            <c:when test="${address.addressType == 'BILLING'}">
                                <div class="profile-data-set">
                                    <h3>Street Address: ${address.streetAddress}</h3>
                                </div>
                                <div class="profile-data-set">
                                    <h3>PostCode: ${address.postcode}</h3>
                                </div>
                                <div class="profile-data-set">
                                    <h3>Region: ${address.region}</h3>
                                </div>
                                <div class="profile-data-set">
                                    <h3>Country Name: ${address.countryName}</h3>
                                </div>
                                <c:set var="existsBilling" value="true" scope="session"/>
                            </c:when>
                            <c:otherwise/>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${not existsBilling}">
                            <h3>You have not yet added a Billing Address.</h3>
                        </c:when>
                        <c:otherwise/>
                    </c:choose>
                    <span><a id="baddresspopup" class="popupbutton">Update Billing Address</a></span>
                </div>

                <form:form method="post" action="${pageContext.servletContext.contextPath}/profile/edit/address">
                    <div id="baddresspopupwrapper" class="popup" hidden>
                        <span id="baddresspopuptext" class="popuptext" hidden>
                            <fieldset class="modaldata">
                                <h2 class="fs-title">UPDATE BILLING ADDRESS</h2>
                                <h3 class="fs-subtitle">Set new billing address</h3>
                                <input type="text" placeholder="Enter Street Address" name="streetAddress"
                                       required>
                                <input type="text" placeholder="Enter Postcode" name="postcode" required>
                                <input type="text" placeholder="Enter Region" name="region" required>
                                <input type="text" placeholder="Enter Country" name="country" required>
                                <input type="text" name="addressType" value="BILLING" hidden>
                                <input type="button" name="cancel" class="cancel action-button"
                                       value="Cancel"/>
                                <input type="submit" name="submit" class="submit action-button"
                                       value="Submit"/>
                            </fieldset>
                        </span>
                    </div>
                </form:form>

                <div class="profile-data-set">
                    <h1 class="minortitle">Delivery Address</h1>
                </div>

                <div class="profile-data-set">
                    <c:set var="existsDelivery" value="false" scope="session"/>
                    <c:forEach items="${userModel.addressList}" var="address" varStatus="theCount">
                        <c:choose>
                            <c:when test="${address.addressType == 'DELIVERY'}">
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
                                </div>

                                <c:set var="existsDelivery" value="true" scope="session"/>
                            </c:when>
                            <c:otherwise/>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${not existsDelivery}">
                            <h3>You have not yet added a Delivery Address.</h3>
                        </c:when>
                        <c:otherwise/>
                    </c:choose>
                    <span><a id="daddresspopup" class="popupbutton">Update Delivery Address</a></span>
                </div>


                <form:form method="post" action="${pageContext.servletContext.contextPath}/profile/edit/address">
                    <div id="daddresspopupwrapper" class="popup" hidden>
                        <span id="daddresspopuptext" class="popuptext" hidden>
                            <fieldset class="modaldata">
                                <h2 class="fs-title">UPDATE DELIVERY ADDRESS</h2>
                                <h3 class="fs-subtitle">Set new delivery address</h3>
                                <input type="text" placeholder="Enter Street Address" name="streetAddress"
                                       required>
                                <input type="text" placeholder="Enter Postcode" name="postcode" required>
                                <input type="text" placeholder="Enter Region" name="region" required>
                                <input type="text" placeholder="Enter Country" name="country" required>
                                <input type="text" name="addressType" value="DELIVERY" hidden>
                                <input type="button" name="cancel" class="cancel action-button"
                                       value="Cancel"/>
                                <input type="submit" name="submit" class="submit action-button"
                                       value="Submit"/>
                            </fieldset>
                        </span>
                    </div>
                </form:form>

                <div class="profile-data-set">
                    <h1 class="title">Payment Information</h1>
                </div>

                <div class="profile-data-set">
                    <h1 class="minortitle">Paypal Account</h1>
                </div>

                <div class="profile-data-set">
                    <c:choose>
                        <c:when test="${not empty userModel.paymentInformation.paypalUsername}">
                            <h3>Paypal Username: ${userModel.paymentInformation.paypalUsername}</h3>
                        </c:when>
                        <c:otherwise>
                            <h3>You have not yet added a Paypal Account.</h3>
                        </c:otherwise>
                    </c:choose>
                    <span><a id="paypalpopup" class="popupbutton">edit</a></span>
                </div>


                <form:form method="post" action="${pageContext.servletContext.contextPath}/profile/edit/paypal">
                    <div id="paypalpopupwrapper" class="popup" hidden>
                        <span id="paypalpopuptext" class="popuptext" hidden>
                            <fieldset class="modaldata">
                                <h2 class="fs-title">UPDATE PAYPAL USERNAME</h2>
                                <h3 class="fs-subtitle">Set new paypal username</h3>
                                <input type="text" placeholder="Enter Paypal Username" name="paypalUsername" required>
                                <input type="button" name="cancel" class="cancel action-button" value="Cancel"/>
                                <input type="submit" name="submit" class="submit action-button" value="Submit"/>
                            </fieldset>
                        </span>
                    </div>
                </form:form>

                <div class="profile-data-set">
                    <h1 class="minortitle">Card Details</h1>
                </div>

                <div class="profile-data-set">
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
                                <h3>Expiration Date: ${userModel.paymentInformation.expirationMonth}
                                    /${userModel.paymentInformation.expirationYear}</h3>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <h3>You have not yet added Card Payment Information</h3>
                        </c:otherwise>
                    </c:choose>
                    <span><a id="cardpopup" class="popupbutton">Update Card</a></span>
                </div>

                <form:form method="post" action="${pageContext.servletContext.contextPath}/profile/edit/card">
                    <div id="cardpopupwrapper" class="popup" hidden>
                        <span id="cardpopuptext" class="popuptext" hidden>
                            <fieldset class="modaldata">
                                <h2 class="fs-title">UPDATE PAYMENT INFORMATION</h2>
                                <h3 class="fs-subtitle">Set new card details</h3>
                                <h3 class="fs-subtitle-left">Select Card Type:</h3>
                                <select name="cardType">
                                    <c:forEach items="${cardTypes}" var="cardType">
                                        <option value="${cardType}">
                                                ${cardType}
                                        </option>
                                    </c:forEach>
                                </select>
                                <input type="text" name="cardHolderName" placeholder="Card Holder Name"/>
                                <input type="text" name="cardNumber" placeholder="Card Number"/>
                                <input type="text" name="cvv" placeholder="CVV"/>
                                <input type="text" name="expMonth" placeholder="Expiration Month e.g. Feb"/>
                                <input type="text" name="expYear" placeholder="Expiration year e.g. 2019"/>
                                <input type="button" name="cancel" class="cancel action-button" value="Cancel"/>
                                <input type="submit" name="submit" class="submit action-button" value="Submit"/>
                            </fieldset>
                        </span>
                    </div>
                </form:form>

                <div class="profile-data-set">
                    <h1 class="title">Trading Accounts</h1>
                </div>

                <div class="profile-data-set final">
                    <c:choose>
                        <c:when test="${not empty userModel.tradingAccounts}">

                        </c:when>
                        <c:otherwise>
                            <h3>You have not yet added any Trading Accounts</h3>
                        </c:otherwise>
                    </c:choose>
                    <span><a id="tradeaccountpopup" class="popupbutton">Add a Trading Account</a></span>
                </div>

            </div>

            <div class="profile-img-container">
                <img width="100%" src="<c:url value="/resources/img/dancer.jpg"/>">
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>