<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link href="<c:url value="/resources/css/Sell.css" />" rel="stylesheet">

<!--Icon Fonts - Font Awesome Icons-->
<link href="<c:url value="/resources/css/home/namari-font-awesome.min.css" />" rel="stylesheet">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <form:form id="msform" method="post" modelAttribute="sellItem"
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
                <input type="file" name="file" onchange="readFileUrl(this)" />
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
                <input type="button" name="previous" class="previous action-button" value="Previous"/>
                <input type="button" name="next" class="next action-button" value="Next"/>
            </fieldset>
            <fieldset>
                <h2 class="fs-title">Personal Details</h2>
                <h3 class="fs-subtitle">We will never sell it</h3>
                <form:textarea path="address.streetAddress" name="address" placeholder="Address"/>
                <form:input path="address.region" type="text" name="region" placeholder="Region"/>
                <form:input path="address.postcode" type="text" name="postcode" placeholder="Postcode"/>
                <form:input path="address.countryName" type="text" name="country" placeholder="Country"/>
                <form:input path="address.addressType" type="hidden" name="addressType" value="DELIVERY"/>
                <input type="submit" name="submit" class="submit action-button" value="Submit"/>
            </fieldset>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>