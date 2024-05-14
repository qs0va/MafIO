document.addEventListener('DOMContentLoaded', onload, false);

function onload() {
    document.getElementById("mainList").innerHTML=makeList(JSON.parse(getFromServer()))
}

function makeList(jsArray) {
    let out = ""
    for (let i = 0; i < jsArray.length; i++) {
        out = out + "<li><a href=\"../players/" + jsArray[i].id + "\">" + jsArray[i].nickname + "</a></li>" + "\n"
    }
    return out
}

function getFromServer() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '../data/players', false);
    xhr.send();
    return xhr.responseText
}