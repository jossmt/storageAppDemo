<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value="/resources/css/Storage.css" />" rel="stylesheet">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <c:forEach items="${storageItems}" var="item" varStatus="theCount">
            <div class="list-container">
                <div class="flip-container" ontouchstart="this.classList.toggle('hover');">
                    <div class="flipper">
                        <div class="front">
                            <!-- front content -->
                            <span class="logoWrapper">
                    <img id="img" height="200px" width="150px"
                         src="http://www.mountain-equipment.co.uk/pub/media/catalog/product/cache/75eed2686e01eb22cb4050b2f40ddf97/m/e/me_frontier_hooded_jacket_mens_marine_1.jpg"
                         alt='icon'></span>
                        </div>
                        <div class="back">
                            <c:out value="Name: ${item.name}"/><br />
                            <c:out value="Size: ${item.size}"/><br />
                            <!-- back content -->
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </tiles:putAttribute>
</tiles:insertDefinition>