<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<link href="<c:url value="/resources/css/Home.css" />" rel="stylesheet">

<link rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Bellefair">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="homecontainer">
            <div class="info">
                <img height=500px width=100%
                     src="${pageContext.request.contextPath}/resources/img/handimage.jpeg"/>

                <div class="description">
                    <p class="description_content">Use the <span style="color:#c17cdb">discover</span> option to
                        see what we have to offer.
                        <br/><br/><br/>
                        Or make use of any of our services: <span style="color:#00fa9a">We collect. </span>
                        <span style="color:#c17cdb">We sell.</span>
                        <span style="color:deepskyblue">You earn.</span>
                    </p>
                </div>
            </div>

            <div id="mission" class="mission">

                <img height=600px width=100% src="${pageContext.request.contextPath}/resources/img/BrickWall.jpg"/>

                <div class="mission_content">
                    <h1><span class="fade">- Our Mission -</span></h1>
                    <p>
                        <span class="fade">Here at description our aim is to make buying and selling that bit easier by doing
                        the hard work for you. By collecting, valuing and listing your items for you, we take all the
                        strain off your hands - so you can focus on more important things. </span>
                        <br/>-------<br/>
                        <span class="fade">Not here to sell?<br/>Discover what items we have listed. </span>
                        <br/>-------<br/>
                        <span class="fade">After all, one man's junk is another man'streasure.</span></p>
                </div>
            </div>

            <div id="howitworks" class="howitworks">

                <div class="gride">
                    <p>1. Book a collection<br/>date online</p>
                </div>
                <div class="grida">
                    <img height=70% width=70% src="${pageContext.request.contextPath}/resources/img/VanIcon.png"/>
                </div>
                <div class="gridg">
                    <p>3.<br/> Login with your user<br/> details and see<br/> your items listed</p>
                </div>
                <div class="gridf">
                    <img height=70% width=70%
                         src="${pageContext.request.contextPath}/resources/img/CameraIcon.png"/>
                </div>
                <div></div>
                <div class="gridj">

                    <p>2.<br/> We'll capture, upload<br/>and safely store your<br/>items</p>
                </div>
                <div class="gridc">
                    <img height=70% width=70%
                         src="${pageContext.request.contextPath}/resources/img/LaptopIcon.png"/>
                </div>
                <div class="gridl">
                    <p>4. Sit back and relax<br/>while we sell<br/>your items</p>
                </div>
                <div class="gridh">
                    <img height=70% width=70%
                         src="${pageContext.request.contextPath}/resources/img/MoneyBagIcon.png"/>
                </div>

            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>