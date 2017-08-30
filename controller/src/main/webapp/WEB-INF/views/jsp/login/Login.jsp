<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href="<c:url value="/resources/css/SignupNew.css" />" rel="stylesheet">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <form:form id="msform" method="post" modelAttribute="userForm"
                   action="${pageContext.servletContext.contextPath}/login">

            <fieldset>
                <h2 class="fs-title">ENTER LOGIN DETAILS</h2>
                <h3 class="fs-subtitle">Or sign up now</h3>
                <form:input path="email" type="text" name="email" placeholder="Email" />
                <form:input path="password" type="password" name="pass" placeholder="Password" />
                <input type="submit" name="submit" class="submit action-button" value="Submit" />
            </fieldset>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>