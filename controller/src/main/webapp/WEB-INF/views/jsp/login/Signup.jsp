<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href="<c:url value="/resources/css/Signup.css" />" rel="stylesheet">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <form:form method="POST" modelAttribute="userForm">
            <div class="imgcontainer">
                <img src="https://www.w3schools.com/howto/img_avatar2.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">

                <label><b>First Name</b></label>
                <spring:bind path="firstName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="firstName" class="form-control" placeholder="Enter First Name"
                                    autofocus="true"></form:input>
                        <form:errors path="firstName"></form:errors>
                    </div>
                </spring:bind>

                <label><b>Last Name</b></label>
                <spring:bind path="lastName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="lastName" class="form-control" placeholder="Enter Last Name"
                                    autofocus="true"></form:input>
                        <form:errors path="lastName"></form:errors>
                    </div>
                </spring:bind>

                <label><b>Email</b></label>
                <spring:bind path="email">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="email" class="form-control" placeholder="Enter Email"
                                    autofocus="true"></form:input>
                        <form:errors path="email"></form:errors>
                    </div>
                </spring:bind>

                <label><b>Password</b></label>
                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="password" class="form-control" placeholder="Enter Password"
                                    autofocus="true"></form:input>
                        <form:errors path="password"></form:errors>
                    </div>
                </spring:bind>

                <label><b>Re-Enter Password</b></label>
                <spring:bind path="passwordConfirm">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="passwordConfirm" class="form-control"
                                    placeholder="Re-Enter Password"
                                    autofocus="true"></form:input>
                        <form:errors path="passwordConfirm"></form:errors>
                    </div>
                </spring:bind>

                <button type="submit">Sign Up</button>
                <input type="checkbox" checked="checked"> Remember me
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" class="cancelbtn">Cancel</button>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>