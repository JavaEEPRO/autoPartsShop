





$(document).ready(function () {

    $('#clear-drop-zone-btn').on('mouseover', function () {
        $('.customized-recycle').addClass('red')})
                             .on('mouseout', function(){
        $('.customized-recycle').removeClass('red');
    });



    /* progress bar */

    var $$ = document.querySelectorAll(".progress-bar span");
    var prgressBars= document.querySelectorAll(".progress-bar");
    var p = 0;

    setInterval(function(){
        p++;
        if(p>100){p=0;}
        for(var i = 0;i< $$.length;i++){
            $$[i].innerHTML = "progress "+p+" %";
        }
        for(var i = 0;i< prgressBars.length;i++){
            prgressBars[i].lastChild.style.clip = "rect(0 "+p*2+"px 40px 0)";
        }
    },1000);
    /* end of progress bar */



    /*$('li.dropdown').on('mouseover', function(){ $(this).addClass('open'); }); $('li.dropdown').on('mouseout', function(){ $(this).removeClass('open'); });*/

   /* $('.dropdown').hover(function() {
        $(this).find('.dropdown-menu').first().stop(true, true).delay(250).slideDown();
    }, function() {
        $(this).find('.dropdown-menu').first().stop(true, true).delay(100).slideUp()
    });*/


    $("#accountDropdown").on('click', function(){
        /*var serverContext = [[@{/}]];*/
        window.location.href = "/login";
    });




    /* "my account' link (in navbar header) - similar activation on 'hover' event - icon-to-link addiction */

    $('.account-link').on('mouseover', function(){
        $('.account-i').addClass('active');
    }).on('mouseout', function(){
        $('.account-i').removeClass('active');
    });

    $('.account-i').on('mouseover', function(){
        $('.account-link').addClass('active');
    }).on('mouseout', function(){
        $('.account-link').removeClass('active');
    });

    /*$('.account-link').on('click', function(){
        if($('.account-i').hasClass('active')) {$('.account-i').removeClass('active');}
        else {$('.account-i').addClass('active');}
    });

    $('.account-i').on('click', function(){
        if($('.account-link').hasClass('active')) {$('.account-link').removeClass('active');}
        else {$('.account-link').addClass('active');}
    });*/



    /*    logo blink    */

    setInterval(function(){
        $('#string>span').addClass('blink_on');
        setTimeout(function(){$('#string>span').removeClass('blink_on')},1500);
    },6000)

    /* end of logo blink */

});



