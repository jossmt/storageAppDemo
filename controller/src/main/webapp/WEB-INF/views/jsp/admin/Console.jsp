<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link href="<c:url value="/resources/css/Home.css" />" rel="stylesheet">

<link rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Bellefair">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <form:form method="POST" modelAttribute="itemListing" enctype="multipart/form-data">
            <div class="imgcontainer">
                <img src="https://www.w3schools.com/howto/img_avatar2.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">

                <label><b>Email</b></label>
                <input type="text" placeholder="Enter User Email" name="userEmail" required>

                <label><b>Brand</b></label>
                <spring:bind path="brand">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="brand" class="form-control" placeholder="Enter Brand"
                                    autofocus="true"></form:input>
                        <form:errors path="brand"></form:errors>
                    </div>
                </spring:bind>

                <label><b>Size</b></label>
                <spring:bind path="size">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="size" class="form-control" placeholder="Enter Size"
                                    autofocus="true"></form:input>
                        <form:errors path="size"></form:errors>
                    </div>
                </spring:bind>

                <label><b>Description</b></label>
                <spring:bind path="description">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="description" class="form-control" placeholder="Enter Description"
                                    autofocus="true"></form:input>
                        <form:errors path="description"></form:errors>
                    </div>
                </spring:bind>

                <label><b>Grade</b></label>
                <spring:bind path="grade">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="grade" class="form-control" placeholder="Enter Grade"
                                    autofocus="true"></form:input>
                        <form:errors path="grade"></form:errors>
                    </div>
                </spring:bind>

                <label>File to upload:</label>
                <input type="file" name="file">


                <button type="submit">Upload data</button>
            </div>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>