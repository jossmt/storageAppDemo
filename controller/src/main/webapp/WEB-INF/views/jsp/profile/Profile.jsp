<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<link href="<c:url value="/resources/css/Profile.css" />" rel="stylesheet">
<sec:authorize var="loggedIn" access="isAuthenticated()"/>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <div class="profile-container">

            <div class="profile-data">

                <p class="grida">Full Name: ${userModel.firstName} ${userModel.lastName}</p>
                <p class="gridb">edit</p>
                <p class="gridc">Email: ${userModel.email}</p>
                <p class="gridd">edit</p>
                <p class="gride">Region: ${userModel.address.region}</p>
                <p class="gridf">edit</p>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>