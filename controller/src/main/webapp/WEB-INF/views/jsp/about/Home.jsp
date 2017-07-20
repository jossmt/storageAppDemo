<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<link href="<c:url value="/resources/css/Home.css" />" rel="stylesheet">

<link rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Bellefair">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div id="home">

            <div class="section-1">
                <h2 id="sect-1-text">Storage made <br/> smarter...</h2>
                <img id="sect-1-img" src="https://static.pexels.com/photos/334979/pexels-photo-334979.jpeg"/>
            </div>

            <div class="section-2">

                <div id=sect-2-text-container>
                    <h2 id=sect-2-text>Store your clothing at the click of a button.<br/><br/> It's Simple. Send in your
                        items... <br/><br/>We'll take a picture of each of your individually stored items. <br/><br/>Once
                        uploaded, you will be able to visualise your wardrobe. <br/><br/> Design your own outfits, sell
                        your outdated clothing or order items home with same day delivery.</h2>
                </div>
                <img id="sect-2-img" src="http://68.media.tumblr.com/tumblr_mdaiedNw8n1r5rtmy.jpg"/>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>