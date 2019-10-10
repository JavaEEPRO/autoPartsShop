if (!window.jQuery) {document.write(unescape("%3Cscript src='https://code.jquery.com/jquery-3.4.1.js' integrity='sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=' crossorigin='anonymous' %3E%3C/script%3E")); }

function resetClassesForSliderThroughKey(key) {
    $("#controls"+ key + " label:nth-child(1)").removeClass('move-to-left move-to-right');
    $("#controls" + key + " label:nth-child(2)").removeClass('move-to-left move-to-right');
    $("#controls" + key + " label:nth-child(3)").removeClass('move-to-left move-to-right');
    $("#controls" + key + " label:nth-child(4)").removeClass('move-to-left move-to-right');
    $("#controls" + key + " label:nth-child(5)").removeClass('move-to-left move-to-right');

    $("#actives" + key + " label:nth-child(1)").removeClass('active-lbl');
    $("#actives" + key + " label:nth-child(2)").removeClass('active-lbl');
    $("#actives" + key + " label:nth-child(3)").removeClass('active-lbl');
    $("#actives" + key + " label:nth-child(4)").removeClass('active-lbl');
    $("#actives" + key + " label:nth-child(5)").removeClass('active-lbl');

    $("#image" + key).removeClass('margin-left-0');
    $("#image" + key).removeClass('margin-left-100');
    $("#image" + key).removeClass('margin-left-200');
    $("#image" + key).removeClass('margin-left-300');
    $("#image" + key).removeClass('margin-left-400');
}




