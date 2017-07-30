<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href="<c:url value="/resources/css/Login.css" />" rel="stylesheet">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <form:form method="POST">
            <div class="imgcontainer">
                <img src="https://www.w3schools.com/howto/img_avatar2.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">

                <label><b>Email</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>

                <label><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>

                <button type="submit">Log in</button>
                <input type="checkbox" checked="checked"> Remember me
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" class="cancelbtn">Cancel</button>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>