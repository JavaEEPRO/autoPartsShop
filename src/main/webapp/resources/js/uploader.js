//debugger;

let dropArea = document.getElementById('drop-area');
let multipleAdsButton = document.getElementById('multiple-ads-button');

let uploadProgress = [];
let progressBar = document.getElementById('progress-bar');

['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, preventDefaults, false)
});

function preventDefaults (e) {
    e.preventDefault();
    e.stopPropagation();
}

['dragenter', 'dragover'].forEach(eventName => {
    dropArea.addEventListener(eventName, highlight, false)
});

['dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, unhighlight, false)
});

function highlight(e) {
    dropArea.classList.add('highlight');
}

function unhighlight(e) {
    dropArea.classList.remove('highlight')
}

dropArea.addEventListener('drop', handleDrop, false);

function handleDrop(e) {
    let dt = e.dataTransfer;
    let files = dt.files;
    handleFiles(files)
}

function handleFiles(files) {
    files = [...files];
    initializeProgress(files.length); // <- Добавили эту строку
    files.forEach(uploadFile);
    files.forEach(previewFile);
}

function uploadFile(file, i) { // <- Добавили параметр `i`



    var url ='/savePhoto';
    var xhr = new XMLHttpRequest();
    var formData = new FormData();
    xhr.open('POST', url, true);
    // Добавили следующие слушатели
    xhr.upload.addEventListener("progress", function(e) {
        updateProgress(i, (e.loaded * 100.0 / e.total) || 100)

    });
    xhr.addEventListener('readystatechange', function(e) {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Готово. Сообщаем пользователю
        }
        else if (xhr.readyState === 4 && xhr.status !== 200) {
            // Ошибка. Сообщаем пользователю
        }
    });
    formData.append('file', file);
    xhr.send(formData);
}

function previewFile(file) {
    let reader = new FileReader();
    let counter = 0;
    reader.readAsDataURL(file);
    reader.onloadend = function() {
        let img = document.createElement('img');
        img.src = reader.result;
        document.getElementById('gallery').appendChild(img);
        counter ++;
        dropArea.classList.add('move-down');
        multipleAdsButton.classList.add('hidden');
    }
}

function initializeProgress(numFiles) {
    progressBar.value = 0;
    uploadProgress = [];
    for(let i = numFiles; i > 0; i--) {
        uploadProgress.push(0);
    }
}

//var $$ = document.querySelectorAll(".progress-bar span");
//var prgressBars= document.querySelectorAll(".progress-bar");
//var p = 0;



function updateProgress(fileNumber, percent) {

    uploadProgress[fileNumber] = percent;


/*
        p++;
        if(p>100){p=0;}
        for(var i = 0;i< $$.length;i++){
            $$[i].innerHTML = "progress "+p+" %";
        }
        for(var i = 0;i< progressBar.length;i++){
            progressBar[i].lastChild.style.clip = "rect(0 "+p*2+"px 40px 0)";
        }

*/

    let total = uploadProgress.reduce((tot, curr) => tot + curr, 0) / uploadProgress.length;


    for (let i = 0; i < 101; i ++)
    {

        setTimeout(function () {
            progressBar.value ++;
            //console.log("value : " + progressBar.value);
        },4*(i+1));
    }

    //progressBar.value = total
    //if (progressBar.value > 99) {
        setTimeout(function(){
            for (var i = 101; i < 201; i ++)
            {

                setTimeout(function () {
                    progressBar.value --;
                    //console.log("value : " + progressBar.value);
                },2*(i+1));
            }
            //progressBar.value = 0;
        },1000);
        //progressBar.value = 0;
    // } else if (progressBar.value < 1) {
    //
    //     for (var i = 1; i < 101; i ++)
    //     {
    //         setTimeout(function () {
    //             progressBar.value ++;
    //             console.log("value : " + progressBar.value);
    //         },130*(i+1));
    //     }
    //  }else if (progressBar.value < 1) {
    //
    //     for (let i = 0; i < 100; i++) {
    //         setTimeout(function () {
    //             progressBar.value++;
    //             console.log("value : " + progressBar.value);
    //         }, 130 * (i + 1));
    //     }
     //}
}


// my customization :)

let gallery = document.getElementById('gallery');

function clearDropZone(object) {
    //gallery.empty();
    //gallery.children().remove();

    while (object.firstChild) {
        object.removeChild(object.firstChild);
    }
    progressBar.value = 0;
}

function clearProgressBar() {
$('#progress-bar').removeClass('.progress-bar span:last-child');
$('.progress-bar span:last-child').addClass('grey');
    $('.progress-bar').addClass('grey')
//$('#span-progressive-1').hidden;
}

$(document).ready(function () {
    $('#clear-drop-zone-btn').on('click', function () {
        clearDropZone(gallery);
        //clearProgressBar();
        //clearDropZone($('.progress-bar'));
        //document.getElementById('gallery').chil.remove();
    });
});























/*
*
*
* cонечко, вибач, зовсім вилетіло з голови...
*
*    вітаю Тебе, Анютка, і бажаю
* тобі натхнення - щоб горіло серце,
* щоб вистачило сил здолати все це -
* 
*
*
* */





















