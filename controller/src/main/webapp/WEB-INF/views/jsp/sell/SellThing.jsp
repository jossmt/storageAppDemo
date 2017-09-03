<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>


<link href="<c:url value="/resources/css/Sell.css" />" rel="stylesheet">

<!--Icon Fonts - Font Awesome Icons-->
<link href="<c:url value="/resources/css/home/namari-font-awesome.min.css" />" rel="stylesheet">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <form:form id="msform" method="post" enctype="multipart/form-data" modelAttribute="sellItem"
                   action="${pageContext.servletContext.contextPath}/sell">

            <!-- progressbar -->
            <ul id="progressbar">
                <li class="active">Item Details</li>
                <li>Trading Accounts</li>
                <li>Address</li>
            </ul>

            <fieldset>
                <h2 class="fs-title">Sell an item</h2>
                <h3 class="fs-subtitle">Fill in the fields below</h3>
                <div id="imagewrapper">
                    <i id="imageIcon" class="fa fa-file-image-o fa-5x" aria-hidden="true"></i>
                </div>
                <img id="imageRender" src="#" width="100%" hidden/>
                <input type="file" name="file" onchange="readFileUrl(this)"/>
                <form:textarea path="storageItem.description" type="text" name="description"
                               placeholder="Item Description..."/>
                <form:input path="storageItem.brand" type="text" name="brand" placeholder="Brand"/>
                <form:input path="storageItem.size" type="text" name="size" placeholder="Size (If Applicable)"/>
                <form:input path="storageItem.grade" type="text" name="grade" placeholder="Grade of item (A-F)"/>
                <form:input path="storageItem.price" type="text" name="price" placeholder="Price"/>
                <input type="button" name="next" class="next action-button" value="Next"/>
            </fieldset>
            <fieldset>
                <h2 class="fs-title">Trading Accounts</h2>
                <h3 class="fs-subtitle">Where would you like this listing posted</h3>
                <jstl:choose>
                    <jstl:when test="${empty tradingAccounts}">
                        <h3>You have not yet set up any other trading accounts.</h3>
                    </jstl:when>
                    <jstl:otherwise>
                        <jstl:forEach items="${tradingAccounts}" var="tradingAccount" varStatus="theCount">
                            <form:checkbox path="tradingAccounts"
                                           value="${tradingAccount.accountType}"/>${tradingAccount.accountType}
                        </jstl:forEach>
                    </jstl:otherwise>
                </jstl:choose>
                <input type="button" name="previous" class="previous action-button" value="Previous"/>
                <input type="button" name="next" class="next action-button" value="Next"/>
            </fieldset>
            <fieldset>
                <h2 class="fs-title">Payment Options</h2>
                <h3 class="fs-subtitle">Preferred Method of Payment Receipt</h3>
                <div class="paymentOptions">
                    <label><form:radiobutton path="paymentType" title="Paypal" value="true"/>Paypal</label>
                    <label><form:radiobutton path="paymentType" title="Cash on Collection" value="false"/>
                        Cash on Collection </label>
                </div>
                <input type="submit" name="submit" class="submit action-button" value="Submit"/>
            </fieldset>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>