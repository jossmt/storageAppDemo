$(document).ready(function () {

    $(".popupbutton").click(function () {

        var scrollTop     = $(window).scrollTop();

        var identifier = this.getAttribute("id");
        var identifierWrapper = identifier + "wrapper";
        var identifierText = identifier + "text";

        $(".popup").hide();
        $(".popuptext").hide();

        $("#" + identifierWrapper).css("margin-top", scrollTop + 100);

        $("#" + identifierWrapper).show();
        $("#" + identifierText).show();

    });

    $(".cancel").click(function () {
        $(".popup").hide();
        $(".popuptext").hide();
    });

    $("input[type=radio][name=usePaypal]").change(function () {
        if (this.value === 'true') {
            $('#paypalDetails').show();
            $('#cardDetails').hide();
        }
        else {
            $('#paypalDetails').hide();
            $('#cardDetails').show();
        }
    });

    $("input[type=radio][name='itemListing.deliveryType']").change(function () {
        if (this.value === 'COLLECTION') {
            $('#deliveryCharge').hide();
        }
        else {
            $('#deliveryCharge').show();
        }
    });

    $(window).on("load", function () {
        $(window).scroll(function () {
            var windowBottom = $(this).scrollTop() + $(this).innerHeight();
            $(".fade").each(function () {
                /* Check the location of each desired element */
                var objectBottom = $(this).offset().top + $(this).outerHeight();

                /* If the element is completely within bounds of the window, fade it in */
                if (objectBottom < windowBottom) { //object comes into view (scrolling down)
                    if ($(this).css("opacity") == 0) {
                        $(this).fadeTo(500, 1);
                    }
                } else { //object goes out of view (scrolling up)
                    if ($(this).css("opacity") == 1) {
                        $(this).fadeTo(500, 0);
                    }
                }
            });
        }).scroll(); //invoke scroll-handler on page-load
    });


    //Signup shit

//jQuery time
    var current_fs, next_fs, previous_fs; //fieldsets
    var left, opacity, scale; //fieldset properties which we will animate
    var animating; //flag to prevent quick multi-click glitches

    $(".next").click(function () {
        if (animating) return false;
        animating = true;

        current_fs = $(this).parent();
        next_fs = $(this).parent().next();

        //activate next step on progressbar using the index of next_fs
        $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

        //show the next fieldset
        next_fs.show();
        //hide the current fieldset with style
        current_fs.animate({opacity: 0}, {
            step: function (now, mx) {
                //as the opacity of current_fs reduces to 0 - stored in "now"
                //1. scale current_fs down to 80%
                scale = 1 - (1 - now) * 0.2;
                //2. bring next_fs from the right(50%)
                left = (now * 50) + "%";
                //3. increase opacity of next_fs to 1 as it moves in
                opacity = 1 - now;
                current_fs.css({
                    'transform': 'scale(' + scale + ')',
                    'position': 'absolute'
                });
                next_fs.css({'left': left, 'opacity': opacity});
            },
            duration: 800,
            complete: function () {
                current_fs.hide();
                animating = false;
            },
            //this comes from the custom easing plugin
            easing: 'easeInOutBack'
        });
    });

    $(".previous").click(function () {
        if (animating) return false;
        animating = true;

        current_fs = $(this).parent();
        previous_fs = $(this).parent().prev();

        //de-activate current step on progressbar
        $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

        //show the previous fieldset
        previous_fs.show();
        //hide the current fieldset with style
        current_fs.animate({opacity: 0}, {
            step: function (now, mx) {
                //as the opacity of current_fs reduces to 0 - stored in "now"
                //1. scale previous_fs from 80% to 100%
                scale = 0.8 + (1 - now) * 0.2;
                //2. take current_fs to the right(50%) - from 0%
                left = ((1 - now) * 50) + "%";
                //3. increase opacity of previous_fs to 1 as it moves in
                opacity = 1 - now;
                current_fs.css({'left': left});
                previous_fs.css({'transform': 'scale(' + scale + ')', 'opacity': opacity});
            },
            duration: 800,
            complete: function () {
                current_fs.hide();
                animating = false;
            },
            //this comes from the custom easing plugin
            easing: 'easeInOutBack'
        });
    });

});

/**
 * Redirects to item page.
 *
 * @param item Item page
 */
function redirectToItemPage(itemid) {
    var pathArray = window.location.pathname.split('/');
    var baseurl = window.location.host + "/" + pathArray[1];

    alert(baseurl + "/item/" + itemid);
    window.location.href = baseurl + "/item?" + itemid;
    return;
};

function readFileUrl(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imagewrapper').empty();
            $('#imageRender')
                .attr('src', e.target.result).show();
        };

        reader.readAsDataURL(input.files[0]);
    }
};