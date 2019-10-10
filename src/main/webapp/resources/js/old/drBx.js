


//
// var holder = document.getElementById('as-u5-fileToUpload'),
// upl = document.getElementById('uplContainer'),
//     lbl = document.getElementById('lbl-upl'),
//     pa = document.getElementsByClassName('photo-area'),
//     tests = {
//         filereader: typeof FileReader !== 'undefined',
//         dnd: 'draggable' in document.createElement('span'),
//         formdata: !!window.FormData,
//         progress: "upload" in new XMLHttpRequest
//     },
//     support = {
//         filereader: document.getElementById('filereader'),
//         formdata: document.getElementById('formdata'),
//         progress: document.getElementById('progress')
//     },
//     acceptedTypes = {
//         'image/png': true,
//         'image/jpeg': true,
//         'image/gif': true
//     },
//     progress = document.getElementById('uploadprogress'),
//     fileupload = document.getElementById('upload');
//
// upl.addEventListener('change',function(event){
// var files = event.target.files;
// event.preventDefault();
// readfiles(files);
// });
//
//
// "filereader formdata progress".split(' ').forEach(function (api) {
//     if (tests[api] === false) {
//         support[api].className = 'fail';
//     } else {
//         support[api].className = 'hidden';
//     }
// });
//
// function previewfile(file) {
//     if (tests.filereader === true && acceptedTypes[file.type] === true) {
//         var reader = new FileReader();
//         reader.onload = function (event) {
//             var image = new Image();
//             image.src = event.target.result;
//             image.width = 250; // a fake resize
//             holder.appendChild(image);
//             holder.removeChild(upl);
//             lbl.replaceWith("   reading path...");
//         };
//
//         reader.readAsDataURL(file);
//     }  else {
//         holder.innerHTML += '<p>Uploaded ' + file.name + ' ' + (file.size ? (file.size/1024|0) + 'K' : '');
//         console.log(file);
//     }
// }
//
// function readfiles(files) {
//     debugger;
//     var formData = tests.formdata ? new FormData() : null;
//     for (var i = 0; i < files.length; i++) {
//         if (tests.formdata) formData.append('file', files[i]);
//         previewfile(files[i]);
//     }
//
//
//     if (tests.formdata) {
//         var xhr = new XMLHttpRequest();
//         xhr.open('POST', '/Profile/StorePhoto');
//         xhr.onload = function () {
//             progress.value = progress.innerHTML = 100;
//         };
//
//         if (tests.progress) {
//             xhr.upload.onprogress = function (event) {
//                 if (event.lengthComputable) {
//                     var complete = (event.loaded / event.total * 100 | 0);
//                     progress.value = progress.innerHTML = complete;
//                 }
//             };
//         }
//
//         xhr.send(formData);
//         //console.log('files sent successfully');
//     }



    /*
    if (tests.formdata){
        as.uploadHTML5.init( { url: '/Profile/StorePhoto/' } );
        as.uploadHTML5.upload(formData);
    }
    */

// }
//
// if (tests.dnd) {
//     holder.ondragover = function () { this.className = 'hover'; return false; };
//     holder.ondragend = function () { this.className = ''; return false; };
//     holder.ondrop = function (e) {
//         this.className = '';
//         e.preventDefault();
//         readfiles(e.dataTransfer.files);
//     }
// } else {
//     fileupload.className = 'hidden';
//     fileupload.querySelector('input').onchange = function () {
//         readfiles(this.files);
//     };
// }
//








debugger;
function include(url) {
    var script = document.createElement('script');
    script.src = url;
    document.getElementsByTagName('head')[0].appendChild(script);
}

include('/js/AS/controls/as.uploadHTML5.js');
as.uploadHTML5 && as.uploadHTML5.init('/Profile/StorePhoto');

var hldr = document.getElementById('as-u5-fileToUpload'),
    uplContainer = document.getElementById('uplContainer');


function removeThumb() {
    thmb = document.getElementById('thmb');
    thmb != null? thmb.remove() : "";
}

