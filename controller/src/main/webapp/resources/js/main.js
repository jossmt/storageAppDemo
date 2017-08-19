$(document).ready(function () {

    $('abouttext').fadeIn('slow', function () {
        // Animation complete
    });

    $("#aboutnav", "#howitworksnav").click(function () {
        $('html, body').animate({
            scrollTop: $(window.location.hash).offset().top
        }, 2000);
    });

    // $(window).on("load",function() {
    //     $(window).scroll(function() {
    //         var windowBottom = $(this).scrollTop() + $(this).innerHeight();
    //         $(".fade").each(function() {
    //             /* Check the location of each desired element */
    //             var objectBottom = $(this).offset().top + $(this).outerHeight();
    //
    //             /* If the element is completely within bounds of the window, fade it in */
    //             if (objectBottom < windowBottom) { //object comes into view (scrolling down)
    //                 if ($(this).css("opacity")==0) {$(this).fadeTo(500,1);}
    //             } else { //object goes out of view (scrolling up)
    //                 if ($(this).css("opacity")==1) {$(this).fadeTo(500,0);}
    //             }
    //         });
    //     }).scroll(); //invoke scroll-handler on page-load
    // });

});

/**
 * Redirects to item page.
 *
 * @param item Item page
 */
function redirectToItemPage(itemid) {
    var pathArray = window.location.pathname.split( '/' );
    var baseurl = window.location.host + "/" + pathArray[1];

    alert(baseurl + "/item/" + itemid);
    window.location.href = baseurl + "/item?" + itemid;
    return;
};