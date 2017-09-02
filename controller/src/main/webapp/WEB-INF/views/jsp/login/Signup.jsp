<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href="<c:url value="/resources/css/Signup.css" />" rel="stylesheet">


<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <!-- multistep form -->
        <form:form id="msform" method="post" modelAttribute="userForm"
                   action="${pageContext.servletContext.contextPath}/signup">
            <!-- progressbar -->
            <ul id="progressbar">
                <li class="active">Account Setup</li>
                <li>Personal Details</li>
                <li>Payment</li>
            </ul>
            <!-- fieldsets -->
            <fieldset>
                <h2 class="fs-title">Create your account</h2>
                <h3 class="fs-subtitle">This is step 1</h3>

                <form:input path="email" type="text" name="username" placeholder="Email"/>
                <form:input path="password" type="password" name="pass" placeholder="Password"/>
                <form:input path="passwordConfirm" type="password" name="cpass" placeholder="Confirm Password"/>
                <input type="button" name="next" class="next action-button" value="Next"/>
            </fieldset>
            <fieldset>
                <h2 class="fs-title">Personal Details</h2>
                <h3 class="fs-subtitle">We will never sell it</h3>
                <form:input path="firstName" type="text" name="firstName" placeholder="First Name"/>
                <form:input path="lastName" type="text" name="lastName" placeholder="Last Name"/>
                <form:textarea path="address.streetAddress" name="address" placeholder="Address"/>
                <form:input path="address.region" type="text" name="region" placeholder="Region"/>
                <form:input path="address.postcode" type="text" name="postcode" placeholder="Postcode"/>
                <form:input path="address.countryName" type="text" name="country" placeholder="Country"/>
                <input type="button" name="previous" class="previous action-button" value="Previous"/>
                <input type="button" name="next" class="next action-button" value="Next"/>
            </fieldset>
            <fieldset>
                <h2 class="fs-title">Payment Information</h2>
                <h3 class="fs-subtitle">For payments and subscriptions</h3>
                <form:input path="paymentDetails[0].cardHolderName" type="text" name="cardholdername"
                            placeholder="Card Holder Name"/>
                <form:input path="paymentDetails[0].cardNumber" type="text" name="cardnumber"
                            placeholder="Card Number"/>
                <form:input path="paymentDetails[0].cvvValue" type="text" name="cvv" placeholder="CVV"/>
                <form:input path="paymentDetails[0].expirationMonth" type="text" name="expmonth"
                            placeholder="Expiration Month e.g. Feb"/>
                <form:input path="paymentDetails[0].expirationYear" type="text" name="expyear"
                            placeholder="Expiration year e.g. 2019"/>
                <input type="button" name="previous" class="previous action-button" value="Previous"/>
                <input type="submit" name="submit" class="submit action-button" value="Submit"/>
            </fieldset>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>