function handleFileSelect(evt) {
    removeThumb();
    thmb = document.getElementById('thmb');
    var file = evt.target.files;
    var f = file[0];
    if (!f.type.match('image.*')) {
        alert("Image only please....");
    }
    var reader = new FileReader();

    reader.onload = (function(theFile) {
        return function(e) {
            var image = new Image();
            image.src = e.target.result;
            image.width = 111;
            image.id = "thmb";
            image.title = "user main profile photo (" + theFile.name + ")";
            if (thmb != null) {thmb.remove();}
            uplContainer.appendChild(image);
        };
    })(f);

    reader.readAsDataURL(f);
    //as.uploadHTML5.upload();
}
document.getElementById('as-u5-fileToUpload').addEventListener('change', handleFileSelect, false);
document.getElementById('submit').addEventListener('click', alert('test passed'));
















//
// var holder = document.getElementById('as-u5-fileToUpload'),
// upl = document.getElementById('uplContainer'),
//     lbl = document.getElementById('lbl-upl'),
//     pa = document.getElementsByClassName('photo-area'),
//     tests = {
//         filereader: typeof FileReader !== 'undefined',
//         dnd: 'draggable' in document.createElement('span'),
//         formdata: !!window.FormData,
//         progress: "upload" in new XMLHttpRequest
//     },
//     support = {
//         filereader: document.getElementById('filereader'),
//         formdata: document.getElementById('formdata'),
//         progress: document.getElementById('progress')
//     },
//     acceptedTypes = {
//         'image/png': true,
//         'image/jpeg': true,
//         'image/gif': true
//     },
//     progress = document.getElementById('uploadprogress'),
//     fileupload = document.getElementById('upload');
//
// upl.addEventListener('change',function(event){
// var files = event.target.files;
// event.preventDefault();
// readfiles(files);
// });
//
//
// "filereader formdata progress".split(' ').forEach(function (api) {
//     if (tests[api] === false) {
//         support[api].className = 'fail';
//     } else {
//         support[api].className = 'hidden';
//     }
// });
//
// function previewfile(file) {
//     if (tests.filereader === true && acceptedTypes[file.type] === true) {
//         var reader = new FileReader();
//         reader.onload = function (event) {
//             var image = new Image();
//             image.src = event.target.result;
//             image.width = 250; // a fake resize
//             holder.appendChild(image);
//             holder.removeChild(upl);
//             lbl.replaceWith("   reading path...");
//         };
//
//         reader.readAsDataURL(file);
//     }  else {
//         holder.innerHTML += '<p>Uploaded ' + file.name + ' ' + (file.size ? (file.size/1024|0) + 'K' : '');
//         console.log(file);
//     }
// }
//
// function readfiles(files) {
//     debugger;
//     var formData = tests.formdata ? new FormData() : null;
//     for (var i = 0; i < files.length; i++) {
//         if (tests.formdata) formData.append('file', files[i]);
//         previewfile(files[i]);
//     }
//
//
//     if (tests.formdata) {
//         var xhr = new XMLHttpRequest();
//         xhr.open('POST', '/Profile/StorePhoto');
//         xhr.onload = function () {
//             progress.value = progress.innerHTML = 100;
//         };
//
//         if (tests.progress) {
//             xhr.upload.onprogress = function (event) {
//                 if (event.lengthComputable) {
//                     var complete = (event.loaded / event.total * 100 | 0);
//                     progress.value = progress.innerHTML = complete;
//                 }
//             };
//         }
//
//         xhr.send(formData);
//         //console.log('files sent successfully');
//     }
//
//
//
//     /*
//     if (tests.formdata){
//         as.uploadHTML5.init( { url: '/Profile/StorePhoto/' } );
//         as.uploadHTML5.upload(formData);
//     }
//     */
//
// }
//
// if (tests.dnd) {
//     holder.ondragover = function () { this.className = 'hover'; return false; };
//     holder.ondragend = function () { this.className = ''; return false; };
//     holder.ondrop = function (e) {
//         this.className = '';
//         e.preventDefault();
//         readfiles(e.dataTransfer.files);
//     }
// } else {
//     fileupload.className = 'hidden';
//     fileupload.querySelector('input').onchange = function () {
//         readfiles(this.files);
//     };
// }