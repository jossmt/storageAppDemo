<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>


    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <!-- Scripts -->
    <script src="<spring:url value="/resources/js/main.js"/>"></script>
    <script src="<spring:url value="/resources/js/jquery-ui.min.js"/>"></script>
    <link href="<c:url value="/resources/css/SignupNew.css" />" rel="stylesheet">
</head>

<body>
<!-- multistep form -->
<form:form id="msform" method="post">
    <!-- progressbar -->
    <ul id="progressbar">
        <li class="active">Account Setup</li>
        <li>Social Profiles</li>
        <li>Personal Details</li>
        <li>Payment</li>
    </ul>
    <!-- fieldsets -->
    <fieldset>
        <h2 class="fs-title">Create your account</h2>
        <h3 class="fs-subtitle">This is step 1</h3>

        <form:input path="user.email" type="text" name="email" placeholder="Email" />
        <input type="password" name="pass" placeholder="Password" />
        <input type="password" name="cpass" placeholder="Confirm Password" />
        <input type="button" name="next" class="next action-button" value="Next" />
    </fieldset>
    <fieldset>
        <h2 class="fs-title">Trading Accounts</h2>
        <h3 class="fs-subtitle">Add your intended selling platforms</h3>
        <input type="text" name="amazon" placeholder="Amazon Account Name" />
        <input type="text" name="ebay" placeholder="Ebay Account Name" />
        <input type="text" name="craigslist" placeholder="Craigslist Account Name" />
        <input type="button" name="previous" class="previous action-button" value="Previous" />
        <input type="button" name="next" class="next action-button" value="Next" />
    </fieldset>
    <fieldset>
        <h2 class="fs-title">Personal Details</h2>
        <h3 class="fs-subtitle">We will never sell it</h3>
        <input type="text" name="fname" placeholder="First Name" />
        <input type="text" name="lname" placeholder="Last Name" />
        <textarea name="address" placeholder="Address"></textarea>
        <input type="text" name="region" placeholder="Region" />
        <input type="text" name="postcode" placeholder="Postcode" />
        <input type="text" name="country" placeholder="Country" />
        <input type="button" name="previous" class="previous action-button" value="Previous" />
        <input type="button" name="next" class="next action-button" value="Next" />
    </fieldset>
    <fieldset>
        <h2 class="fs-title">Payment Information</h2>
        <h3 class="fs-subtitle">For payments and subscriptions</h3>
        <input type="text" name="cardholdername" placeholder="Card Holder Name" />
        <input type="text" name="cardnumber" placeholder="Card Number" />
        <input type="text" name="cvv" placeholder="CVV" />
        <input type="text" name="expmonth" placeholder="Expiration Month e.g. Feb" />
        <input type="text" name="expyear" placeholder="Expiration year e.g. 2019" />
        <input type="button" name="previous" class="previous action-button" value="Previous" />
        <input type="submit" name="submit" class="submit action-button" value="Submit" />
    </fieldset>
</form:form>
</body>