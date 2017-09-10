<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href="<c:url value="/resources/css/Signup.css" />" rel="stylesheet">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <form:form id="msform" method="post">

            <fieldset>
                <h2 class="fs-title">ENTER LOGIN DETAILS</h2>
                <h3 class="fs-subtitle">Or sign up now</h3>
                <input type="text" placeholder="Enter Username" name="username" required>
                <input type="password" placeholder="Enter Password" name="password" required>
                <input type="submit" name="submit" class="submit action-button" value="Login" />
            </fieldset>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>