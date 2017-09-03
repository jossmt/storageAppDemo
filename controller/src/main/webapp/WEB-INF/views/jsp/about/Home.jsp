<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<head lang="en">
    <meta charset="UTF-8">

    <!--Meta Keywords and Description-->
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>

    <!--Favicon-->
    <link href="<c:url value="/resources/img/favicon.ico" />" rel="stylesheet">

    <!-- Main CSS Files -->
    <link href="<c:url value="/resources/css/home/style.css" />" rel="stylesheet">

    <!-- Namari Color CSS -->
    <link href="<c:url value="/resources/css/home/namari-color.css" />" rel="stylesheet">

    <!--Icon Fonts - Font Awesome Icons-->
    <link href="<c:url value="/resources/css/home/namari-font-awesome.min.css" />" rel="stylesheet">

    <!-- Animate CSS-->
    <link href="<c:url value="/resources/css/home/animate.css" />" rel="stylesheet" type="text/css">

    <!--Google Webfonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet'
          type='text/css'>
</head>


<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <!-- Preloader -->
        <div id="preloader">
            <div id="status" class="la-ball-triangle-path">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <!--End of Preloader-->

        <div id="wrapper">

            <header id="banner" class="scrollto clearfix" data-enllax-ratio=".5">

                <!--Banner Content-->
                <div id="banner-content" class="row clearfix">

                    <div class="col-38">

                        <div class="section-heading">
                            <h1>A SIMPLE SELLING SITE WITH A TWIST</h1>
                            <h2>Namari is a commercial selling software that boosts your chances of selling online by
                                automating the process for you!</h2>
                        </div>

                        <!--Call to Action-->
                        <a href="${pageContext.servletContext.contextPath}/sell" class="button">START SELLING TODAY</a>
                        <!--End Call to Action-->

                    </div>

                </div><!--End of Row-->
            </header>

            <!--Main Content Area-->
            <main id="content">

                <!--Introduction-->
                <section id="about" class="introduction scrollto">

                    <div class="row clearfix">

                        <div class="col-3">
                            <div class="section-heading">
                                <h3>SUCCESS</h3>
                                <h2 class="section-title">How We Help You To Sell Your Product</h2>
                                <p class="section-subtitle">By integrating with all of your individual trading accounts
                                    we help post, monitor and sell your items for you!</p>
                            </div>

                        </div>

                        <div class="col-2-3">

                            <!--Icon Block-->
                            <div class="col-2 icon-block icon-top wow fadeInUp" data-wow-delay="0.1s">
                                <!--Icon-->
                                <div class="icon">
                                    <i class="fa fa-html5 fa-2x"></i>
                                </div>
                                <!--Icon Block Description-->
                                <div class="icon-block-description">
                                    <h4>Automated Posting</h4>
                                    <p>Post your listing once and never again. We'll replicate the listing elsewhere for
                                        you.</p>
                                </div>
                            </div>
                            <!--End of Icon Block-->

                            <!--Icon Block-->
                            <div class="col-2 icon-block icon-top wow fadeInUp" data-wow-delay="0.3s">
                                <!--Icon-->
                                <div class="icon">
                                    <i class="fa fa-bolt fa-2x"></i>
                                </div>
                                <!--Icon Block Description-->
                                <div class="icon-block-description">
                                    <h4>Monitoring</h4>
                                    <p>Once live all your listings will be monitored and readily available for you to
                                        see. We will monitor any changes within a split second.</p>
                                </div>
                            </div>
                            <!--End of Icon Block-->

                            <!--Icon Block-->
                            <div class="col-2 icon-block icon-top wow fadeInUp" data-wow-delay="0.5s">
                                <!--Icon-->
                                <div class="icon">
                                    <i class="fa fa-tablet fa-2x"></i>
                                </div>
                                <!--Icon Block Description-->
                                <div class="icon-block-description">
                                    <h4>Auto Sell</h4>
                                    <p>Our auto sell function will immediately unlist your product from all other sites
                                        the second it is bought.</p>
                                </div>
                            </div>
                            <!--End of Icon Block-->

                            <!--Icon Block-->
                            <div class="col-2 icon-block icon-top wow fadeInUp" data-wow-delay="0.5s">
                                <!--Icon-->
                                <div class="icon">
                                    <i class="fa fa-rocket fa-2x"></i>
                                </div>
                                <!--Icon Block Description-->
                                <div class="icon-block-description">
                                    <h4>Sell Quickly</h4>
                                    <p>By listing your product on a greater range of selling sites, including our own,
                                        you improve the visibility of your item in the online community.</p>
                                </div>
                            </div>
                            <!--End of Icon Block-->

                        </div>

                    </div>


                </section>
                <!--End of Introduction-->


                <!--Gallery-->
                <aside id="gallery" class="row text-center scrollto clearfix" data-featherlight-gallery
                       data-featherlight-filter="a">

                    <a id="gal1" href="<c:url value="/resources/img/gallery-images/gallery-image-1.jpg" />"
                       data-featherlight="image"
                       class="col-3 wow fadeIn"
                       data-wow-delay="0.1s"><img
                            src="<c:url value="/resources/img/gallery-images/gallery-image-1.jpg"/>"
                            alt=" Landing Page"/></a>
                    <a id="gal2" href="<c:url value="/resources/img/gallery-images/gallery-image-2.jpg"/>"
                       data-featherlight="image"
                       class="col-3 wow fadeIn"
                       data-wow-delay="0.3s"><img
                            src="<c:url value="/resources/img/gallery-images/gallery-image-2.jpg"/>"
                            alt="Landing Page"/></a>
                    <a id="gal3" href="<c:url value="/resources/img/gallery-images/gallery-image-3.jpg"/>"
                       data-featherlight="image"
                       class="col-3 wow fadeIn"
                       data-wow-delay="0.5s"><img
                            src="<c:url value="/resources/img/gallery-images/gallery-image-3.jpg"/>"
                            alt="Landing Page"/></a>
                    <a id="gal4" href="<c:url value="/resources/img/gallery-images/gallery-image-4.jpg"/>"
                       data-featherlight="image"
                       class="col-3 wow fadeIn"
                       data-wow-delay="1.1s"><img
                            src="<c:url value="/resources/img/gallery-images/gallery-image-4.jpg"/>"
                            alt="Landing Page"/></a>
                    <a id="gal5" href="<c:url value="/resources/img/gallery-images/gallery-image-4.jpg"/>"
                       data-featherlight="image"
                       class="col-3 wow fadeIn"
                       data-wow-delay="0.9s"><img
                            src="<c:url value="/resources/img/gallery-images/gallery-image-5.jpg"/>"
                            alt="Landing Page"/></a>
                    <a id="gal6" href="<c:url value="/resources/img/gallery-images/gallery-image-6.jpg"/>"
                       data-featherlight="image"
                       class="col-3 wow fadeIn"
                       data-wow-delay="0.7s"><img
                            src="<c:url value="/resources/img/gallery-images/gallery-image-6.jpg"/>"
                            alt="Landing Page"/></a>

                </aside>
                <!--End of Gallery-->

                <!--Testimonials-->
                <aside id="testimonials" class="scrollto text-center" data-enllax-ratio=".2">

                    <div class="row clearfix">

                        <div class="section-heading">
                            <h3>FEEDBACK</h3>
                            <h2 class="section-title">What our customers are saying</h2>
                        </div>

                        <!--User Testimonial-->
                        <blockquote class="col-3 testimonial classic">
                            <img src="<c:url value="/resources/img/user-images/user-1.jpg"/>" alt="User"/>
                            <q>When we heard about Namari we knew we had to give it a try. we spend a lot of time
                                selling our stuff online and this makes it quicker and simpler.</q>
                            <footer>Perli & Richard - Happy Customer</footer>
                        </blockquote>
                        <!-- End of Testimonial-->

                        <!--User Testimonial-->
                        <blockquote class="col-3 testimonial classic">
                            <img src="<c:url value="/resources/img/user-images/user-2.jpg"/>" alt="User"/>
                            <q>I like that Namari takes a hands off approach. This way I can handle what matters and let
                                them take charge of the boring stuff.</q>
                            <footer>Thomas Riordan - Happy Customer</footer>
                        </blockquote>
                        <!-- End of Testimonial-->

                        <!--User Testimonial-->
                        <blockquote class="col-3 testimonial classic">
                            <img src="<c:url value="/resources/img/user-images/user-3.jpg"/>" alt="User"/>
                            <q>I love Namari. My business relies on selling our products online. Using Namari I was able
                                to reduce man hours significantly.</q>
                            <footer>Mark O'Connor - Happy Customer</footer>
                        </blockquote>
                        <!-- End of Testimonial-->

                    </div>

                </aside>
                <!--End of Testimonials-->

                <!--Clients-->
                <section id="clients" class="scrollto clearfix">
                    <div class="row clearfix">

                        <div class="col-3">

                            <div class="section-heading">
                                <h3>TRUST</h3>
                                <h2 class="section-title">Companies our services integrate with</h2>
                                <p class="section-subtitle">We currently support a range of the largest selling sites
                                    available online.</p>
                            </div>

                        </div>

                        <div class="col-2-3">

                            <a href="#" class="col-3">
                                <img src="<c:url value="/resources/img/company-images/company-logo1.png"/>"
                                     alt="Company"/>
                                <div class="client-overlay"><span>Amazon</span></div>
                            </a>
                            <a href="#" class="col-3">
                                <img src="<c:url value="/resources/img/company-images/company-logo2.png"/>"
                                     alt="Company"/>
                                <div class="client-overlay"><span>Ebay</span></div>
                            </a>
                            <a href="#" class="col-3">
                                <img src="<c:url value="/resources/img/company-images/company-logo3.png"/>"
                                     alt="Company"/>
                                <div class="client-overlay"><span>Craigslist</span></div>
                            </a>
                            <a href="#" class="col-3">
                                <img src="<c:url value="/resources/img/company-images/company-logo4.png"/>"
                                     alt="Company"/>
                                <div class="client-overlay"><span>Gumtree</span></div>
                            </a>
                            <a href="#" class="col-3">
                                <img src="<c:url value="/resources/img/company-images/company-logo5.png"/>"
                                     alt="Company"/>
                                <div class="client-overlay"><span>Alibaba</span></div>
                            </a>
                            <a href="#" class="col-3">
                                <img src="<c:url value="/resources/img/company-images/company-logo6.png"/>"
                                     alt="Company"/>
                                <div class="client-overlay"><span>Etsy</span></div>
                            </a>
                            <a href="#" class="col-3">
                                <img src="<c:url value="/resources/img/company-images/company-logo7.png"/>"
                                     alt="Company"/>
                                <div class="client-overlay"><span>Ebid</span></div>
                            </a>
                            <a href="#" class="col-3">
                                <img src="<c:url value="/resources/img/company-images/company-logo8.png"/>"
                                     alt="Company"/>
                                <div class="client-overlay"><span>Bonanza</span></div>
                            </a>

                            <a href="#" class="col-3">
                                <img src="<c:url value="/resources/img/company-images/company-logo9.png"/>"
                                     alt="Company"/>
                                <div class="client-overlay"><span>Rakuten</span></div>
                            </a>

                        </div>

                    </div>
                </section>
                <!--End of Clients-->

                <!--Pricing Tables-->
                <section id="pricing" class="secondary-color text-center scrollto clearfix ">
                    <div class="row clearfix">

                        <div class="section-heading">
                            <h3>YOUR CHOICE</h3>
                            <h2 class="section-title">We have the right package for you</h2>
                        </div>

                        <!--Pricing Block-->
                        <div class="pricing-block col-3 wow fadeInUp" data-wow-delay="0.4s">
                            <div class="pricing-block-content">
                                <h3>Personal</h3>
                                <p class="pricing-sub">The standard version</p>
                                <div class="pricing">
                                    <div class="price"><span>£</span>9.99</div>
                                    <p>Recommended for users with medium-low selling rates</p>
                                </div>
                                <ul>
                                    <li>5 Items Monthly</li>
                                    <li>Up to 4 Trading Accounts</li>
                                    <li>Tutorials</li>
                                    <li>Forum Support</li>
                                </ul>
                                <a href="#" class="button">SUBSCRIBER TODAY</a>
                            </div>
                        </div>
                        <!--End Pricing Block-->

                        <!--Pricing Block-->
                        <div class="pricing-block featured col-3 wow fadeInUp" data-wow-delay="0.6s">
                            <div class="pricing-block-content">
                                <h3>Student</h3>
                                <p class="pricing-sub">Most popular choice</p>
                                <div class="pricing">
                                    <div class="price"><span>£</span>4.99</div>
                                    <p>Our student option makes it affordable to sell</p>
                                </div>
                                <ul>
                                    <li>5 Items Monthly</li>
                                    <li>Up to 4 Trading Accounts</li>
                                    <li>Tutorials with Files</li>
                                    <li>Forum Support</li>
                                </ul>
                                <a href="#" class="button">SUBSCRIBE TODAY</a>
                            </div>
                        </div>
                        <!--End Pricing Block-->

                        <!--Pricing Block-->
                        <div class="pricing-block col-3 wow fadeInUp" data-wow-delay="0.8s">
                            <div class="pricing-block-content">
                                <h3>Business</h3>
                                <p class="pricing-sub">For the whole team</p>
                                <div class="pricing">
                                    <div class="price"><span>£</span>19.99</div>
                                    <p>Our business deal allows for unlimited listings and selling opportunities</p>
                                </div>
                                <ul>
                                    <li>Unlimited Items Monthly</li>
                                    <li>Unlimited Trading Accounts</li>
                                    <li>HD Video Tutorials</li>
                                    <li>Chat Support</li>
                                </ul>
                                <a href="#" class="button">SUBSCRIBE TODAY</a>
                            </div>
                        </div>
                        <!--End Pricing Block-->

                    </div>
                </section>
                <!--End of Pricing Tables-->

            </main>
            <!--End Main Content Area-->


        </div>

        <!-- Include JavaScript resources -->
        <script src="<spring:url value="/resources/js/jquery.1.8.3.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/wow.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/featherlight.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/featherlight.gallery.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/jquery.enllax.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/jquery.scrollUp.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/jquery.easing.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/jquery.stickyNavbar.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/jquery.waypoints.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/images-loaded.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/lightbox.min.js"/>"></script>
        <script src="<spring:url value="/resources/js/site.js"/>"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>